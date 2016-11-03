package com.JJ.controller.common;

import java.util.List;

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
						if(obj != null && (obj.getUrl().contains(mappedUrl) || mappedUrl.contains(obj.getUrl()))){
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
