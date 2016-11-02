package com.JJ.security;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

import com.JJ.service.permissionmanagement.PermissionManagementService;


@Service
public class UrlVoter implements AccessDecisionVoter<FilterInvocation>{
	
	@Autowired
	private PermissionManagementService permissionManagementService;
	
    @Override
    public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> collection) {
    	String url = fi.getRequestUrl();
    	HttpSession session = fi.getRequest().getSession();
    	@SuppressWarnings("unchecked")
		List<String> allowedUrlList = (List<String>) session.getAttribute("allowedUrl");
    	
    	int index = url.indexOf('?');
    	if(index >= 0){
    		url = url.substring(0,index);
    	}
    	System.out.println("voter:"+url);
    	
    	if(authentication == null ){
    		return ACCESS_DENIED;
    	}
    	if(url.equalsIgnoreCase("/") || url.equalsIgnoreCase("/dashboard")){
    		return ACCESS_GRANTED;
    	}
    	if(allowedUrlList != null && allowedUrlList.size() > 0){
    		for(String allowedUrl : allowedUrlList){
        		if(allowedUrl.contains(url) || url.contains(allowedUrl)){
        			System.out.println("allowed url:"+allowedUrl);
        			return ACCESS_GRANTED;
        		}
        	}
    	}
    	return ACCESS_ABSTAIN;
        
//            return ACCESS_DENIED; // Abstain Based on your requirement
    }

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(FilterInvocation.class);
	}

}