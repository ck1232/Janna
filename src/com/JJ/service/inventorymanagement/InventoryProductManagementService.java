package com.JJ.service.inventorymanagement;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ProductinventoryMapper;
import com.JJ.dao.ViewProductInventoryLocationMapper;
import com.JJ.dao.ViewProductInventoryMapper;
import com.JJ.dao.ViewProductSuboptionInventoryMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Module;
import com.JJ.model.Productinventory;
import com.JJ.model.ProductinventoryExample;
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
	private ProductinventoryMapper inventoryMapper;
	
	@Autowired
	public InventoryProductManagementService(ViewProductInventoryMapper productInventoryMapper,
			ViewProductInventoryLocationMapper productInventoryLocationMapper,
			ViewProductSuboptionInventoryMapper productSuboptionInventoryMapper,
			ProductinventoryMapper inventoryMapper) {
		this.productInventoryMapper = productInventoryMapper;
		this.productInventoryLocationMapper = productInventoryLocationMapper;
		this.productSuboptionInventoryMapper = productSuboptionInventoryMapper;
		this.inventoryMapper = inventoryMapper;
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
		criteria.andQtyGreaterThan(BigDecimal.ZERO);
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
	public List<ViewProductSuboptionInventory> getInventoryProductAllQuantity(Integer id) {
		ViewProductSuboptionInventoryExample productSuboptionInventoryExample = new ViewProductSuboptionInventoryExample();
		productSuboptionInventoryExample.createCriteria().andProductidEqualTo(id);
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
	
	
	/* Product inventory table START */
	public List<Productinventory> getAllProductInventory() {
		ProductinventoryExample productInventoryExample = new ProductinventoryExample();
		productInventoryExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Productinventory> productInventoryList = inventoryMapper.selectByExample(productInventoryExample);
		return productInventoryList;
	}
	
	
	public void saveInventory(Productinventory inventory) {
		inventoryMapper.insert(inventory);
	}
	
	public void saveInventoryList(List<Productinventory> inventoryList) {
		for(Productinventory productinventory : inventoryList)
			inventoryMapper.insert(productinventory);
	}
	/* Product inventory table END */
	
	
}
