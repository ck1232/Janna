package com.JJ.service.chequemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.chequemanagement.vo.ChequeVO;
import com.JJ.dao.ChequeDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ChequeDbObject;
import com.JJ.model.ChequeDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ChequeManagementService {
	
	private ChequeDbObjectMapper chequeDbObjectMapper;
	
	@Autowired
	public ChequeManagementService(ChequeDbObjectMapper chequeDbObjectMapper) {
		this.chequeDbObjectMapper = chequeDbObjectMapper;
	}
	
	public ChequeVO findById(Integer id) {
		ChequeDbObject chequeDbObject = chequeDbObjectMapper.selectByPrimaryKey(id);
		if(chequeDbObject != null && chequeDbObject.getChequeId() != null){
			return convertToChequeVOList(Arrays.asList(chequeDbObject)).get(0);
		}else{
			return new ChequeVO();
		}
	}
	
	public List<ChequeVO> getAllCheque() {
		ChequeDbObjectExample chequeDbObjectExample = new ChequeDbObjectExample();
		chequeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToChequeVOList(chequeDbObjectMapper.selectByExample(chequeDbObjectExample));
	}
	
	public List<ChequeVO> getAllChequeByIdList(List<Integer> idList) {
		ChequeDbObjectExample chequeDbObjectExample = new ChequeDbObjectExample();
		chequeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andChequeIdIn(idList);
		chequeDbObjectExample.setOrderByClause("cheque_date desc");
		return convertToChequeVOList(chequeDbObjectMapper.selectByExample(chequeDbObjectExample));
	}
	
	public void saveCheque(ChequeVO chequeVO) {
		if(chequeVO != null){
			ChequeDbObject dbObj = convertToChequeDbObjectList(Arrays.asList(chequeVO)).get(0);
			chequeDbObjectMapper.insert(dbObj);
		}
	}
	
	public void bounceCheque(List<Integer> idList, Date bounceDate) {
		ChequeDbObjectExample chequeDbObjectExample = new ChequeDbObjectExample();
		chequeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andChequeIdIn(idList);
		ChequeDbObject dbObj = new ChequeDbObject();
		dbObj.setBounceChequeInd(GeneralUtils.YES_IND);
		dbObj.setBounceDate(bounceDate);
		chequeDbObjectMapper.updateByExampleSelective(dbObj, chequeDbObjectExample);
	}
	
	public void deleteCheque(Integer id) {
		deleteCheque(Arrays.asList(id));
	}
	
	public void deleteCheque(List<Integer> idList) {
		ChequeDbObjectExample chequeDbObjectExample = new ChequeDbObjectExample();
		chequeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andChequeIdIn(idList);
		ChequeDbObject dbObj = new ChequeDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		chequeDbObjectMapper.updateByExampleSelective(dbObj, chequeDbObjectExample);
	}
	
	public void updateCheque(ChequeVO chequeVO) {
		if(chequeVO != null && chequeVO.getChequeId() != null){
			ChequeDbObject dbObj = convertToChequeDbObjectList(Arrays.asList(chequeVO)).get(0);
			chequeDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}

	private List<ChequeVO> convertToChequeVOList(List<ChequeDbObject> chequeDbObjectList) {
		List<ChequeVO> chequeVOList = new ArrayList<ChequeVO>();
		if(chequeDbObjectList != null && !chequeDbObjectList.isEmpty()) {
			for(ChequeDbObject dbObj : chequeDbObjectList) {
				ChequeVO vo = new ChequeVO();
				vo.setBounceChequeInd(dbObj.getBounceChequeInd());
				vo.setBounceDate(dbObj.getBounceDate());
				vo.setBounceDateString(GeneralUtils.convertDateToString(dbObj.getBounceDate(), "dd/MM/yyyy"));
				vo.setChequeAmt(dbObj.getChequeAmt());
				vo.setChequeDate(dbObj.getChequeDate());
				vo.setChequeDateString(GeneralUtils.convertDateToString(dbObj.getChequeDate(), "dd/MM/yyyy"));
				vo.setChequeId(dbObj.getChequeId());
				vo.setChequeNum(dbObj.getChequeNum());
				vo.setDebitDate(dbObj.getDebitDate());
				vo.setDebitDateString(GeneralUtils.convertDateToString(dbObj.getDebitDate(), "dd/MM/yyyy"));
				vo.setRemarks(dbObj.getRemarks());
				chequeVOList.add(vo);
			}
		}
		return chequeVOList;
	}
	
	private List<ChequeDbObject> convertToChequeDbObjectList(List<ChequeVO> chequeVOList) {
		List<ChequeDbObject> chequeDbObjectList = new ArrayList<ChequeDbObject>();
		if(chequeVOList != null && !chequeVOList.isEmpty()){
			for(ChequeVO vo : chequeVOList){
				ChequeDbObject dbObj = new ChequeDbObject();
				dbObj.setBounceChequeInd(vo.getBounceChequeInd());
				dbObj.setChequeAmt(vo.getChequeAmt());
				dbObj.setChequeDate(GeneralUtils.convertStringToDate(vo.getChequeDateString(), "dd/MM/yyyy"));
				dbObj.setChequeId(vo.getChequeId());
				dbObj.setChequeNum(vo.getChequeNum());
				dbObj.setDebitDate(vo.getDebitDate());
				dbObj.setRemarks(vo.getRemarks());
				chequeDbObjectList.add(dbObj);
			}
		}
		return chequeDbObjectList;
	}
	
}
