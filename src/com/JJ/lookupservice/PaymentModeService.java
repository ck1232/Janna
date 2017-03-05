package com.JJ.lookupservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.PaymentModeMapper;
import com.JJ.model.PaymentMode;
import com.JJ.model.PaymentModeExample;

@Service
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class PaymentModeService {
	private PaymentModeMapper paymentModeMapper;
	
	@Autowired
	public PaymentModeService(PaymentModeMapper paymentModeMapper) {
		super();
		this.paymentModeMapper = paymentModeMapper;
	}
	public List<PaymentMode> getPaymentMode(){
		PaymentModeExample example = new PaymentModeExample();
		return paymentModeMapper.selectByExample(example);
	}

	
}
