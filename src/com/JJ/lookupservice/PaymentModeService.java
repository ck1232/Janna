package com.JJ.lookupservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.PaymentModeDbObjectMapper;
import com.JJ.lookup.vo.PaymentModeVO;
import com.JJ.model.PaymentModeDbObject;
import com.JJ.model.PaymentModeDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class PaymentModeService {
	private PaymentModeDbObjectMapper paymentModeDbObjectMapper;
	
	@Autowired
	public PaymentModeService(PaymentModeDbObjectMapper paymentModeDbObjectMapper) {
		super();
		this.paymentModeDbObjectMapper = paymentModeDbObjectMapper;
	}
	public List<PaymentModeVO> getPaymentMode(){
		PaymentModeDbObjectExample paymentModeDbObjectExample = new PaymentModeDbObjectExample();
		return convertToPaymentModeVOList(paymentModeDbObjectMapper.selectByExample(paymentModeDbObjectExample));
	}

	private List<PaymentModeVO> convertToPaymentModeVOList(List<PaymentModeDbObject> paymentModeDbObjectList) {
		List<PaymentModeVO> paymentModeVOList = new ArrayList<PaymentModeVO>();
		if(paymentModeDbObjectList != null && paymentModeDbObjectList.size() > 0) {
			for(PaymentModeDbObject dbObj : paymentModeDbObjectList) {
				PaymentModeVO vo = new PaymentModeVO();
				vo.setDeleteInd(dbObj.getDeleteInd());;
				vo.setPaymentMode(dbObj.getPaymentMode());
				vo.setPaymentModeId(dbObj.getPaymentModeId());
				vo.setVersion(dbObj.getVersion());
				paymentModeVOList.add(vo);
			}
		}
		return paymentModeVOList;
	}
	
}
