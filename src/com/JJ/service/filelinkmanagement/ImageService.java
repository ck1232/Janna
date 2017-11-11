package com.JJ.service.filelinkmanagement;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.FileMetaVO;
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
	@Value("${image.folder}")
    private String imageFolderSource;
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
	
	public Map<Integer, LinkedList<ImageLinkVO>> getAllImageLinkByRefTypeAndIdListOrdered(String refType, List<Integer> refIdList){
		ImageLinkRsDbObjectExample imageLinkExample = new ImageLinkRsDbObjectExample();
		imageLinkExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andRefTypeEqualTo(refType).andRefIdIn(refIdList);
		List<ImageLinkRsDbObject> imageLinkRsList = imageLinkRsDbObjectMapper.selectByExample(imageLinkExample);
		
		List<Integer> idList = GeneralUtils.convertListToIntegerList(imageLinkRsList, "imageLinkId");
		Map<Integer, List<ImageLinkRsDbObject>> imageLinkRsMap = GeneralUtils.convertListToIntegerListMap(imageLinkRsList, "refId");
		
		Map<Integer, LinkedList<ImageLinkVO>> map = new HashMap<Integer, LinkedList<ImageLinkVO>>();
		if(!idList.isEmpty()) {
			FileLinkDbObjectExample fileLinkExample = new FileLinkDbObjectExample();
			fileLinkExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andFileLinkIdIn(idList);
			List<FileLinkDbObject> dbObjList = fileLinkDbObjectMapper.selectByExample(fileLinkExample);
			Map<Integer, FileLinkDbObject> fileLinkMap = GeneralUtils.convertListToIntegerMap(dbObjList, "fileLinkId");
			map = convertToImageLinkVOMapOrdered(fileLinkMap, imageLinkRsMap);
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
	
	public ImageLinkVO convertFileMetaVOToImageLinkVO(FileMetaVO fileVO, int refId, String type) {
		ImageLinkVO imageVO = new ImageLinkVO();
		imageVO.setRefType(type);
		imageVO.setRefId(refId);
		imageVO.setImagePath(imageFolderSource+type+"\\"+fileVO.getFileName());
		imageVO.setSequence(fileVO.getSequence());
		imageVO.setFileName(fileVO.getFileName());
		imageVO.setBytes(fileVO.getBytes());
		return imageVO;
	}
	
	public LinkedList<FileMetaVO> convertImageLinkVOToFileMetaVO(LinkedList<ImageLinkVO> imageLinkVOList) {
		LinkedList<FileMetaVO> fileMetaVOList = new LinkedList<FileMetaVO>();
		if(imageLinkVOList != null && !imageLinkVOList.isEmpty()){
			for(ImageLinkVO image: imageLinkVOList){
				FileMetaVO metaVO = new FileMetaVO();
				metaVO.setFileName(image.getFileName());
				metaVO.setFileSize("100KB");
				fileMetaVOList.add(metaVO);
			}
		}
		return fileMetaVOList;
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
			dbObj.setRefType(imageVO.getRefType());
			dbObj.setRefId(imageVO.getRefId());
		}
		return dbObj;
	}

	private FileLinkDbObject convertToFileLinkDbObject(ImageLinkVO imageVO) {
		FileLinkDbObject dbObj = new FileLinkDbObject();
		dbObj.setFilePath(imageVO.getImagePath());
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

	private Map<Integer, LinkedList<ImageLinkVO>> convertToImageLinkVOMapOrdered(
			Map<Integer, FileLinkDbObject> fileLinkMap,
			Map<Integer, List<ImageLinkRsDbObject>> imageLinkRsMap) {
		Map<Integer, LinkedList<ImageLinkVO>> imageLinkMap = new HashMap<Integer, LinkedList<ImageLinkVO>>();
		if(imageLinkRsMap != null && !imageLinkRsMap.isEmpty()){
			for(Integer refId : imageLinkRsMap.keySet()) {
				List<ImageLinkRsDbObject> rsList = imageLinkRsMap.get(refId);
				if(rsList != null && !rsList.isEmpty()) {
					//order the rsDbObj
					Collections.sort(rsList, new Comparator<ImageLinkRsDbObject>(){

						@Override
						public int compare(ImageLinkRsDbObject o1,
								ImageLinkRsDbObject o2) {
							if(o1.getSequence() != null && o2.getSequence() != null){
								return o1.getSequence().compareTo(o2.getSequence());
							}else if(o1.getSequence() != null){
								return -1;
							}else if(o2.getSequence() != null){
								return 1;
							}
							return 0;
						}
						
					});
					for(ImageLinkRsDbObject rsDbObj : rsList) {
						FileLinkDbObject dbObj = fileLinkMap.get(rsDbObj.getImageLinkId());
						if(dbObj!=null){
							ImageLinkVO vo = new ImageLinkVO();
							vo.setImageLinkId(dbObj.getFileLinkId());
							vo.setImagePath(dbObj.getFilePath());
							if(dbObj.getFilePath() != null && !dbObj.getFilePath().trim().isEmpty()){
								int index = dbObj.getFilePath().lastIndexOf("\\");
								if(index > 0){
									String fileName = dbObj.getFilePath().substring(index+1);
									vo.setFileName(fileName);
								}
							}
							vo.setDisplayPath(vo.getDisplayPath());
							vo.setSequence(rsDbObj.getSequence());
							vo.setImageLinkRsId(rsDbObj.getImageLinkRsId());
							vo.setRefType(rsDbObj.getRefType());
							vo.setRefId(refId);
							//TODO set bytes here
							if(!imageLinkMap.containsKey(refId)){
								imageLinkMap.put(refId, new LinkedList<ImageLinkVO>());
							}
							imageLinkMap.get(refId).add(vo);
						}
					}
				}
			}
		}
		return imageLinkMap;
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
							//TODO set bytes
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
	
	private boolean checkFileExist(String path){
		File file = new File(path);
		if(file.exists()){
			return true;
		}
		return false;
	}
	
	public boolean uploadFileToDisk(ImageLinkVO img) {
		//fileName - filename.jpg
		//img.imagePath - d://images/category\filename.jpg
		//
		try {
			int i = 1;
			int s = StringUtils.ordinalIndexOf(img.getImagePath(), "/", 3);
			String fileLoc = imageFolderSource.replace("/", "\\")+img.getImagePath().substring(s+1);
			int periodIndex = fileLoc.lastIndexOf(".");
			int slashIndex = fileLoc.lastIndexOf("\\");
			String fileName = fileLoc.substring(slashIndex+1, periodIndex);
			
			while(checkFileExist(fileLoc)){
				fileLoc = fileLoc.substring(0,slashIndex+1) + fileName + "_" + i + fileLoc.substring(periodIndex);
				periodIndex = fileLoc.lastIndexOf(".");
				slashIndex = fileLoc.lastIndexOf("\\");
				img.setFileName(fileLoc.substring(slashIndex+1));
				i++;
			}
			img.setImagePath(fileLoc);
			FileOutputStream fos = new FileOutputStream(img.getImagePath());
			fos.write(img.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ImageLinkVO readImageFromURL(ImageLinkVO imageLinkVO) {
		try{
		URL url = new URL("http://localhost:8080/JJ/images/product/"+imageLinkVO.getFileName());
        BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
		imageLinkVO.setBytes(baos.toByteArray());
		}catch(Exception ex){
			
		}
		return imageLinkVO;
	}
}
