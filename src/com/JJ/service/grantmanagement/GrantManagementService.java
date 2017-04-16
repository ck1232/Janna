package com.JJ.service.grantmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.dao.GrantDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.GrantDbObject;
import com.JJ.model.GrantDbObjectExample;

@Service
@Transactional
public class GrantManagementService {
	
	private GrantDbObjectMapper grantDbObjectMapper;
	@Autowired
	public GrantManagementService(GrantDbObjectMapper grantDbObjectMapper) {
		this.grantDbObjectMapper = grantDbObjectMapper;
	}

	public List<InvoiceVO> getAllGrant() {
		GrantDbObjectExample grantDbObjectExample = new GrantDbObjectExample();
		grantDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToInvoiceVOList(grantDbObjectMapper.selectByExample(grantDbObjectExample));
	}
	
	public List<InvoiceVO> getAllGrantByIdList(List<Integer> idList) {
		if(idList != null && idList.size() > 0){
			GrantDbObjectExample grantDbObjectExample = new GrantDbObjectExample();
			grantDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andGrantIdIn(idList);
			grantDbObjectExample.setOrderByClause("grant_date desc");
			return convertToInvoiceVOList(grantDbObjectMapper.selectByExample(grantDbObjectExample));
		}
		return new ArrayList<InvoiceVO>();
	}
	
	public InvoiceVO getGrantById(Integer id) {
		GrantDbObject grantDbObject = grantDbObjectMapper.selectByPrimaryKey(id);
		if(grantDbObject != null && grantDbObject.getGrantId() != null){
			return convertToInvoiceVOList(Arrays.asList(grantDbObject)).get(0);
		}else{
			return new InvoiceVO();
		}
	}
	
	
	public void saveGrant(InvoiceVO invoiceVO) {
		if(invoiceVO != null){
			GrantDbObject dbObj = convertToGrantDbObjectList(Arrays.asList(invoiceVO)).get(0);
			grantDbObjectMapper.insert(dbObj);
			invoiceVO.setGrantId(dbObj.getGrantId());
		}
	}
	
	public void updateGrant(InvoiceVO invoiceVO) {
		if(invoiceVO != null && invoiceVO.getGrantId() != null){
			GrantDbObject dbObj = convertToGrantDbObjectList(Arrays.asList(invoiceVO)).get(0);
			dbObj.setOrganisation(invoiceVO.getMessenger());
			dbObj.setGrantDate(invoiceVO.getInvoiceDate());
			dbObj.setTotalAmt(invoiceVO.getTotalAmt());
			dbObj.setStatus(invoiceVO.getStatus());
			grantDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	public void saveGrantList(List<InvoiceVO> invoiceVOList) {
		for(InvoiceVO invoiceVO : invoiceVOList)
			saveGrant(invoiceVO);
	}
	
	public void deleteGrant(Integer id) {
		deleteGrant(Arrays.asList(id));
	}
	
	public void deleteGrant(List<Integer> idList) {
		GrantDbObjectExample grantDbObjectExample = new GrantDbObjectExample();
		grantDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andGrantIdIn(idList);
		GrantDbObject dbObj = new GrantDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		grantDbObjectMapper.updateByExampleSelective(dbObj, grantDbObjectExample);
	}
	
	private List<InvoiceVO> convertToInvoiceVOList(List<GrantDbObject> grantDbObjectList) {
		List<InvoiceVO> grantVOList = new ArrayList<InvoiceVO>();
		if(grantDbObjectList != null && grantDbObjectList.size() > 0) {
			for(GrantDbObject dbObj : grantDbObjectList) {
				InvoiceVO vo = new InvoiceVO();
				vo.setGrantId(dbObj.getGrantId());
				vo.setInvoiceDate(dbObj.getGrantDate());
				vo.setInvoicedateString(GeneralUtils.convertDateToString(dbObj.getGrantDate(), "dd/MM/yyyy"));
				vo.setMessenger(dbObj.getOrganisation());
				vo.setStatus(dbObj.getStatus());
				vo.setTotalAmt(dbObj.getTotalAmt());
				vo.setType("grant");
				vo.setVersion(dbObj.getVersion());
				grantVOList.add(vo);
			}
		}
		return grantVOList;
	}
	
	private List<GrantDbObject> convertToGrantDbObjectList(List<InvoiceVO> invoiceVOList) {
		List<GrantDbObject> grantDbObjectList = new ArrayList<GrantDbObject>();
		if(invoiceVOList != null && invoiceVOList.size() > 0){
			for(InvoiceVO vo : invoiceVOList){
				GrantDbObject dbObj = new GrantDbObject();
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setGrantDate(GeneralUtils.convertStringToDate(vo.getInvoicedateString(),"dd/MM/yyyy"));
				dbObj.setGrantId(vo.getGrantId());
				dbObj.setOrganisation(vo.getMessenger());
				dbObj.setStatus(vo.getStatus());
				dbObj.setTotalAmt(vo.getTotalAmt());
				dbObj.setVersion(vo.getVersion());
				grantDbObjectList.add(dbObj);
			}
		}
		return grantDbObjectList;
	}
	
}
