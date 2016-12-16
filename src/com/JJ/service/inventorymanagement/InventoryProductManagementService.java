package com.JJ.service.inventorymanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ViewProductInventoryMapper;
import com.JJ.model.ViewProductInventory;
import com.JJ.model.ViewProductInventoryExample;

@Service
@Transactional
public class InventoryProductManagementService {
	
	private ViewProductInventoryMapper productInventoryMapper;
	
	@Autowired
	public InventoryProductManagementService(ViewProductInventoryMapper productInventoryMapper) {
		this.productInventoryMapper = productInventoryMapper;
	}
	
	public List<ViewProductInventory> findById(Integer id) {
		ViewProductInventoryExample productInventoryExample = new ViewProductInventoryExample();
		productInventoryExample.createCriteria().andProductidEqualTo(id);
		return productInventoryMapper.selectByExample(productInventoryExample);
	}

	public List<ViewProductInventory> getAllInventoryProducts() {
		ViewProductInventoryExample productInventoryExample = new ViewProductInventoryExample();
		List<ViewProductInventory> inventoryProductList = productInventoryMapper.selectByExample(productInventoryExample);
		return inventoryProductList;
	}
	
	/*public void saveStorageLocation(Storagelocation storageLocation) {
		productInventoryMapper.insert(storageLocation);
	}
	
	public void deleteStorageLocation(Integer id) {
		Storagelocation storageLocation = findById(id);
		if(storageLocation.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			storageLocation.setDeleteind(GeneralUtils.DELETED);
			productInventoryMapper.updateByPrimaryKey(storageLocation);
		}
	}
	
	public void updateStorageLocation(Storagelocation storageLocation) {
		if(storageLocation.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			productInventoryMapper.updateByPrimaryKeySelective(storageLocation);
	}*/
	 
	
	
}
