package com.JJ.service.paymentmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.paymentmanagement.vo.ChequeVO;
import com.JJ.dao.ChequeDbObjectMapper;
import com.JJ.model.ChequeDbObject;

@Service
@Transactional
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
	
	public void saveCheque(ChequeVO chequeVO) {
		if(chequeVO != null){
			ChequeDbObject dbObj = convertToChequeDbObjectList(Arrays.asList(chequeVO)).get(0);
			chequeDbObjectMapper.insert(dbObj);
		}
	}

	private List<ChequeVO> convertToChequeVOList(List<ChequeDbObject> chequeDbObjectList) {
		List<ChequeVO> chequeVOList = new ArrayList<ChequeVO>();
		if(chequeDbObjectList != null && !chequeDbObjectList.isEmpty()) {
			for(ChequeDbObject dbObj : chequeDbObjectList) {
				ChequeVO vo = new ChequeVO();
				vo.setBounceChequeInd(dbObj.getBounceChequeInd());
				vo.setChequeAmt(dbObj.getChequeAmt());
				vo.setChequeDate(dbObj.getChequeDate());
				vo.setChequeId(dbObj.getChequeId());
				vo.setChequeNum(dbObj.getChequeNum());
				vo.setDebitDate(dbObj.getDebitDate());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setRemarks(dbObj.getRemarks());
				vo.setVersion(dbObj.getVersion());
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
				dbObj.setChequeDate(vo.getChequeDate());
				dbObj.setChequeId(vo.getChequeId());
				dbObj.setChequeNum(vo.getChequeNum());
				dbObj.setDebitDate(vo.getDebitDate());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setRemarks(vo.getRemarks());
				dbObj.setVersion(vo.getVersion());
				chequeDbObjectList.add(dbObj);
			}
		}
		return chequeDbObjectList;
	}
	
}
