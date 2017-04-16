package com.JJ.service.batchintakemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.vo.BatchProductRsVO;
import com.JJ.controller.batchintakemanagement.vo.BatchStockIntakeVO;
import com.JJ.controller.batchintakemanagement.vo.ProductInventoryVO;
import com.JJ.dao.BatchStockIntakeDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.BatchStockIntakeDbObject;
import com.JJ.model.BatchStockIntakeDbObjectExample;
import com.JJ.service.batchproductrsmanagement.BatchProductRSManagementService;
import com.JJ.service.inventorymanagement.InventoryProductManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class BatchIntakeManagementService {
	
	private BatchStockIntakeDbObjectMapper batchStockIntakeDbObjectMapper;
	private BatchProductRSManagementService batchProductRSManagementService;
	private InventoryProductManagementService inventoryService;
	
	@Autowired
	public BatchIntakeManagementService(BatchStockIntakeDbObjectMapper batchStockIntakeDbObjectMapper, 
			BatchProductRSManagementService batchProductRSManagementService,
			InventoryProductManagementService inventoryService) {
		this.batchStockIntakeDbObjectMapper = batchStockIntakeDbObjectMapper;
		this.batchProductRSManagementService = batchProductRSManagementService;
		this.inventoryService = inventoryService;
	}
	
	public BatchStockIntakeVO findById(Integer id) {
		BatchStockIntakeDbObject batchStockIntakeDbObject = batchStockIntakeDbObjectMapper.selectByPrimaryKey(id);
		if(batchStockIntakeDbObject != null && batchStockIntakeDbObject.getBatchId() != null){
			return convertToBatchStockIntakeVOList(Arrays.asList(batchStockIntakeDbObject)).get(0);
		}else{
			return new BatchStockIntakeVO();
		}
	}
	
	public List<BatchStockIntakeVO> findByIdList(List<Integer> idList) {
		BatchStockIntakeDbObjectExample batchStockIntakeExample = new BatchStockIntakeDbObjectExample();
		batchStockIntakeExample.createCriteria().andBatchIdIn(idList).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToBatchStockIntakeVOList(batchStockIntakeDbObjectMapper.selectByExample(batchStockIntakeExample));
	}

	public List<BatchStockIntakeVO> getAllBatchStockIntakes() {
		BatchStockIntakeDbObjectExample batchStockIntakeExample = new BatchStockIntakeDbObjectExample();
		batchStockIntakeExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToBatchStockIntakeVOList(batchStockIntakeDbObjectMapper.selectByExample(batchStockIntakeExample));
	}
	public void createBatchstockintake(BatchStockIntakeVO batchStockIntake, List<ProductInventoryVO> inventoryList,
			List<BatchProductRsVO> batchProductList){
		saveBatchstockintake(batchStockIntake);
		inventoryService.saveInventoryList(inventoryList);
		if(batchProductList != null && batchProductList.size() > 0){
			for(BatchProductRsVO batchProduct : batchProductList){
				batchProduct.setBatchId(batchStockIntake.getBatchId());
				batchProductRSManagementService.saveBatchproduct(batchProduct);
			}
		}
	}
	public void saveBatchstockintake(BatchStockIntakeVO batchStockIntakeVO) {
		if(batchStockIntakeVO != null){
			BatchStockIntakeDbObject dbObj = convertToBatchStockIntakeDbObjectList(Arrays.asList(batchStockIntakeVO)).get(0);
			batchStockIntakeDbObjectMapper.insert(dbObj);
		}
	}
	
	public void deleteBatchStockIntake(Integer id) {
		BatchStockIntakeVO batchStockIntake = findById(id);
		if(batchStockIntake != null && batchStockIntake.getDeleteInd() != null &&
				batchStockIntake.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			BatchStockIntakeDbObject dbObj = new BatchStockIntakeDbObject();
			dbObj.setBatchId(id);
			dbObj.setDeleteInd(GeneralUtils.DELETED);
			batchStockIntakeDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	public void deleteBatchstockintake(List<Integer> idList) {
		BatchStockIntakeDbObjectExample batchStockIntakeExample = new BatchStockIntakeDbObjectExample();
		batchStockIntakeExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andBatchIdIn(idList);
		BatchStockIntakeDbObject batchStockIntake = new BatchStockIntakeDbObject();
		batchStockIntake.setDeleteInd(GeneralUtils.DELETED);
		batchStockIntakeDbObjectMapper.updateByExampleSelective(batchStockIntake, batchStockIntakeExample);
	}
	
	public void updateBatchStockIntake(BatchStockIntakeVO batchStockIntakeVO) {
		if(batchStockIntakeVO != null && batchStockIntakeVO.getDeleteInd() != null &&
				batchStockIntakeVO.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			BatchStockIntakeDbObject dbObj = convertToBatchStockIntakeDbObjectList(Arrays.asList(batchStockIntakeVO)).get(0);
			batchStockIntakeDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
			
	}
	
	public void editBatchstockintake(BatchStockIntakeVO batchStockIntake, List<Integer> idList , List<BatchProductRsVO> batchProductList, List<ProductInventoryVO> productInventoryList){
		updateBatchStockIntake(batchStockIntake);
		batchProductRSManagementService.deleteBatchproductNotInBatchProductidList(batchStockIntake.getBatchId(), idList);
		if(batchProductList != null && batchProductList.size() > 0){
			for(BatchProductRsVO batchProduct : batchProductList){
				batchProduct.setBatchId(batchStockIntake.getBatchId());
				batchProductRSManagementService.saveBatchproduct(batchProduct);
			}
		}
		inventoryService.saveInventoryList(productInventoryList);
	}

	public void deleteBatch(List<Integer> ids, List<ProductInventoryVO> productInventoryList) {
		deleteBatchstockintake(ids);
		batchProductRSManagementService.deleteBatchproduct(ids);
		inventoryService.saveInventoryList(productInventoryList);
	}
	
	private List<BatchStockIntakeVO> convertToBatchStockIntakeVOList(List<BatchStockIntakeDbObject> batchStockIntakeDbObjectList){
		List<BatchStockIntakeVO> batchStockIntakeVOList = new ArrayList<BatchStockIntakeVO>();
		if(batchStockIntakeDbObjectList != null && batchStockIntakeDbObjectList.size() > 0){
			for(BatchStockIntakeDbObject dbObj : batchStockIntakeDbObjectList){
				BatchStockIntakeVO batchStockIntakeVO = new BatchStockIntakeVO();
				batchStockIntakeVO.setAdditionalCost(dbObj.getAdditionalCost());
				batchStockIntakeVO.setBatchId(dbObj.getBatchId());
				batchStockIntakeVO.setDeleteInd(dbObj.getDeleteInd());
				batchStockIntakeVO.setDate(dbObj.getDate());
				batchStockIntakeVO.setRemarks(dbObj.getRemarks());
				batchStockIntakeVO.setStorageLocation(dbObj.getStorageLocation());
				batchStockIntakeVO.setTotalCost(dbObj.getTotalCost());
				batchStockIntakeVOList.add(batchStockIntakeVO);
			}
		}
		return batchStockIntakeVOList;
	}
	
	private List<BatchStockIntakeDbObject> convertToBatchStockIntakeDbObjectList(List<BatchStockIntakeVO> batchStockIntakeVOList){
		List<BatchStockIntakeDbObject> batchStockIntakeDbObjectList = new ArrayList<BatchStockIntakeDbObject>();
		if(batchStockIntakeVOList != null && batchStockIntakeVOList.size() > 0){
			for(BatchStockIntakeVO vo : batchStockIntakeVOList){
				BatchStockIntakeDbObject dbObj = new BatchStockIntakeDbObject();
				dbObj.setAdditionalCost(vo.getAdditionalCost());
				dbObj.setBatchId(vo.getBatchId());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setDate(vo.getDate());
				dbObj.setRemarks(vo.getRemarks());
				dbObj.setStorageLocation(vo.getStorageLocation());
				dbObj.setTotalCost(vo.getTotalCost());
				batchStockIntakeDbObjectList.add(dbObj);
			}
		}
		return batchStockIntakeDbObjectList;
	}
}
