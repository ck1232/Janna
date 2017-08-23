package com.JJ.service.filelinkmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.ImageLinkVO;
import com.JJ.dao.FileLinkDbObjectMapper;
import com.JJ.dao.ImageLinkRsDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.FileLinkDbObject;
import com.JJ.model.FileLinkDbObjectExample;
import com.JJ.model.ImageLinkRsDbObject;
import com.JJ.model.ImageLinkRsDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ImageService {
	private ImageLinkRsDbObjectMapper imageLinkRsDbObjectMapper;
	private FileLinkDbObjectMapper fileLinkDbObjectMapper;
	@Autowired
	public ImageService(ImageLinkRsDbObjectMapper imageLinkRsDbObjectMapper,
			FileLinkDbObjectMapper fileLinkDbObjectMapper){
		this.imageLinkRsDbObjectMapper = imageLinkRsDbObjectMapper;
		this.fileLinkDbObjectMapper = fileLinkDbObjectMapper;
	}
	
	public Map<Integer, List<ImageLinkVO>> getAllImageLinkByRefTypeAndIdList(String refType, List<Integer> refIdList) {//categoryid
		ImageLinkRsDbObjectExample imageLinkExample = new ImageLinkRsDbObjectExample();
		imageLinkExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andRefTypeEqualTo(refType).andRefIdIn(refIdList);
		List<ImageLinkRsDbObject> imageLinkRsList = imageLinkRsDbObjectMapper.selectByExample(imageLinkExample);
		
		List<Integer> idList = GeneralUtils.convertListToIntegerList(imageLinkRsList, "imageLinkId");
		Map<Integer, List<ImageLinkRsDbObject>> imageLinkRsMap = GeneralUtils.convertListToIntegerListMap(imageLinkRsList, "refId");
		
		Map<Integer, List<ImageLinkVO>> map = new HashMap<Integer, List<ImageLinkVO>>();
		if(!idList.isEmpty()) {
			FileLinkDbObjectExample fileLinkExample = new FileLinkDbObjectExample();
			fileLinkExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andFileLinkIdIn(idList);
			List<FileLinkDbObject> dbObjList = fileLinkDbObjectMapper.selectByExample(fileLinkExample);
			Map<Integer, FileLinkDbObject> fileLinkMap = GeneralUtils.convertListToIntegerMap(dbObjList, "fileLinkId");
			map = convertToImageLinkVOMap(fileLinkMap, imageLinkRsMap);
		}
		
		return map;
	}
	
	public void saveImageLink(ImageLinkVO imageVO) {
		if(imageVO == null){ 
			return;
		}
		if(imageVO.getImageLinkId() != null){ //existing
			ImageLinkRsDbObject dbObj = convertToExistingImageLinkRsDbObject(imageVO);
			imageLinkRsDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}else{ //new
			FileLinkDbObject fileLinkDbObj = convertToFileLinkDbObject(imageVO);
			fileLinkDbObjectMapper.insert(fileLinkDbObj);
			imageVO.setImageLinkId(fileLinkDbObj.getFileLinkId());
			ImageLinkRsDbObject imageLinkRsDbObj = convertToNewImageLinkRsDbObject(imageVO);
			imageLinkRsDbObjectMapper.insert(imageLinkRsDbObj);
		}
	}
	
	public void deleteImageLink(ImageLinkVO imageVO) {
		if(imageVO == null || imageVO.getImageLinkId() == null) {
			return;
		}
		
		FileLinkDbObjectExample fileLinkExample = new FileLinkDbObjectExample();
		fileLinkExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andFileLinkIdEqualTo(imageVO.getImageLinkId());
		FileLinkDbObject dbObj = new FileLinkDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		fileLinkDbObjectMapper.updateByExampleSelective(dbObj, fileLinkExample);
		
		ImageLinkRsDbObjectExample imageLinkExample = new ImageLinkRsDbObjectExample();
		imageLinkExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andRefTypeEqualTo(imageVO.getRefType())
					.andRefIdEqualTo(imageVO.getRefId()).andImageLinkIdEqualTo(imageVO.getImageLinkId());
		ImageLinkRsDbObject imageLinkRs = new ImageLinkRsDbObject();
		imageLinkRs.setDeleteInd(GeneralUtils.DELETED);
		imageLinkRs.setSequence(0);
		imageLinkRsDbObjectMapper.updateByExampleSelective(imageLinkRs, imageLinkExample);
	}
	
	
	
	private ImageLinkRsDbObject convertToNewImageLinkRsDbObject(ImageLinkVO imageVO) {
		ImageLinkRsDbObject dbObj = new ImageLinkRsDbObject();
		if(imageVO != null && imageVO.getImageLinkId() != null) {
			dbObj.setImageLinkRsId(imageVO.getImageLinkRsId());
			dbObj.setSequence(imageVO.getSequence());
			dbObj.setImageLinkId(imageVO.getImageLinkId());
			dbObj.setRefType(GeneralUtils.TYPE_PRODUCT_CATEGORY);
			dbObj.setRefId(imageVO.getRefId());
		}
		return dbObj;
	}

	private FileLinkDbObject convertToFileLinkDbObject(ImageLinkVO imageVO) {
		FileLinkDbObject dbObj = new FileLinkDbObject();
		dbObj.setFilePath(GeneralUtils.CATEGORY_PATH+imageVO.getFileName());
		return dbObj;
	}

	private ImageLinkRsDbObject convertToExistingImageLinkRsDbObject(ImageLinkVO imageVO) {
		ImageLinkRsDbObject dbObj = new ImageLinkRsDbObject();
		if(imageVO != null && imageVO.getImageLinkId() != null) {
			dbObj.setImageLinkRsId(imageVO.getImageLinkRsId());
			dbObj.setSequence(imageVO.getSequence());
		}
		return dbObj;
	}

	private Map<Integer, List<ImageLinkVO>> convertToImageLinkVOMap(Map<Integer, FileLinkDbObject> fileLinkMap, Map<Integer, List<ImageLinkRsDbObject>> imageLinkRsMap) {
		Map<Integer, List<ImageLinkVO>> imageLinkMap = new HashMap<Integer, List<ImageLinkVO>>();
		if(imageLinkRsMap != null && !imageLinkRsMap.isEmpty()){
			for(Integer refId : imageLinkRsMap.keySet()) {
				List<ImageLinkRsDbObject> rsList = imageLinkRsMap.get(refId);
				if(rsList != null && !rsList.isEmpty()) {
					for(ImageLinkRsDbObject rsDbObj : rsList) {
						FileLinkDbObject dbObj = fileLinkMap.get(rsDbObj.getImageLinkId());
						if(dbObj!=null){
							ImageLinkVO vo = new ImageLinkVO();
							vo.setImageLinkId(dbObj.getFileLinkId());
							vo.setImagePath(dbObj.getFilePath());
							vo.setDisplayPath(vo.getDisplayPath());
							vo.setSequence(rsDbObj.getSequence());
							vo.setImageLinkRsId(rsDbObj.getImageLinkRsId());
							vo.setRefType(rsDbObj.getRefType());
							vo.setRefId(refId);
							if(!imageLinkMap.containsKey(refId)){
								imageLinkMap.put(refId, new ArrayList<ImageLinkVO>());
							}
							imageLinkMap.get(refId).add(vo);
						}
					}
				}
			}
		}
		return imageLinkMap;
	}
}
