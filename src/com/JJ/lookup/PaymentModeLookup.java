package com.JJ.lookup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.JJ.lookupservice.PaymentModeService;
import com.JJ.model.PaymentMode;
@Lazy
@Component
public class PaymentModeLookup {
	private static final Logger logger = Logger.getLogger(PaymentModeLookup.class);
	private PaymentModeService paymentModeService;
	private List<PaymentMode> paymentModeList;
	private Map<String, PaymentMode> paymentModeByValueMap = new HashMap<String, PaymentMode>();
	private Map<Integer, PaymentMode> paymentModeByIdMap = new HashMap<Integer, PaymentMode>();
	
	@Autowired
	public PaymentModeLookup(PaymentModeService paymentModeService){
		logger.debug("PaymentModeLookup initialized");
		this.paymentModeService = paymentModeService;
		load();
	}
	private void load() {
		paymentModeList = paymentModeService.getPaymentMode();
		if(paymentModeList != null){
			for(PaymentMode paymentMode : paymentModeList){
				paymentModeByValueMap.put(paymentMode.getMode(), paymentMode);
				paymentModeByIdMap.put(paymentMode.getPaymentmodeid(), paymentMode);
			}
		}
	}
	public List<PaymentMode> getPaymentModeList() {
		return paymentModeList;
	}
	public void setPaymentModeList(List<PaymentMode> paymentModeList) {
		this.paymentModeList = paymentModeList;
	}
	public Map<String, PaymentMode> getPaymentModeByValueMap() {
		return paymentModeByValueMap;
	}
	public void setPaymentModeByValueMap(
			Map<String, PaymentMode> paymentModeByValueMap) {
		this.paymentModeByValueMap = paymentModeByValueMap;
	}
	public Map<Integer, PaymentMode> getPaymentModeByIdMap() {
		return paymentModeByIdMap;
	}
	public void setPaymentModeByIdMap(Map<Integer, PaymentMode> paymentModeByIdMap) {
		this.paymentModeByIdMap = paymentModeByIdMap;
	}
}
