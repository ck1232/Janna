package com.JJ.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.JJ.model.Menu;
import com.JJ.model.Submodulepermissiontype;
import com.JJ.service.permissionmanagement.PermissionManagementService;
@Component
public class MenuInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private CommonController commonController;
	@Autowired
	private PermissionManagementService permissionManagementService;
	@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		Menu menu  = (Menu) request.getSession().getAttribute("menu");
		UserDetails user = null;
		Object userObj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userObj instanceof UserDetails){
			user = (UserDetails)userObj ;
		}else{
			return super.preHandle(request, response, handler);
		}
		
		if(user != null){
			DateTime now = new DateTime();
			DateTime lastUpdateTime = new DateTime(menu==null?null:menu.getDteUpdated());
			if(menu != null &&  Minutes.minutesBetween(lastUpdateTime, now).getMinutes() <= 5){
				//record still fresh, dont need refresh
			}
			else{
				menu = commonController.populateMenu(user);
				request.getSession().setAttribute("menu", menu);
			}

			String urlPrefix = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
			String mappedUrl = request.getRequestURI().toString().replace(urlPrefix, "").replace(request.getContextPath(), "");
			if(!mappedUrl.contains("development")){
				Submodulepermissiontype submodule = permissionManagementService.getSubmodulepermissiontypeByUrl(mappedUrl);
				if(submodule != null){
					request.getSession().setAttribute("menuSubmodule", submodule);
				}
//				System.out.println(mappedUrl);
			}
			
		}
		return super.preHandle(request, response, handler);
	}
}
