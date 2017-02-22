package com.JJ.service.inventorymanagement;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.inventorymanagement.InventoryHistorySearchCriteria;
import com.JJ.dao.ProductinventoryMapper;
import com.JJ.dao.ViewProductInventoryLocationMapper;
import com.JJ.dao.ViewProductInventoryMapper;
import com.JJ.dao.ViewProductSuboptionInventoryMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Productinventory;
import com.JJ.model.ProductinventoryExample;
import com.JJ.model.ViewProductInventory;
import com.JJ.model.ViewProductInventoryExample;
import com.JJ.model.ViewProductInventoryLocation;
import com.JJ.model.ViewProductInventoryLocationExample;
import com.JJ.model.ViewProductSuboptionInventory;
import com.JJ.model.ViewProductSuboptionInventoryExample;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;
import com.JJ.service.storagelocationmanagement.StorageLocationManagementService;

@Service
@Transactional
public class InventoryProductManagementService {
	
	private ViewProductInventoryMapper productInventoryMapper;
	private ViewProductInventoryLocationMapper productInventoryLocationMapper;
	private ViewProductSuboptionInventoryMapper productSuboptionInventoryMapper;
	private ProductinventoryMapper inventoryMapper;
	private ProductService productService;
	private ProductSubOptionManagementService productSubOptionManagementService;
	private StorageLocationManagementService storageLocationManagementService;
	
	@Autowired
	public InventoryProductManagementService(ViewProductInventoryMapper productInventoryMapper,
			ViewProductInventoryLocationMapper productInventoryLocationMapper,
			ViewProductSuboptionInventoryMapper productSuboptionInventoryMapper,
			ProductinventoryMapper inventoryMapper,
			ProductService productService,
			StorageLocationManagementService storageLocationManagementService,
			ProductSubOptionManagementService productSubOptionManagementService) {
		this.productInventoryMapper = productInventoryMapper;
		this.productInventoryLocationMapper = productInventoryLocationMapper;
		this.productSuboptionInventoryMapper = productSuboptionInventoryMapper;
		this.inventoryMapper = inventoryMapper;
		this.productService = productService;
		this.storageLocationManagementService = storageLocationManagementService;
		this.productSubOptionManagementService = productSubOptionManagementService;
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
	
	/* Product inventory table START */
	public List<Productinventory> getAllProductInventory() {
		ProductinventoryExample productInventoryExample = new ProductinventoryExample();
		productInventoryExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Productinventory> productInventoryList = inventoryMapper.selectByExample(productInventoryExample);
		return productInventoryList;
	}
	
	public List<Productinventory> searchProductInventory(InventoryHistorySearchCriteria searchCriteria) {
		List<Productinventory> productInventoryList = this.getAllProductInventory();
		List<Productinventory> filteredList = new ArrayList<Productinventory>();
		for(Productinventory productinventory : productInventoryList) {
			if(!searchCriteria.getMode().equals("NONE") && !searchCriteria.getMode().equals(productinventory.getMode())) continue;
			if(!searchCriteria.getLocation().equals("NONE") && 
					!(Integer.valueOf(searchCriteria.getLocation()) == productinventory.getTransferfrom() 
							|| Integer.valueOf(searchCriteria.getLocation()) == productinventory.getTransferto())) continue;
			String createdby = searchCriteria.getCreatedby().trim().toLowerCase();
			if(!createdby.equals("") && !productinventory.getCreatedby().contains(createdby)) continue;
			if(!searchCriteria.getCreateddate().equals("")){
				try {
					if(null == productinventory.getCreatedon()) continue;
					String date = new SimpleDateFormat("MM/dd/yyyy").format(productinventory.getCreatedon());
					if(!date.equals(searchCriteria.getCreateddate())) continue; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			filteredList.add(productinventory);
		}
		return filteredList;
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
