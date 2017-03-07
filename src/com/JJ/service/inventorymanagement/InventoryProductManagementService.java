package com.JJ.service.inventorymanagement;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.BatchIntakeProduct;
import com.JJ.controller.inventorymanagement.InventoryHistorySearchCriteria;
import com.JJ.controller.inventorymanagement.InventoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionRsVo;
import com.JJ.controller.productmanagement.vo.ProductVo;
import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.dao.ProductinventoryMapper;
import com.JJ.dao.ViewProductInventoryLocationMapper;
import com.JJ.dao.ViewProductInventoryMapper;
import com.JJ.dao.ViewProductSuboptionInventoryMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Product;
import com.JJ.model.Productinventory;
import com.JJ.model.ProductinventoryExample;
import com.JJ.model.ProductsuboptionRs;
import com.JJ.model.Storagelocation;
import com.JJ.model.ViewItemCode;
import com.JJ.model.ViewProductInventory;
import com.JJ.model.ViewProductInventoryExample;
import com.JJ.model.ViewProductInventoryLocation;
import com.JJ.model.ViewProductInventoryLocationExample;
import com.JJ.model.ViewProductSuboptionInventory;
import com.JJ.model.ViewProductSuboptionInventoryExample;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.storagelocationmanagement.StorageLocationManagementService;

@Service
@Transactional
public class InventoryProductManagementService {
	
	private ViewProductInventoryMapper productInventoryMapper;
	private ViewProductInventoryLocationMapper productInventoryLocationMapper;
	private ViewProductSuboptionInventoryMapper productSuboptionInventoryMapper;
	private ProductinventoryMapper inventoryMapper;
	private ProductService productService;
	private StorageLocationManagementService storageLocationManagementService;
	
	@Autowired
	public InventoryProductManagementService(ViewProductInventoryMapper productInventoryMapper,
			ViewProductInventoryLocationMapper productInventoryLocationMapper,
			ViewProductSuboptionInventoryMapper productSuboptionInventoryMapper,
			ProductinventoryMapper inventoryMapper,
			ProductService productService,
			StorageLocationManagementService storageLocationManagementService) {
		this.productInventoryMapper = productInventoryMapper;
		this.productInventoryLocationMapper = productInventoryLocationMapper;
		this.productSuboptionInventoryMapper = productSuboptionInventoryMapper;
		this.inventoryMapper = inventoryMapper;
		this.productService = productService;
		this.storageLocationManagementService = storageLocationManagementService;
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
		
		List<Product> productList = productService.getAllProducts();
		List<ViewItemCode> itemCodeList = productService.getAllItemCode();
		List<ProductSubOptionRsVo> productSuboptionList = productService.getAllProductSubOptionVo();
		List<Storagelocation> storageLocationList = storageLocationManagementService.getAllStoragelocations();
		
		productInventoryList = combineProductInventoryInfo(productInventoryList, productList, itemCodeList, productSuboptionList, storageLocationList);
		return productInventoryList;
	}
	
	public List<Storagelocation> getAllStorageLocation(){
		return storageLocationManagementService.getAllStoragelocations();
	}
	
	private List<Productinventory> combineProductInventoryInfo(List<Productinventory> productInventoryList, 
			List<Product> productList,
			List<ViewItemCode> itemCodeList,
			List<ProductSubOptionRsVo> productSuboptionList,
			List<Storagelocation> storageLocationList){
		
		HashMap<Integer, Product> productHash = convertToHashMapForProduct(productList);
		HashMap<Integer, ViewItemCode> itemCodeHash = convertToHashMapForItemCode(itemCodeList);
		HashMap<Integer, ProductSubOptionRsVo> productSuboptionHash = convertToHashMapForProductSubOption(productSuboptionList);
		HashMap<Integer, Storagelocation> locationHash = convertToHashMapForStoragelocation(storageLocationList);
		for(Productinventory productInventory : productInventoryList) {
			productInventory.setProductSuboption(productSuboptionHash.get(productInventory.getProductsuboptionid()));
			Product product = productHash.get(productInventory.getProductSuboption().getProductid());
			if(product == null){
				continue;
			}
			ProductVo productvo = new ProductVo();
			productvo.setProductName(product.getProductname());
			productInventory.setItemCode(itemCodeHash.get(productInventory.getProductsuboptionid()).getItemCode());
			productInventory.getProductSuboption().setProduct(productvo);
			productInventory.setFromLocation(locationHash.get(productInventory.getTransferfrom()));
			productInventory.setToLocation(locationHash.get(productInventory.getTransferto()));
			productInventory.setLocation();
			productInventory.setProduct();
		}
		
		return productInventoryList;
	}
	
