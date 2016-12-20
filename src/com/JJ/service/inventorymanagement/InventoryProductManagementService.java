package com.JJ.service.inventorymanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ViewProductInventoryLocationMapper;
import com.JJ.dao.ViewProductInventoryMapper;
import com.JJ.dao.ViewProductSuboptionInventoryMapper;
import com.JJ.model.ViewProductInventory;
import com.JJ.model.ViewProductInventoryExample;
import com.JJ.model.ViewProductInventoryLocation;
import com.JJ.model.ViewProductInventoryLocationExample;
import com.JJ.model.ViewProductSuboptionInventory;
import com.JJ.model.ViewProductSuboptionInventoryExample;

@Service
@Transactional
public class InventoryProductManagementService {
	
	private ViewProductInventoryMapper productInventoryMapper;
	private ViewProductInventoryLocationMapper productInventoryLocationMapper;
	private ViewProductSuboptionInventoryMapper productSuboptionInventoryMapper;
	
	@Autowired
	public InventoryProductManagementService(ViewProductInventoryMapper productInventoryMapper,
			ViewProductInventoryLocationMapper productInventoryLocationMapper,
			ViewProductSuboptionInventoryMapper productSuboptionInventoryMapper) {
		this.productInventoryMapper = productInventoryMapper;
		this.productInventoryLocationMapper = productInventoryLocationMapper;
		this.productSuboptionInventoryMapper = productSuboptionInventoryMapper;
	}
	
	/* Inventory Products START */
	
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
	/* Inventory Products END */
	
	/* Inventory Products Location START */
	public List<ViewProductInventoryLocation> getAllInventoryProductLocations(int suboption1Id, int suboption2Id, int suboption3Id) {
		ViewProductInventoryLocationExample productInventoryLocationExample = new ViewProductInventoryLocationExample();
		ViewProductInventoryLocationExample.Criteria criteria = productInventoryLocationExample.createCriteria();
		productInventoryLocationExample.setOrderByClause("location");
		if(suboption1Id != 0){
			criteria.andSuboption1idEqualTo(suboption1Id);
		}
		if(suboption2Id != 0){
			criteria.andSuboption2idEqualTo(suboption2Id);
		}
		if(suboption3Id != 0){
			criteria.andSuboption3idEqualTo(suboption3Id);
		}
		List<ViewProductInventoryLocation> inventoryProductLocationList = productInventoryLocationMapper.selectByExample(productInventoryLocationExample);
		return inventoryProductLocationList;
	}
	
	/* Inventory Products Location END */
	
	/* Inventory Products SubOption START */
	public List<ViewProductSuboptionInventory> getAllInventoryProductQuantity() {
		ViewProductSuboptionInventoryExample productSuboptionInventoryExample = new ViewProductSuboptionInventoryExample();
		List<ViewProductSuboptionInventory> productSuboptionInventoryList = productSuboptionInventoryMapper.selectByExample(productSuboptionInventoryExample);
		return productSuboptionInventoryList;
	}
	
	/* Inventory Products SubOption END */
	
	
	
	
	
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
