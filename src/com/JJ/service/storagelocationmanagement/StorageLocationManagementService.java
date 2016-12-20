package com.JJ.service.storagelocationmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.StoragelocationMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Storagelocation;
import com.JJ.model.StoragelocationExample;

@Service
@Transactional
public class StorageLocationManagementService {
	
	private StoragelocationMapper storageLocationMapper;
	
	@Autowired
	public StorageLocationManagementService(StoragelocationMapper storageLocationMapper) {
		this.storageLocationMapper = storageLocationMapper;
	}
	
	public Storagelocation findById(Integer id) {
		return storageLocationMapper.selectByPrimaryKey(id);
	}

	public List<Storagelocation> getAllStoragelocations() {
		StoragelocationExample storageLocationExample = new StoragelocationExample();
		storageLocationExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Storagelocation> storageLocationList = storageLocationMapper.selectByExample(storageLocationExample);
		return storageLocationList;
	}
	
	public void saveStorageLocation(Storagelocation storageLocation) {
		storageLocationMapper.insert(storageLocation);
	}
	
	public void deleteStorageLocation(Integer id) {
		Storagelocation storageLocation = findById(id);
		if(storageLocation.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			storageLocation.setDeleteind(GeneralUtils.DELETED);
			storageLocationMapper.updateByPrimaryKey(storageLocation);
		}
	}
	
	public void updateStorageLocation(Storagelocation storageLocation) {
		if(storageLocation.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			storageLocationMapper.updateByPrimaryKeySelective(storageLocation);
	}
	 
	
	
}