	private HashMap<Integer, Product> convertToHashMapForProduct(List<Product> productList) {
		HashMap<Integer, Product> productHash = new HashMap<Integer, Product>();
		for(Product product : productList) {
			productHash.put(product.getProductid(), product);
		}
		return productHash;
	}
	
	private HashMap<Integer, ViewItemCode> convertToHashMapForItemCode(List<ViewItemCode> itemCodeList) {
		HashMap<Integer, ViewItemCode> itemCodeHash = new HashMap<Integer, ViewItemCode>();
		for(ViewItemCode itemCode : itemCodeList) {
			itemCodeHash.put(itemCode.getProductsuboptionrsid(), itemCode);
		}
		return itemCodeHash;
	}
	
	private HashMap<Integer, ProductSubOptionRsVo> convertToHashMapForProductSubOption(List<ProductSubOptionRsVo> voList) {
		HashMap<Integer, ProductSubOptionRsVo> voHash = new HashMap<Integer, ProductSubOptionRsVo>();
		for(ProductSubOptionRsVo vo : voList) {
			voHash.put(vo.getProductsuboptionid(), vo);
		}
		return voHash;
	}
	
	private HashMap<Integer, Storagelocation> convertToHashMapForStoragelocation(List<Storagelocation> locationList) {
		HashMap<Integer, Storagelocation> locationHash = new HashMap<Integer, Storagelocation>();
		for(Storagelocation location : locationList) {
			locationHash.put(location.getLocationid(), location);
		}
		return locationHash;
	}
	
