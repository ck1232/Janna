package com.JJ.controller.common;

import java.util.List;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.JJ.model.LoginForm;
import com.JJ.model.Menu;
import com.JJ.model.Submodulepermissiontype;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.mysql.jdbc.util.Base64Decoder;
@Component
public class MenuInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(MenuInterceptor.class);
	@Autowired
	private CommonController commonController;
	@Autowired
	private PermissionManagementService permissionManagementService;
	@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		LoginForm userData = null;
		logger.info(request.getRequestURI());
		if( !request.getRequestURI().equals("/JJ/login") && !request.getRequestURI().equals("/logout")
				&& !request.getRequestURI().startsWith("/JJ/development/")){
			userData = (LoginForm) request.getSession().getAttribute("LOGGEDIN_USER");
			logger.info(userData != null ? userData.getUsername():"null");
		}
		Menu menu  = (Menu) request.getSession().getAttribute("menu");
		/*UserDetails user = null;
		Object userObj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userObj instanceof UserDetails){
			user = (UserDetails)userObj ;
			if(user.getUsername() != null){
				//user = new User(user.getUsername(), getPassword(user.getPassword()), user.getAuthorities());
			}
		}else{
			return super.preHandle(request, response, handler);
		}*/
		
		if(userData != null){
			DateTime now = new DateTime();
			DateTime lastUpdateTime = new DateTime(menu==null?null:menu.getDteUpdated());
			if(menu != null &&  Minutes.minutesBetween(lastUpdateTime, now).getMinutes() <= 5){
				//record still fresh, dont need refresh
			}
			else{
				menu = commonController.populateMenu(userData.getUsername());
				request.getSession().setAttribute("menu", menu);
				List<Submodulepermissiontype> urlList = permissionManagementService.getSubmodulepermissiontypeByUrl();
				request.getSession().setAttribute("urlList", urlList);
			}

			String urlPrefix = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
			String mappedUrl = request.getRequestURI().toString().replace(urlPrefix, "").replace(request.getContextPath(), "");
			if(!mappedUrl.contains("development")){
				@SuppressWarnings("unchecked")
				List<Submodulepermissiontype> urlList = (List<Submodulepermissiontype>) request.getSession().getAttribute("urlList");
				if(urlList == null){
					urlList = permissionManagementService.getSubmodulepermissiontypeByUrl();
					request.getSession().setAttribute("urlList", urlList);
				}
				if(urlList != null && urlList.size() > 0){
					for(Submodulepermissiontype obj : urlList){
						if(obj != null && obj.getUrl().compareTo(mappedUrl) == 0){
							request.getSession().setAttribute("menuSubmodule", obj);
						}
					}
				}
				
//				System.out.println(mappedUrl);
			}
		}
		return super.preHandle(request, response, handler);
	}
	
	
	
}
