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
import com.JJ.model.ProductExample;
import com.JJ.model.Productoption;
import com.JJ.model.Productsuboption;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productoptionmanagement.ProductOptionManagementService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;

@Service
@Transactional
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
	
	public BatchproductRs findByProductNameAndSubOption(Integer batchid, BatchIntakeProduct product) {
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
				Product product = productService.getProductsById(rs.getProductid());
				batchProduct.setProduct(product);
				batchProduct.setQty(rs.getQty());
				batchProduct.setUnitcost(rs.getUnitcost());
				batchProduct.setSubOptionList(new ArrayList<SubOptionVo>());
				if(rs.getProductsuboption1id() != null && rs.getProductsuboption1id().intValue() > 0){
					SubOptionVo subOption1 = productService.getSubOptionVo(rs.getProductsuboption1id());
					if(subOption1 != null){
						batchProduct.getSubOptionList().add(subOption1);
					}
				}
				if(rs.getProductsuboption2id() != null && rs.getProductsuboption2id().intValue() > 0){
					SubOptionVo subOption2 = productService.getSubOptionVo(rs.getProductsuboption2id());
					if(subOption2 != null){
						batchProduct.getSubOptionList().add(subOption2);
					}
				}
				if(rs.getProductsuboption3id() != null && rs.getProductsuboption3id().intValue() > 0){
					SubOptionVo subOption3 = productService.getSubOptionVo(rs.getProductsuboption3id());
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
