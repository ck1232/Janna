package com.JJ.service.batchproductrsmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.BatchproductRsMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.BatchproductRs;
import com.JJ.model.BatchproductRsExample;
import com.JJ.model.Batchstockintake;
import com.JJ.model.BatchstockintakeExample;

@Service
@Transactional
public class BatchProductRSManagementService {
	
	private BatchproductRsMapper batchproductRsMapper;
	
	@Autowired
	public BatchProductRSManagementService(BatchproductRsMapper batchproductRsMapper) {
		this.batchproductRsMapper = batchproductRsMapper;
	}
	
	public BatchproductRs findById(Integer id) {
		return batchproductRsMapper.selectByPrimaryKey(id);
	}

	public List<BatchproductRs> getAllBatchproduct() {
		BatchproductRsExample batchproductRsExample = new BatchproductRsExample();
		batchproductRsExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		return batchproductRsMapper.selectByExample(batchproductRsExample);
	}
	
	public int saveBatchproduct(BatchproductRs batchproductRs) {
		return batchproductRsMapper.insert(batchproductRs);
	}
	
	public void deleteBatchproduct(Integer id) {
		BatchproductRs batchproductRs = findById(id);
		if(batchproductRs.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			batchproductRs.setDeleteind(GeneralUtils.DELETED);
			batchproductRsMapper.updateByPrimaryKey(batchproductRs);
		}
	}
	
	public void deleteBatchproduct(List<Integer> idList) {
		BatchproductRsExample batchproductRsExample = new BatchproductRsExample();
		batchproductRsExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andBatchidIn(idList);
		BatchproductRs batchproductRs = new BatchproductRs();
		batchproductRs.setDeleteind(GeneralUtils.DELETED);
		batchproductRsMapper.updateByExampleSelective(batchproductRs, batchproductRsExample);
	}
	
	public void updateBatchproduct(BatchproductRs batchproductRs) {
		if(batchproductRs.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			batchproductRsMapper.updateByPrimaryKeySelective(batchproductRs);
	}
	
}
