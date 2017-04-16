package com.JJ.service.storagelocationmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.vo.StorageLocationVO;
import com.JJ.dao.StorageLocationDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.StorageLocationDbObject;
import com.JJ.model.StorageLocationDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class StorageLocationManagementService {
	
	private StorageLocationDbObjectMapper storageLocationDbObjectMapper;
	
	@Autowired
	public StorageLocationManagementService(StorageLocationDbObjectMapper storageLocationDbObjectMapper) {
		this.storageLocationDbObjectMapper = storageLocationDbObjectMapper;
	}
	
	public StorageLocationVO findById(Integer id) {
		StorageLocationDbObject dbObj = storageLocationDbObjectMapper.selectByPrimaryKey(id);
		if(dbObj != null && dbObj.getLocationId() != null){
			List<StorageLocationVO> voList = convertToStorageLocationVOList(Arrays.asList(dbObj));
			return voList.get(0);
		}
		return new StorageLocationVO();
	}

	public List<StorageLocationVO> getAllStorageLocations() {
		StorageLocationDbObjectExample storageLocationExample = new StorageLocationDbObjectExample();
		storageLocationExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<StorageLocationDbObject> storageLocationList = storageLocationDbObjectMapper.selectByExample(storageLocationExample);
		return convertToStorageLocationVOList(storageLocationList);
	}
	
	public void saveStorageLocation(StorageLocationVO storageLocation) {
		if(storageLocation != null){
			StorageLocationDbObject dbobj = convertToStorageLocationDbObjectList(Arrays.asList(storageLocation)).get(0);
			storageLocationDbObjectMapper.insert(dbobj);
		}
	}
	
	public void deleteStorageLocation(Integer id) {
		StorageLocationVO storageLocation = findById(id);
		if(storageLocation != null && storageLocation.getDeleteInd() != null
				&& storageLocation.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			StorageLocationDbObject dbObj = new StorageLocationDbObject();
			dbObj.setLocationId(id);
			dbObj.setDeleteInd(GeneralUtils.DELETED);
			storageLocationDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	public void updateStorageLocation(StorageLocationVO storageLocation) {
		if(storageLocation != null && storageLocation.getDeleteInd() != null
				&& storageLocation.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			StorageLocationDbObject dbObj = convertToStorageLocationDbObjectList(Arrays.asList(storageLocation)).get(0);
			storageLocationDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
			
	}
	
	private List<StorageLocationVO> convertToStorageLocationVOList(List<StorageLocationDbObject> dbObjList){
		List<StorageLocationVO> list = new ArrayList<StorageLocationVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(StorageLocationDbObject dbObj : dbObjList){
				StorageLocationVO vo = new StorageLocationVO();
				vo.setAddress(dbObj.getAddress());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setLocationId(dbObj.getLocationId());
				vo.setName(dbObj.getName());
				vo.setPostalCode(dbObj.getPostalCode());
				list.add(vo);
			}
		}
		return list;
	}
	 
	private List<StorageLocationDbObject> convertToStorageLocationDbObjectList(List<StorageLocationVO> voList){
		List<StorageLocationDbObject> list = new ArrayList<StorageLocationDbObject>();
		if(voList != null && voList.size() > 0){
			for(StorageLocationVO vo : voList){
				StorageLocationDbObject dbObj = new StorageLocationDbObject();
				dbObj.setAddress(vo.getAddress());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setLocationId(vo.getLocationId());
				dbObj.setName(vo.getName());
				dbObj.setPostalCode(vo.getPostalCode());
				list.add(dbObj);
			}
		}
		return list;
	}
	
}