	public List<Productinventory> searchProductInventory(InventoryHistorySearchCriteria searchCriteria) {
		List<Productinventory> productInventoryList = this.getAllProductInventory();
		List<Productinventory> filteredList = new ArrayList<Productinventory>();
		for(Productinventory productinventory : productInventoryList) {
			String name = productinventory.getProductSuboption().getProduct().getProductName().toLowerCase();
			if(!searchCriteria.getProductname().trim().isEmpty() && !name.contains(searchCriteria.getProductname().trim().toLowerCase())) continue;
			String itemCode = productinventory.getItemCode().toLowerCase();
			if(!searchCriteria.getItemcode().trim().isEmpty() && !itemCode.contains(searchCriteria.getItemcode().trim().toLowerCase())) continue;
			if(!searchCriteria.getMode().equals("NONE") && !searchCriteria.getMode().equals(productinventory.getMode())) continue;
			if(!searchCriteria.getLocation().equals("NONE") && 
					!(Integer.valueOf(searchCriteria.getLocation()) == productinventory.getTransferfrom() 
							|| Integer.valueOf(searchCriteria.getLocation()) == productinventory.getTransferto())) continue;
			String createdby = searchCriteria.getCreatedby().trim().toLowerCase();
			if(!createdby.equals("") && !productinventory.getCreatedby().contains(createdby)) continue;
			if(!searchCriteria.getCreateddatefrom().isEmpty()){
				try {
					if(null == productinventory.getCreatedon()) continue;
					Date datefrom = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getCreateddatefrom());
					if(productinventory.getCreatedon().compareTo(datefrom) < 0) continue; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(!searchCriteria.getCreateddateto().isEmpty()){
				try {
					if(null == productinventory.getCreatedon()) continue;
					Date dateto = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getCreateddateto());
					Calendar c = Calendar.getInstance();
					c.setTime(dateto);
					c.add(Calendar.DATE, 1);
					if(productinventory.getCreatedon().compareTo(c.getTime()) > 0) continue; 
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
	
	
	public void saveInventoryRecord(InventoryVO inventoryVo){
		List<Productinventory> productInventoryList = convertToProductInventoryList(inventoryVo);
		if(productInventoryList != null && productInventoryList.size() > 0){
			for(Productinventory inventory : productInventoryList){
				inventoryMapper.insertSelective(inventory);
			}
		}
	}

	private List<Productinventory> convertToProductInventoryList(InventoryVO inventoryVo) {
		List<Productinventory> productInventoryList = new ArrayList<Productinventory>();
		if(inventoryVo.getProductItems() != null && inventoryVo.getProductItems().size() > 0){
			for(BatchIntakeProduct batchProduct:inventoryVo.getProductItems()){
				List<Integer> suboptionIdList = new ArrayList<Integer>();
				for(SubOptionVo suboption: batchProduct.getSubOptionList()) {
					suboptionIdList.add(suboption.getSubOptionId());
				}
				ProductsuboptionRs rs = productService.findProductSubOptionRs(batchProduct.getProduct().getProductid(), suboptionIdList);
				if(rs == null || rs.getProductsuboptionid() == null){
					continue;
				}
				if(inventoryVo.getLocationFromId() != null && inventoryVo.getLocationToId() != null){
					//if both location exists, mean is transfer, create two inventory record
					Productinventory addInventory = new Productinventory();
					addInventory.setDate(inventoryVo.getDate());
					addInventory.setTransferfrom(inventoryVo.getLocationFromId());
					addInventory.setPlusorminus(true);
					addInventory.setRemarks(inventoryVo.getRemarks());
					addInventory.setProductsuboptionid(rs.getProductsuboptionid());
					addInventory.setUnitcost(batchProduct.getUnitcost());
					addInventory.setQty(batchProduct.getQty());
					productInventoryList.add(addInventory);
					
					Productinventory deleteInventory = new Productinventory();
					deleteInventory.setDate(inventoryVo.getDate());
					deleteInventory.setDeleteremarks(inventoryVo.getRemarks());
					deleteInventory.setTransferto(inventoryVo.getLocationToId());
					deleteInventory.setPlusorminus(false);
					deleteInventory.setUnitcost(batchProduct.getUnitcost());
					deleteInventory.setRemarks(inventoryVo.getRemarks());
					deleteInventory.setProductsuboptionid(rs.getProductsuboptionid());
					deleteInventory.setQty(batchProduct.getQty());
					productInventoryList.add(deleteInventory);
				}else if (inventoryVo.getLocationFromId() != null){
					//if locationTo is empty, means is add
					Productinventory addInventory = new Productinventory();
					addInventory.setDate(inventoryVo.getDate());
					addInventory.setTransferfrom(inventoryVo.getLocationFromId());
					addInventory.setPlusorminus(true);
					addInventory.setUnitcost(batchProduct.getUnitcost());
					addInventory.setRemarks(inventoryVo.getRemarks());
					addInventory.setProductsuboptionid(rs.getProductsuboptionid());
					addInventory.setQty(batchProduct.getQty());
					productInventoryList.add(addInventory);
				}else if (inventoryVo.getLocationToId() != null){
					//if locationFrom is empty, mean is delete
					Productinventory deleteInventory = new Productinventory();
					deleteInventory.setDate(inventoryVo.getDate());
					deleteInventory.setDeleteremarks(inventoryVo.getRemarks());
					deleteInventory.setTransferto(inventoryVo.getLocationToId());
					deleteInventory.setUnitcost(batchProduct.getUnitcost());
					deleteInventory.setPlusorminus(false);
					deleteInventory.setRemarks(inventoryVo.getRemarks());
					deleteInventory.setProductsuboptionid(rs.getProductsuboptionid());
					deleteInventory.setQty(batchProduct.getQty());
					productInventoryList.add(deleteInventory);
				}
			}
		}
		
		return productInventoryList;
	}
	
}
