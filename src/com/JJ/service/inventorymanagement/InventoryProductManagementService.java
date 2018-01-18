package com.JJ.service.inventorymanagement;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.vo.BatchIntakeProductVO;
import com.JJ.controller.batchintakemanagement.vo.ProductInventoryVO;
import com.JJ.controller.batchintakemanagement.vo.ProductSubOptionRsVO;
import com.JJ.controller.batchintakemanagement.vo.StorageLocationVO;
import com.JJ.controller.inventorymanagement.InventoryHistorySearchCriteria;
import com.JJ.controller.inventorymanagement.vo.ViewItemCodeVO;
import com.JJ.controller.inventorymanagement.vo.ViewProductInventoryLocationVO;
import com.JJ.controller.inventorymanagement.vo.ViewProductInventoryVO;
import com.JJ.controller.inventorymanagement.vo.ViewProductSubOptionInventoryVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.dao.ProductInventoryDbObjectMapper;
import com.JJ.dao.ViewProductInventoryDbObjectMapper;
import com.JJ.dao.ViewProductInventoryLocationDbObjectMapper;
import com.JJ.dao.ViewProductSubOptionInventoryDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductInventoryDbObject;
import com.JJ.model.ProductInventoryDbObjectExample;
import com.JJ.model.ViewProductInventoryDbObject;
import com.JJ.model.ViewProductInventoryDbObjectExample;
import com.JJ.model.ViewProductInventoryLocationDbObject;
import com.JJ.model.ViewProductInventoryLocationDbObjectExample;
import com.JJ.model.ViewProductSubOptionInventoryDbObject;
import com.JJ.model.ViewProductSubOptionInventoryDbObjectExample;
import com.JJ.service.productmanagement.ItemCodeService;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.storagelocationmanagement.StorageLocationManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class InventoryProductManagementService {
	
	private ViewProductInventoryDbObjectMapper viewProductInventoryDbObjectMapper;
	private ViewProductInventoryLocationDbObjectMapper viewProductInventoryLocationDbObjectMapper;
	private ViewProductSubOptionInventoryDbObjectMapper viewProductSubOptionInventoryDbObjectMapper;
	private ProductInventoryDbObjectMapper productInventoryDbObjectMapper;
	private ProductService productService;
	private StorageLocationManagementService storageLocationManagementService;
	private ItemCodeService itemCodeService;
	
	@Autowired
	public InventoryProductManagementService(ViewProductInventoryDbObjectMapper viewProductInventoryDbObjectMapper,
			ViewProductInventoryLocationDbObjectMapper viewProductInventoryLocationDbObjectMapper,
			ViewProductSubOptionInventoryDbObjectMapper viewProductSubOptionInventoryDbObjectMapper,
			ProductInventoryDbObjectMapper inventoryMapper,
			ProductService productService,
			StorageLocationManagementService storageLocationManagementService,
			ItemCodeService itemCodeService) {
		this.viewProductInventoryDbObjectMapper = viewProductInventoryDbObjectMapper;
		this.viewProductInventoryLocationDbObjectMapper = viewProductInventoryLocationDbObjectMapper;
		this.viewProductSubOptionInventoryDbObjectMapper = viewProductSubOptionInventoryDbObjectMapper;
		this.productInventoryDbObjectMapper = inventoryMapper;
		this.productService = productService;
		this.storageLocationManagementService = storageLocationManagementService;
		this.itemCodeService = itemCodeService;
	}
	
	/* Inventory Products START */
	
	public List<ViewProductInventoryVO> findById(Integer id) {
		ViewProductInventoryDbObjectExample productInventoryExample = new ViewProductInventoryDbObjectExample();
		productInventoryExample.createCriteria().andProductIdEqualTo(id);
		List<ViewProductInventoryDbObject> dbObjList = viewProductInventoryDbObjectMapper.selectByExample(productInventoryExample);
		if(dbObjList != null && dbObjList.size() > 0){
			return convertToViewProductInventoryVOList(dbObjList);
		}
		return new ArrayList<ViewProductInventoryVO>();
	}

	private List<ViewProductInventoryVO> convertToViewProductInventoryVOList(
			List<ViewProductInventoryDbObject> dbObjList) {
		List<ViewProductInventoryVO> list = new ArrayList<ViewProductInventoryVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(ViewProductInventoryDbObject dbObj : dbObjList){
				ViewProductInventoryVO vo = new ViewProductInventoryVO(dbObj.getProductId(), dbObj.getProductName(),
						dbObj.getQty());
				list.add(vo);
			}
		}
		return list;
	}

	public List<ViewProductInventoryVO> getAllInventoryProducts() {
		ViewProductInventoryDbObjectExample productInventoryExample = new ViewProductInventoryDbObjectExample();
		List<ViewProductInventoryDbObject> inventoryProductList = viewProductInventoryDbObjectMapper.selectByExample(productInventoryExample);
		return convertToViewProductInventoryVOList(inventoryProductList);
	}
	/* Inventory Products END */
	
	/* Inventory Products Location START */
	public List<ViewProductInventoryLocationVO> getAllInventoryProductLocations(int suboption1Id, int suboption2Id, int suboption3Id) {
		ViewProductInventoryLocationDbObjectExample productInventoryLocationExample = new ViewProductInventoryLocationDbObjectExample();
		ViewProductInventoryLocationDbObjectExample.Criteria criteria = productInventoryLocationExample.createCriteria();
		criteria.andQtyGreaterThan(BigDecimal.ZERO);
		productInventoryLocationExample.setOrderByClause("location");
		if(suboption1Id != 0){
			criteria.andSuboption1IdEqualTo(suboption1Id);
		}
		if(suboption2Id != 0){
			criteria.andSuboption2IdEqualTo(suboption2Id);
		}
		if(suboption3Id != 0){
			criteria.andSuboption3IdEqualTo(suboption3Id);
		}
		List<ViewProductInventoryLocationDbObject> inventoryProductLocationList = viewProductInventoryLocationDbObjectMapper.selectByExample(productInventoryLocationExample);
		return convertToViewProductInventoryLocationVO(inventoryProductLocationList);
	}
	
	/* Inventory Products Location END */
	
	private List<ViewProductInventoryLocationVO> convertToViewProductInventoryLocationVO(
			List<ViewProductInventoryLocationDbObject> dbList) {
		List<ViewProductInventoryLocationVO> list = new ArrayList<ViewProductInventoryLocationVO>();
		if(dbList != null && dbList.size() > 0){
			for(ViewProductInventoryLocationDbObject dbObj : dbList){
				ViewProductInventoryLocationVO vo = new ViewProductInventoryLocationVO(dbObj.getLocationId(),
						dbObj.getLocation(),dbObj.getProductId(), dbObj.getProductName(),
						dbObj.getSuboption1Name(), dbObj.getSuboption1Id(),
						dbObj.getSuboption2Name(), dbObj.getSuboption2Id(),
						dbObj.getSuboption3Name(), dbObj.getSuboption3Id(),
						dbObj.getQty());
				list.add(vo);
			}
		}
		return list;
	}

	/* Inventory Products SubOption START */
	public List<ViewProductSubOptionInventoryVO> getInventoryProductAllQuantity(Integer id) {
		ViewProductSubOptionInventoryDbObjectExample productSuboptionInventoryExample = new ViewProductSubOptionInventoryDbObjectExample();
		productSuboptionInventoryExample.createCriteria().andProductIdEqualTo(id);
		List<ViewProductSubOptionInventoryDbObject> productSuboptionInventoryList = viewProductSubOptionInventoryDbObjectMapper.selectByExample(productSuboptionInventoryExample);
		return convertToViewProductSubOptionInventoryVOList(productSuboptionInventoryList);
	}
	
	/* Inventory Products SubOption END */	
	
	private List<ViewProductSubOptionInventoryVO> convertToViewProductSubOptionInventoryVOList(
			List<ViewProductSubOptionInventoryDbObject> dbObjList) {
		List<ViewProductSubOptionInventoryVO> list = new ArrayList<ViewProductSubOptionInventoryVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(ViewProductSubOptionInventoryDbObject dbObj : dbObjList){
				ViewProductSubOptionInventoryVO vo = new ViewProductSubOptionInventoryVO(dbObj.getProductId(),
						dbObj.getProductName(),dbObj.getSuboption1Name(),dbObj.getSuboption1Id(),
						dbObj.getSuboption2Name(),dbObj.getSuboption2Id(),
						dbObj.getSuboption3Name(),dbObj.getSuboption3Id(),
						dbObj.getQty());
				list.add(vo);
			}
		}
		return list;
	}

	/* Product inventory table START */
	public List<ProductInventoryVO> getAllProductInventory() {
		ProductInventoryDbObjectExample productInventoryExample = new ProductInventoryDbObjectExample();
		productInventoryExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ProductInventoryDbObject> dbObjList = productInventoryDbObjectMapper.selectByExample(productInventoryExample);
		List<ProductInventoryVO> productInventoryList = convertToProductInventoryVO(dbObjList);
		List<ProductVO> productList = productService.getAllProducts();
		List<ViewItemCodeVO> itemCodeList = itemCodeService.getAllItemCode();
		List<ProductSubOptionRsVO> productSuboptionList = productService.getAllProductSubOptionVo();
		List<StorageLocationVO> storageLocationList = storageLocationManagementService.getAllStorageLocations();
		
		productInventoryList = combineProductInventoryInfo(productInventoryList, productList, itemCodeList, productSuboptionList, storageLocationList);
		return productInventoryList;
	}
	
	public List<StorageLocationVO> getAllStorageLocation(){
		return storageLocationManagementService.getAllStorageLocations();
	}
	
	private List<ProductInventoryVO> combineProductInventoryInfo(List<ProductInventoryVO> productInventoryList, 
			List<ProductVO> productList,
			List<ViewItemCodeVO> itemCodeList,
			List<ProductSubOptionRsVO> productSuboptionList,
			List<StorageLocationVO> storageLocationList){
		
		HashMap<Integer, ProductVO> productHash = convertToHashMapForProduct(productList);
		HashMap<Integer, ViewItemCodeVO> itemCodeHash = convertToHashMapForItemCode(itemCodeList);
		HashMap<Integer, ProductSubOptionRsVO> productSuboptionHash = convertToHashMapForProductSubOption(productSuboptionList);
		HashMap<Integer, StorageLocationVO> locationHash = convertToHashMapForStoragelocation(storageLocationList);
		for(ProductInventoryVO productInventory : productInventoryList) {
			productInventory.setProductSuboption(productSuboptionHash.get(productInventory.getProductSuboptionRsId()));
			ProductVO product = productHash.get(productInventory.getProductSuboption().getProductId());
			if(product == null){
				continue;
			}
			ProductVO productvo = new ProductVO();
			productvo.setProductName(product.getProductName());
			productInventory.setItemCode(itemCodeHash.get(productInventory.getProductSuboptionRsId()).getItemCode());
			productInventory.getProductSuboption().setProduct(productvo);
			productInventory.setFromLocation(locationHash.get(productInventory.getTransferFrom()));
			productInventory.setToLocation(locationHash.get(productInventory.getTransferTo()));
		}
		
		return productInventoryList;
	}
	
	private HashMap<Integer, ProductVO> convertToHashMapForProduct(List<ProductVO> productList) {
		HashMap<Integer, ProductVO> productHash = new HashMap<Integer, ProductVO>();
		for(ProductVO product : productList) {
			productHash.put(product.getProductId().intValue(), product);
		}
		return productHash;
	}
	
	private HashMap<Integer, ViewItemCodeVO> convertToHashMapForItemCode(List<ViewItemCodeVO> itemCodeList) {
		HashMap<Integer, ViewItemCodeVO> itemCodeHash = new HashMap<Integer, ViewItemCodeVO>();
		for(ViewItemCodeVO itemCode : itemCodeList) {
			itemCodeHash.put(itemCode.getProductSuboptionRsId(), itemCode);
		}
		return itemCodeHash;
	}
	
	private HashMap<Integer, ProductSubOptionRsVO> convertToHashMapForProductSubOption(List<ProductSubOptionRsVO> voList) {
		HashMap<Integer, ProductSubOptionRsVO> voHash = new HashMap<Integer, ProductSubOptionRsVO>();
		for(ProductSubOptionRsVO vo : voList) {
			voHash.put(vo.getProductSuboptionRsId(), vo);
		}
		return voHash;
	}
	
	private HashMap<Integer, StorageLocationVO> convertToHashMapForStoragelocation(List<StorageLocationVO> locationList) {
		HashMap<Integer, StorageLocationVO> locationHash = new HashMap<Integer, StorageLocationVO>();
		for(StorageLocationVO location : locationList) {
			locationHash.put(location.getLocationId(), location);
		}
		return locationHash;
	}
	
	public List<ProductInventoryVO> searchProductInventory(InventoryHistorySearchCriteria searchCriteria) {
		List<ProductInventoryVO> productInventoryList = this.getAllProductInventory();
		List<ProductInventoryVO> filteredList = new ArrayList<ProductInventoryVO>();
		for(ProductInventoryVO productinventory : productInventoryList) {
			String name = productinventory.getProductSuboption().getProduct().getProductName().toLowerCase();
			if(!searchCriteria.getProductname().trim().isEmpty() && !name.contains(searchCriteria.getProductname().trim().toLowerCase())) continue;
			String itemCode = productinventory.getItemCode().toLowerCase();
			if(!searchCriteria.getItemcode().trim().isEmpty() && !itemCode.contains(searchCriteria.getItemcode().trim().toLowerCase())) continue;
			if(!searchCriteria.getMode().equals("NONE") && !searchCriteria.getMode().equals(productinventory.getMode())) continue;
			if(!searchCriteria.getLocation().equals("NONE") && 
					!(Integer.valueOf(searchCriteria.getLocation()) == productinventory.getTransferFrom() 
							|| Integer.valueOf(searchCriteria.getLocation()) == productinventory.getTransferTo())) continue;
			String createdby = searchCriteria.getCreatedby().trim().toLowerCase();
			if(!createdby.equals("") && !productinventory.getCreatedBy().contains(createdby)) continue;
			if(!searchCriteria.getCreateddatefrom().isEmpty()){
				try {
					if(null == productinventory.getCreatedOn()) continue;
					Date datefrom = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getCreateddatefrom());
					if(productinventory.getCreatedOn().compareTo(datefrom) < 0) continue; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(!searchCriteria.getCreateddateto().isEmpty()){
				try {
					if(null == productinventory.getCreatedOn()) continue;
					Date dateto = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getCreateddateto());
					Calendar c = Calendar.getInstance();
					c.setTime(dateto);
					c.add(Calendar.DATE, 1);
					if(productinventory.getCreatedOn().compareTo(c.getTime()) > 0) continue; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			filteredList.add(productinventory);
		}
		return filteredList;
	}
	
	
	public void saveInventory(ProductInventoryVO inventory) {
		if(inventory != null){
			ProductInventoryDbObject dbObj = convertToProductInventoryDbObject(Arrays.asList(inventory)).get(0);
			productInventoryDbObjectMapper.insert(dbObj);
		}
		
	}
	
	public void saveInventoryList(List<ProductInventoryVO> inventoryList) {
		List<ProductInventoryDbObject> dbList = convertToProductInventoryDbObject(inventoryList);
		for(ProductInventoryDbObject dbObj : dbList){
			productInventoryDbObjectMapper.insert(dbObj);
		}
			
	}
	/* Product inventory table END */
	
	
	public void saveInventoryRecord(ProductInventoryVO inventoryVo){
		List<ProductInventoryVO> productInventoryList = convertToProductInventoryList(inventoryVo);
		if(productInventoryList != null && productInventoryList.size() > 0){
			List<ProductInventoryDbObject> dbList = convertToProductInventoryDbObject(productInventoryList);
			for(ProductInventoryDbObject dbObj : dbList){
				productInventoryDbObjectMapper.insertSelective(dbObj);
			}
		}
	}

	private List<ProductInventoryVO> convertToProductInventoryList(ProductInventoryVO inventoryVo) {
		List<ProductInventoryVO> productInventoryList = new ArrayList<ProductInventoryVO>();
		if(inventoryVo.getProductItems() != null && inventoryVo.getProductItems().size() > 0){
			for(BatchIntakeProductVO batchProduct:inventoryVo.getProductItems()){
				List<Integer> suboptionIdList = new ArrayList<Integer>();
				for(ProductSubOptionVO suboption: batchProduct.getSubOptionList()) {
					suboptionIdList.add(suboption.getProductSuboptionId().intValue());
				}
				ProductSubOptionRsVO rs = productService.findProductSubOptionRs(batchProduct.getProduct().getProductId().intValue(), suboptionIdList);
				if(rs == null || rs.getProductSuboptionRsId() == null){
					continue;
				}
				if(inventoryVo.getTransferFrom() != null && inventoryVo.getTransferTo() != null){
					//if both location exists, mean is transfer, create two inventory record
					ProductInventoryVO addInventory = new ProductInventoryVO();
					addInventory.setDate(inventoryVo.getDate());
					addInventory.setTransferFrom(inventoryVo.getTransferFrom());
					addInventory.setPlusOrMinus(true);
					addInventory.setRemarks(inventoryVo.getRemarks());
					addInventory.setProductSuboptionRsId(rs.getProductSuboptionRsId());
					addInventory.setUnitAmt(batchProduct.getUnitcost());
					addInventory.setQty(batchProduct.getQty());
					productInventoryList.add(addInventory);
					
					ProductInventoryVO deleteInventory = new ProductInventoryVO();
					deleteInventory.setDate(inventoryVo.getDate());
					deleteInventory.setDeleteRemarks(inventoryVo.getRemarks());
					deleteInventory.setTransferFrom(inventoryVo.getTransferTo());
					deleteInventory.setPlusOrMinus(false);
					deleteInventory.setUnitAmt(batchProduct.getUnitcost());
					deleteInventory.setRemarks(inventoryVo.getRemarks());
					deleteInventory.setProductSuboptionRsId(rs.getProductSuboptionRsId());
					deleteInventory.setQty(batchProduct.getQty());
					productInventoryList.add(deleteInventory);
				}else if (inventoryVo.getTransferFrom() != null){
					//if locationTo is empty, means is add
					ProductInventoryVO addInventory = new ProductInventoryVO();
					addInventory.setDate(inventoryVo.getDate());
					addInventory.setTransferFrom(inventoryVo.getTransferFrom());
					addInventory.setPlusOrMinus(true);
					addInventory.setUnitAmt(batchProduct.getUnitcost());
					addInventory.setRemarks(inventoryVo.getRemarks());
					addInventory.setProductSuboptionRsId(rs.getProductSuboptionRsId());
					addInventory.setQty(batchProduct.getQty());
					productInventoryList.add(addInventory);
				}else if (inventoryVo.getTransferTo() != null){
					//if locationFrom is empty, mean is delete
					ProductInventoryVO deleteInventory = new ProductInventoryVO();
					deleteInventory.setDate(inventoryVo.getDate());
					deleteInventory.setDeleteRemarks(inventoryVo.getRemarks());
					deleteInventory.setTransferFrom(inventoryVo.getTransferTo());
					deleteInventory.setUnitAmt(batchProduct.getUnitcost());
					deleteInventory.setPlusOrMinus(false);
					deleteInventory.setRemarks(inventoryVo.getRemarks());
					deleteInventory.setProductSuboptionRsId(rs.getProductSuboptionRsId());
					deleteInventory.setQty(batchProduct.getQty());
					productInventoryList.add(deleteInventory);
				}
			}
		}
		
		return productInventoryList;
	}
	
	
	private List<ProductInventoryVO> convertToProductInventoryVO(List<ProductInventoryDbObject> dbObjList){
		List<ProductInventoryVO> list = new ArrayList<ProductInventoryVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(ProductInventoryDbObject dbObj : dbObjList){
				ProductInventoryVO vo = new ProductInventoryVO();
				vo.setDate(dbObj.getDate());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setDeleteRemarks(dbObj.getDeleteRemarks());
				vo.setMode(dbObj.getMode());
				vo.setPlusOrMinus(dbObj.getPlusOrMinus());
				vo.setProductInventoryId(dbObj.getProductInventoryId());
				vo.setProductSuboptionRsId(dbObj.getProductSuboptionRsId());
				vo.setQty(dbObj.getQty());
				vo.setReferenceId(dbObj.getReferenceId());
				vo.setRemarks(dbObj.getRemarks());
				vo.setTransferFrom(dbObj.getTransferFrom());
				vo.setTransferTo(dbObj.getTransferTo());
				vo.setUnitAmt(dbObj.getUnitAmt());
				list.add(vo);
			}
		}
		return list;
	}
	
	
	private List<ProductInventoryDbObject> convertToProductInventoryDbObject(List<ProductInventoryVO> voList){
		List<ProductInventoryDbObject> list = new ArrayList<ProductInventoryDbObject>();
		if(voList != null && voList.size() > 0){
			for(ProductInventoryVO vo : voList){
				ProductInventoryDbObject obj = new ProductInventoryDbObject();
				obj.setDate(vo.getDate());
				obj.setDeleteInd(vo.getDeleteInd());
				obj.setDeleteRemarks(vo.getDeleteRemarks());
				obj.setMode(vo.getMode());
				obj.setPlusOrMinus(vo.getPlusOrMinus());
				obj.setProductInventoryId(vo.getProductInventoryId());
				obj.setProductSuboptionRsId(vo.getProductSuboptionRsId());
				obj.setQty(vo.getQty());
				obj.setReferenceId(vo.getReferenceId());
				obj.setRemarks(vo.getRemarks());
				obj.setTransferFrom(vo.getTransferFrom());
				obj.setTransferTo(vo.getTransferTo());
				obj.setUnitAmt(vo.getUnitAmt());
				list.add(obj);
			}
		}
		return list;
	}
}
