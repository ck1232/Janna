package com.JJ.service.batchintakemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.BatchstockintakeMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Batchstockintake;
import com.JJ.model.BatchstockintakeExample;

@Service
@Transactional
public class BatchIntakeManagementService {
	
	private BatchstockintakeMapper batchStockIntakeMapper;
	
	@Autowired
	public BatchIntakeManagementService(BatchstockintakeMapper batchStockIntakeMapper) {
		this.batchStockIntakeMapper = batchStockIntakeMapper;
	}
	
	public Batchstockintake findById(Integer id) {
		return batchStockIntakeMapper.selectByPrimaryKey(id);
	}

	public List<Batchstockintake> getAllBatchstockintakes() {
		BatchstockintakeExample batchStockIntakeExample = new BatchstockintakeExample();
		batchStockIntakeExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		return batchStockIntakeMapper.selectByExample(batchStockIntakeExample);
	}
	
	public int saveBatchstockintake(Batchstockintake batchStockIntake) {
		return batchStockIntakeMapper.insert(batchStockIntake);
	}
	
	public void deleteBatchstockintake(Integer id) {
		Batchstockintake batchStockIntake = findById(id);
		if(batchStockIntake.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			batchStockIntake.setDeleteind(GeneralUtils.DELETED);
			batchStockIntakeMapper.updateByPrimaryKey(batchStockIntake);
		}
	}
	
	public void updateBatchstockintake(Batchstockintake batchStockIntake) {
		if(batchStockIntake.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			batchStockIntakeMapper.updateByPrimaryKeySelective(batchStockIntake);
	}
	
}
