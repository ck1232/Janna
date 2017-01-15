package com.JJ.service.paypal;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import urn.ebay.api.PayPalAPI.BMCreateButtonReq;
import urn.ebay.api.PayPalAPI.BMCreateButtonRequestType;
import urn.ebay.api.PayPalAPI.BMCreateButtonResponseType;
import urn.ebay.api.PayPalAPI.BMUpdateButtonReq;
import urn.ebay.api.PayPalAPI.BMUpdateButtonRequestType;
import urn.ebay.api.PayPalAPI.BMUpdateButtonResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.apis.eBLBaseComponents.AckCodeType;
import urn.ebay.apis.eBLBaseComponents.ButtonCodeType;
import urn.ebay.apis.eBLBaseComponents.ButtonTypeType;

import com.JJ.helper.GeneralUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class PayPalService {
	private static final Logger logger = Logger.getLogger(PayPalService.class);
	private PayPalAPIInterfaceServiceService payPalAPIInterfaceService;

	public PayPalService(){
		payPalAPIInterfaceService = new PayPalAPIInterfaceServiceService(getDevCustomConfigurationMap());
	}
	
	public String createCartButton(String productName, String productId, Double amount, String url) throws Exception{
		BMCreateButtonReq request = new BMCreateButtonReq();
		BMCreateButtonRequestType reqType = new BMCreateButtonRequestType();
		
		reqType.setButtonType(ButtonTypeType.CART);
		reqType.setButtonCode(ButtonCodeType.HOSTED);
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		List<String> lst = new ArrayList<String>();
		lst.add("item_name=" + productName);
		lst.add("item_number=" + productId);
		lst.add("currency_code="+"SGD");
		lst.add("business=" + "behchoonkeat-facilitator@hotmail.com");
		lst.add("amount=" + df.format(amount));
		lst.add("notify_url=" + url);
		reqType.setButtonVar(lst);
		
		request.setBMCreateButtonRequest(reqType);
		try {
			BMCreateButtonResponseType resp = payPalAPIInterfaceService.bMCreateButton(request);
			if(resp != null){
				if(resp.getAck().toString().equals(AckCodeType.SUCCESS.name())){
					return resp.getHostedButtonID();
				}else{
					throw new PayPalErrorException(resp.getErrors());
				}
			}
		} catch (Exception e) {
			if(e instanceof PayPalErrorException){
				logger.error(((PayPalErrorException)e).getPayPalErrorMsg());
			}else{
				logger.error(e.getMessage());
			}
			e.printStackTrace();
			throw e;
		}
		return null;
	}
	
	public String updateCartButton(String productName, String productId, Double amount, String url, String buttonId) throws Exception{
		BMUpdateButtonReq  request = new BMUpdateButtonReq ();
		BMUpdateButtonRequestType reqType = new BMUpdateButtonRequestType();
		
		reqType.setButtonType(ButtonTypeType.CART);
		reqType.setButtonCode(ButtonCodeType.HOSTED);
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		List<String> lst = new ArrayList<String>();
		lst.add("item_name=" + productName);
		lst.add("item_number=" + productId);
		lst.add("currency_code="+"SGD");
		lst.add("business=" + "behchoonkeat-facilitator@hotmail.com");
		lst.add("amount=" + df.format(amount));
		lst.add("notify_url=" + url);
		reqType.setButtonVar(lst);
		reqType.setHostedButtonID(buttonId);
		request.setBMUpdateButtonRequest(reqType);
		try {
			BMUpdateButtonResponseType resp = payPalAPIInterfaceService.bMUpdateButton(request);
			if(resp != null){
				if(resp.getAck().toString().equals(AckCodeType.SUCCESS.name())){
					return resp.getHostedButtonID();
				}else{
					throw new PayPalErrorException(resp.getErrors());
				}
			}
		} catch (Exception e) {
			if(e instanceof PayPalErrorException){
				logger.error(((PayPalErrorException)e).getPayPalErrorMsg());
			}else{
				logger.error(e.getMessage());
			}
			e.printStackTrace();
			throw e;
		}
		return null;
	}
	
	private static final Map<String, String> getDevCustomConfigurationMap(){
		Map<String, String> customConfigurationMap = new HashMap<String, String>();
		customConfigurationMap.put("mode", "sandbox");
		customConfigurationMap.put("acct1.UserName", "behchoonkeat-facilitator_api1.hotmail.com");
		customConfigurationMap.put("acct1.Password", "NXTYCSDD4S77AKWD");
		customConfigurationMap.put("acct1.AppId","APP-80W284485P519543T");
		customConfigurationMap.put("acct1.Signature", "AFcWxV21C7fd0v3bYYYRCpSSRl31A1689rysgedRS0OlTfMq0NJf-Poi");
		
		customConfigurationMap.put("http.ConnectionTimeOut", "5000");
		customConfigurationMap.put("http.Retry", "2");
		customConfigurationMap.put("http.ReadTimeOut", "3000");
		customConfigurationMap.put("http.MaxConnection", "100");
		customConfigurationMap.put("http.IPAddress", "127.0.0.1");
		
		customConfigurationMap.put("http.UseProxy", "false");
		customConfigurationMap.put("http.ProxyPort", "8080");
		customConfigurationMap.put("http.ProxyHost", "127.0.0.1");
		customConfigurationMap.put("http.ProxyUserName", "null");
		customConfigurationMap.put("http.ProxyPassword", "null");
		
		customConfigurationMap.put("http.GoogleAppEngine", "false");
		customConfigurationMap.put("sandbox.EmailAddress", "behchoonkeat@hotmail.com");
		return customConfigurationMap;
	}
	
	
}
