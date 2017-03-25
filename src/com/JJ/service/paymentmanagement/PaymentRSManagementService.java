package com.JJ.service.paymentmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.paymentmanagement.vo.PaymentRsVO;
import com.JJ.dao.PaymentRsDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.PaymentRsDbObject;
import com.JJ.model.PaymentRsDbObjectExample;

@Service
@Transactional
public class PaymentRSManagementService {
	
	private PaymentRsDbObjectMapper paymentRsDbObjectMapper;
	
	@Autowired
	public PaymentRSManagementService(PaymentRsDbObjectMapper paymentRsDbObjectMapper) {
		this.paymentRsDbObjectMapper = paymentRsDbObjectMapper;
	}
	
	public List<PaymentRsVO> getAllPaymentByRefTypeAndRefId(String refType, Integer refId) {
		PaymentRsDbObjectExample paymentRsDbObjectExample = new PaymentRsDbObjectExample();
		paymentRsDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
								.andReferenceTypeEqualTo(refType)
								.andReferenceIdEqualTo(refId);
		return convertToPaymentRsVOList(paymentRsDbObjectMapper.selectByExample(paymentRsDbObjectExample));
		
	}
	
	public void savePaymentRs(PaymentRsVO paymentRsVO) {
		if(paymentRsVO != null){
			PaymentRsDbObject dbObj = convertToPaymentRsDbObjectList(Arrays.asList(paymentRsVO)).get(0);
			paymentRsDbObjectMapper.insert(dbObj);
		}
	}
	
	private List<PaymentRsVO> convertToPaymentRsVOList(List<PaymentRsDbObject> paymentRsDbObjectList) {
		List<PaymentRsVO> paymentRsVOList = new ArrayList<PaymentRsVO>();
		if(paymentRsDbObjectList != null && !paymentRsDbObjectList.isEmpty()) {
			for(PaymentRsDbObject dbObj : paymentRsDbObjectList) {
				PaymentRsVO vo = new PaymentRsVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setPaymentDetailId(dbObj.getPaymentDetailId());
				vo.setPaymentRsId(dbObj.getPaymentRsId());
				vo.setReferenceId(dbObj.getReferenceId());
				vo.setReferenceType(dbObj.getReferenceType());
				vo.setVersion(dbObj.getVersion());
				paymentRsVOList.add(vo);
			}
		}
		return paymentRsVOList;
	}
	
	private List<PaymentRsDbObject> convertToPaymentRsDbObjectList(List<PaymentRsVO> paymentRsVOList) {
		List<PaymentRsDbObject> paymentRsDbObjectList = new ArrayList<PaymentRsDbObject>();
		if(paymentRsVOList != null && !paymentRsVOList.isEmpty()){
			for(PaymentRsVO vo : paymentRsVOList) {
				PaymentRsDbObject dbObj = new PaymentRsDbObject();
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setPaymentDetailId(vo.getPaymentDetailId());
				dbObj.setPaymentRsId(vo.getPaymentRsId());
				dbObj.setReferenceId(vo.getReferenceId());
				dbObj.setReferenceType(vo.getReferenceType());
				dbObj.setVersion(vo.getVersion());
				paymentRsDbObjectList.add(dbObj);
			}
		}
		return paymentRsDbObjectList;
	}
	
}
