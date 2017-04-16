package com.JJ.service.batchproductrsmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.batchintakemanagement.vo.BatchIntakeProductVO;
import com.JJ.controller.batchintakemanagement.vo.BatchProductRsVO;
import com.JJ.controller.batchintakemanagement.vo.ProductSubOptionRsVO;
import com.JJ.controller.productmanagement.vo.ProductSubOptionVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.dao.BatchProductRsDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.BatchProductRsDbObject;
import com.JJ.model.BatchProductRsDbObjectExample;
import com.JJ.service.productmanagement.ProductService;
import com.JJ.service.productmanagement.ProductSubOptionRsService;
import com.JJ.service.productsuboptionmanagement.ProductSubOptionManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class BatchProductRSManagementService {
	
	private BatchProductRsDbObjectMapper batchProductRsDbObjectMapper;
	private ProductService productService;
	private ProductSubOptionRsService productSubOptionRsService;
	private ProductSubOptionManagementService productSubOptionManagementService;
	@Autowired
	public BatchProductRSManagementService(BatchProductRsDbObjectMapper batchProductRsDbObjectMapper,
			ProductService productService, ProductSubOptionRsService productSubOptionRsService,
			ProductSubOptionManagementService productSubOptionManagementService) {
		this.batchProductRsDbObjectMapper = batchProductRsDbObjectMapper;
		this.productService = productService;
		this.productSubOptionRsService = productSubOptionRsService;
		this.productSubOptionManagementService = productSubOptionManagementService;
	}
	
	public BatchProductRsVO findById(Integer id) {
		if(id != null){
			BatchProductRsDbObject dbObj = batchProductRsDbObjectMapper.selectByPrimaryKey(id);
			return convertToBatchProductRsVOList(Arrays.asList(dbObj)).get(0);
		}
		return new BatchProductRsVO();
	}

	private List<BatchProductRsVO> convertToBatchProductRsVOList(
			List<BatchProductRsDbObject> dbObjList) {
		List<BatchProductRsVO> list = new ArrayList<BatchProductRsVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(BatchProductRsDbObject dbObj : dbObjList){
				BatchProductRsVO vo = new BatchProductRsVO();
				vo.setBatchId(dbObj.getBatchId());
				vo.setBatchProductRsId(dbObj.getBatchProductRsId());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setProductSubOptionId(dbObj.getProductSubOptionId());
				vo.setQty(dbObj.getQty());
				vo.setUnitCost(dbObj.getUnitCost());
				list.add(vo);
			}
		}
		return list;
	}

	public List<BatchProductRsVO> getAllBatchproduct() {
		BatchProductRsDbObjectExample batchproductRsExample = new BatchProductRsDbObjectExample();
		batchproductRsExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<BatchProductRsDbObject> list = batchProductRsDbObjectMapper.selectByExample(batchproductRsExample);
		return convertToBatchProductRsVOList(list);
	}
	
	public List<BatchProductRsVO> getBatchproductByBatchId(Integer batchId) {
		if(batchId != null){
			BatchProductRsDbObjectExample batchproductRsExample = new BatchProductRsDbObjectExample();
			batchproductRsExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andBatchIdEqualTo(batchId);
			List<BatchProductRsDbObject> list = batchProductRsDbObjectMapper.selectByExample(batchproductRsExample);
			return convertToBatchProductRsVOList(list);
		}
		return new ArrayList<BatchProductRsVO>();
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
	
	public int saveBatchproduct(BatchProductRsVO batchproductRs) {
		List<BatchProductRsDbObject> dbObjList = convertToBatchProductRsDbObjectList(Arrays.asList(batchproductRs));
		if(dbObjList != null && dbObjList.size() > 0){
			return batchProductRsDbObjectMapper.insertSelective(dbObjList.get(0));
		}
		return 0;
	}
	
	private List<BatchProductRsDbObject> convertToBatchProductRsDbObjectList(
			List<BatchProductRsVO> voList) {
		List<BatchProductRsDbObject> list = new ArrayList<BatchProductRsDbObject>();
		if(voList != null && voList.size() > 0){
			for(BatchProductRsVO vo : voList){
				BatchProductRsDbObject dbObj = new BatchProductRsDbObject();
				dbObj.setBatchId(vo.getBatchId());
				dbObj.setBatchProductRsId(vo.getBatchProductRsId());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setProductSubOptionId(vo.getProductSubOptionId());
				dbObj.setQty(vo.getQty());
				dbObj.setUnitCost(vo.getUnitCost());
				list.add(dbObj);
			}
		}
		return list;
	}

	public void deleteBatchproduct(Integer id) {
		BatchProductRsVO batchProductRs = findById(id);
		if(batchProductRs != null && batchProductRs.getDeleteInd() != null){
			if(batchProductRs.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
				BatchProductRsDbObject dbObj = new BatchProductRsDbObject();
				dbObj.setBatchId(id);
				dbObj.setDeleteInd(GeneralUtils.DELETED);
				batchProductRsDbObjectMapper.updateByPrimaryKey(dbObj);
			}
		}
		
	}
	
	public void deleteBatchproduct(List<Integer> batchidList) {
		BatchProductRsDbObjectExample batchproductRsExample = new BatchProductRsDbObjectExample();
		batchproductRsExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andBatchIdIn(batchidList);
		BatchProductRsDbObject dbObj = new BatchProductRsDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		batchProductRsDbObjectMapper.updateByExampleSelective(dbObj, batchproductRsExample);
	}
	
	public void deleteBatchproductNotInBatchProductidList(Integer batchid, List<Integer> idList) {
		BatchProductRsDbObjectExample batchproductRsExample = new BatchProductRsDbObjectExample();
		BatchProductRsDbObjectExample.Criteria criteria = batchproductRsExample.createCriteria();
		criteria.andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andBatchIdEqualTo(batchid);
		
		if(idList != null && idList.size() > 0){
			criteria.andBatchProductRsIdNotIn(idList);
		}
		BatchProductRsDbObject batchproductRs = new BatchProductRsDbObject();
		batchproductRs.setDeleteInd(GeneralUtils.DELETED);
		batchProductRsDbObjectMapper.updateByExampleSelective(batchproductRs, batchproductRsExample);
	}
	
	public void updateBatchproductRS(BatchProductRsVO batchproductRs) {
		if(batchproductRs.getDeleteInd() != null && 
				batchproductRs.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			List<BatchProductRsDbObject> list = convertToBatchProductRsDbObjectList(Arrays.asList(batchproductRs));
			batchProductRsDbObjectMapper.updateByPrimaryKeySelective(list.get(0));
		}
			
	}
	
	public List<BatchIntakeProductVO> getAllBatchProductVoByBatchId(Integer batchId) {
		List<BatchProductRsVO> rsList = getBatchproductByBatchId(batchId);
		List<BatchIntakeProductVO> productVoList = new ArrayList<BatchIntakeProductVO>();
		if(rsList.size() != 0){
			for(BatchProductRsVO rs: rsList){
				BatchIntakeProductVO batchProduct = new BatchIntakeProductVO();
				ProductSubOptionRsVO productoptionrs = productSubOptionRsService.getProductSubOptionRsById(rs.getProductSubOptionId());
				ProductVO product = productService.getProductsById(productoptionrs.getProductId());
				batchProduct.setProduct(product);
				batchProduct.setQty(rs.getQty());
				batchProduct.setUnitcost(rs.getUnitCost());
				batchProduct.setBatchProductId(rs.getBatchProductRsId());
				batchProduct.setSubOptionList(new ArrayList<ProductSubOptionVO>());
				if(productoptionrs.getSuboption1Id() != null && productoptionrs.getSuboption1Id() > 0){
					ProductSubOptionVO subOption1 = productSubOptionManagementService.getSubOptionVo(productoptionrs.getSuboption1Id());
					if(subOption1 != null){
						batchProduct.getSubOptionList().add(subOption1);
					}
				}
				if(productoptionrs.getSuboption2Id() != null && productoptionrs.getSuboption2Id() > 0){
					ProductSubOptionVO subOption2 = productSubOptionManagementService.getSubOptionVo(productoptionrs.getSuboption2Id());
					if(subOption2 != null){
						batchProduct.getSubOptionList().add(subOption2);
					}
				}
				if(productoptionrs.getSuboption3Id() != null && productoptionrs.getSuboption3Id() > 0){
					ProductSubOptionVO subOption3 = productSubOptionManagementService.getSubOptionVo(productoptionrs.getSuboption3Id());
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
