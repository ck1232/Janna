package com.JJ.service.batchintakemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.BatchstockintakeMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.BatchproductRs;
import com.JJ.model.Batchstockintake;
import com.JJ.model.BatchstockintakeExample;
import com.JJ.model.Productinventory;
import com.JJ.service.batchproductrsmanagement.BatchProductRSManagementService;
import com.JJ.service.inventorymanagement.InventoryProductManagementService;

@Service
@Transactional(rollbackFor=Exception.class)
public class BatchIntakeManagementService {
	
	private BatchstockintakeMapper batchStockIntakeMapper;
	private BatchProductRSManagementService batchProductRSManagementService;
	private InventoryProductManagementService inventoryService;
	
	@Autowired
	public BatchIntakeManagementService(BatchstockintakeMapper batchStockIntakeMapper, 
			BatchProductRSManagementService batchProductRSManagementService,
			InventoryProductManagementService inventoryService) {
		this.batchStockIntakeMapper = batchStockIntakeMapper;
		this.batchProductRSManagementService = batchProductRSManagementService;
		this.inventoryService = inventoryService;
	}
	
	public Batchstockintake findById(Integer id) {
		return batchStockIntakeMapper.selectByPrimaryKey(id);
	}
	
	public List<Batchstockintake> findByIdList(List<Integer> idList) {
		BatchstockintakeExample batchStockIntakeExample = new BatchstockintakeExample();
		batchStockIntakeExample.createCriteria().andBatchidIn(idList).andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		return batchStockIntakeMapper.selectByExample(batchStockIntakeExample);
	}

	public List<Batchstockintake> getAllBatchstockintakes() {
		BatchstockintakeExample batchStockIntakeExample = new BatchstockintakeExample();
		batchStockIntakeExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		return batchStockIntakeMapper.selectByExample(batchStockIntakeExample);
	}
	public void createBatchstockintake(Batchstockintake batchStockIntake, List<Productinventory> inventoryList,
			List<BatchproductRs> batchProductList){
		saveBatchstockintake(batchStockIntake);
		inventoryService.saveInventoryList(inventoryList);
		if(batchProductList != null && batchProductList.size() > 0){
			for(BatchproductRs batchProduct : batchProductList){
				batchProduct.setBatchid(batchStockIntake.getBatchid());
				batchProductRSManagementService.saveBatchproduct(batchProduct);
			}
		}
	}
	public void saveBatchstockintake(Batchstockintake batchStockIntake) {
		batchStockIntakeMapper.insert(batchStockIntake);
	}
	
	public void deleteBatchstockintake(Integer id) {
		Batchstockintake batchStockIntake = findById(id);
		if(batchStockIntake.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			batchStockIntake.setDeleteind(GeneralUtils.DELETED);
			batchStockIntakeMapper.updateByPrimaryKey(batchStockIntake);
		}
	}
	
	public void deleteBatchstockintake(List<Integer> idList) {
		BatchstockintakeExample batchStockIntakeExample = new BatchstockintakeExample();
		batchStockIntakeExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andBatchidIn(idList);
		Batchstockintake batchStockIntake = new Batchstockintake();
		batchStockIntake.setDeleteind(GeneralUtils.DELETED);
		batchStockIntakeMapper.updateByExampleSelective(batchStockIntake, batchStockIntakeExample);
	}
	
	public void updateBatchstockintake(Batchstockintake batchStockIntake) {
		if(batchStockIntake.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			batchStockIntakeMapper.updateByPrimaryKeySelective(batchStockIntake);
	}
	
	public void editBatchstockintake(Batchstockintake batchStockIntake, List<Integer> idList , List<BatchproductRs> batchProductList, List<Productinventory> productInventoryList){
		updateBatchstockintake(batchStockIntake);
		batchProductRSManagementService.deleteBatchproductNotInBatchProductidList(batchStockIntake.getBatchid(), idList);
		if(batchProductList != null && batchProductList.size() > 0){
			for(BatchproductRs batchProduct : batchProductList){
				batchProduct.setBatchid(batchStockIntake.getBatchid());
				batchProductRSManagementService.saveBatchproduct(batchProduct);
			}
		}
		inventoryService.saveInventoryList(productInventoryList);
	}

	public void deleteBatch(List<Integer> ids, List<Productinventory> productInventoryList) {
		deleteBatchstockintake(ids);
		batchProductRSManagementService.deleteBatchproduct(ids);
		inventoryService.saveInventoryList(productInventoryList);
	}
	
}
