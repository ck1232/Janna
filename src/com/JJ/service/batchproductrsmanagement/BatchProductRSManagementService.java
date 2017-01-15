package com.JJ.service.batchproductrsmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.BatchIntakeProduct;
import com.JJ.controller.productmanagement.vo.SubOptionVo;
import com.JJ.dao.BatchproductRsMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.BatchproductRs;
import com.JJ.model.BatchproductRsExample;
import com.JJ.model.Product;
import com.JJ.model.ProductsuboptionRs;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;

@Service
@Transactional(rollbackFor=Exception.class)
public class BatchProductRSManagementService {
	
	private BatchproductRsMapper batchproductRsMapper;
	private ProductService productService;
	private ProductOptionManagementService productOptionManagementService;
	private ProductSubOptionManagementService productSubOptionManagementService;
	
	@Autowired
	public BatchProductRSManagementService(BatchproductRsMapper batchproductRsMapper, ProductService productService,
			ProductOptionManagementService productOptionManagementService,
			ProductSubOptionManagementService productSubOptionManagementService) {
		this.batchproductRsMapper = batchproductRsMapper;
		this.productService = productService;
		this.productOptionManagementService = productOptionManagementService;
		this.productSubOptionManagementService = productSubOptionManagementService;
	}
	
	public BatchproductRs findById(Integer id) {
		return batchproductRsMapper.selectByPrimaryKey(id);
	}

	public List<BatchproductRs> getAllBatchproduct() {
		BatchproductRsExample batchproductRsExample = new BatchproductRsExample();
		batchproductRsExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		return batchproductRsMapper.selectByExample(batchproductRsExample);
	}
	
	public List<BatchproductRs> getBatchproductByBatchId(Integer batchid) {
		BatchproductRsExample batchproductRsExample = new BatchproductRsExample();
		batchproductRsExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andBatchidEqualTo(batchid);
		return batchproductRsMapper.selectByExample(batchproductRsExample);
	}
	
	/*public BatchproductRs findByProductNameAndSubOption(Integer batchid, BatchIntakeProduct product) {
		BatchproductRsExample batchproductRsExample = new BatchproductRsExample();
		BatchproductRsExample.Criteria criteria = batchproductRsExample.createCriteria();
		criteria.andDeleteindEqualTo(GeneralUtils.NOT_DELETED)
									.andBatchidEqualTo(batchid)
									.andProductidEqualTo(product.getProduct().getProductid());
		if(product.getSubOptionList() != null && product.getSubOptionList().size() > 0) {
			for(SubOptionVo vo: product.getSubOptionList()) {
				Productsuboption suboption = productSubOptionManagementService.findById(vo.getSubOptionId());
				Productoption option = productOptionManagementService.findById(suboption.getProductoptionid());
				int seq = option.getSequence();
				if(seq == 1) {
					criteria.andProductsuboption1idEqualTo(vo.getSubOptionId());
				}else if(seq == 2) {
					criteria.andProductsuboption2idEqualTo(vo.getSubOptionId());
				}else if(seq == 3) {
					criteria.andProductsuboption3idEqualTo(vo.getSubOptionId());
				}
			}
		}
		List<BatchproductRs> rsList = batchproductRsMapper.selectByExample(batchproductRsExample);
		if(rsList.size() == 0){
			return null;
		}
		return rsList.get(0);
	}*/
	
	public int saveBatchproduct(BatchproductRs batchproductRs) {
		return batchproductRsMapper.insertSelective(batchproductRs);
	}
	
	public void deleteBatchproduct(Integer id) {
		BatchproductRs batchproductRs = findById(id);
		if(batchproductRs.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			batchproductRs.setDeleteind(GeneralUtils.DELETED);
			batchproductRsMapper.updateByPrimaryKey(batchproductRs);
		}
	}
	
	public void deleteBatchproduct(List<Integer> batchidList) {
		BatchproductRsExample batchproductRsExample = new BatchproductRsExample();
		batchproductRsExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andBatchidIn(batchidList);
		BatchproductRs batchproductRs = new BatchproductRs();
		batchproductRs.setDeleteind(GeneralUtils.DELETED);
		batchproductRsMapper.updateByExampleSelective(batchproductRs, batchproductRsExample);
	}
	
	public void deleteBatchproductNotInBatchProductidList(Integer batchid, List<Integer> idList) {
		BatchproductRsExample batchproductRsExample = new BatchproductRsExample();
		BatchproductRsExample.Criteria criteria = batchproductRsExample.createCriteria();
		criteria.andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andBatchidEqualTo(batchid);
		
		if(idList != null && idList.size() > 0){
			criteria.andBatchproductidNotIn(idList);
		}
		BatchproductRs batchproductRs = new BatchproductRs();
		batchproductRs.setDeleteind(GeneralUtils.DELETED);
		batchproductRsMapper.updateByExampleSelective(batchproductRs, batchproductRsExample);
	}
	
	public void updateBatchproductRS(BatchproductRs batchproductRs) {
		if(batchproductRs.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			batchproductRsMapper.updateByPrimaryKeySelective(batchproductRs);
	}
	
	public List<BatchIntakeProduct> getAllBatchProductVoByBatchId(Integer batchId) {
		List<BatchproductRs> rsList = getBatchproductByBatchId(batchId);
		List<BatchIntakeProduct> productVoList = new ArrayList<BatchIntakeProduct>();
		if(rsList.size() != 0){
			for(BatchproductRs rs: rsList){
				BatchIntakeProduct batchProduct = new BatchIntakeProduct();
				ProductsuboptionRs productoptionrs = productService.getProductsuboptionRsById(rs.getProductsuboptionid());
				Product product = productService.getProductsById(productoptionrs.getProductid());
				batchProduct.setProduct(product);
				batchProduct.setQty(rs.getQty());
				batchProduct.setUnitcost(rs.getUnitcost());
				batchProduct.setBatchProductId(rs.getBatchproductid());
				batchProduct.setSubOptionList(new ArrayList<SubOptionVo>());
				if(productoptionrs.getSuboption1id() != null && productoptionrs.getSuboption1id() > 0){
					SubOptionVo subOption1 = productService.getSubOptionVo(productoptionrs.getSuboption1id());
					if(subOption1 != null){
						batchProduct.getSubOptionList().add(subOption1);
					}
				}
				if(productoptionrs.getSuboption2id() != null && productoptionrs.getSuboption2id() > 0){
					SubOptionVo subOption2 = productService.getSubOptionVo(productoptionrs.getSuboption2id());
					if(subOption2 != null){
						batchProduct.getSubOptionList().add(subOption2);
					}
				}
				if(productoptionrs.getSuboption3id() != null && productoptionrs.getSuboption3id() > 0){
					SubOptionVo subOption3 = productService.getSubOptionVo(productoptionrs.getSuboption3id());
					if(subOption3 != null){
						batchProduct.getSubOptionList().add(subOption3);
					}
				}
				productVoList.add(batchProduct);
			}
		}
		return productVoList;
	}
	
}
