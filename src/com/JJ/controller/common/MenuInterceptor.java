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

import com.JJ.controller.common.vo.MenuVO;
import com.JJ.controller.common.vo.SubModulePermissionTypeVO;
import com.JJ.service.permissionmanagement.PermissionManagementService;
@Component
public class MenuInterceptor extends HandlerInterceptorAdapter {
	private CommonController commonController;
	private PermissionManagementService permissionManagementService;
	@Autowired
	public MenuInterceptor(CommonController commonController,
			PermissionManagementService permissionManagementService) {
		super();
		this.commonController = commonController;
		this.permissionManagementService = permissionManagementService;
	}
	
	@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		MenuVO menu  = (MenuVO) request.getSession().getAttribute("menu");
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
				List<SubModulePermissionTypeVO> urlList = permissionManagementService.getSubmodulepermissiontypeByUrl();
				request.getSession().setAttribute("urlList", urlList);
			}

			String urlPrefix = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
			String mappedUrl = request.getRequestURI().toString().replace(urlPrefix, "").replace(request.getContextPath(), "");
			if(!mappedUrl.contains("development")){
				@SuppressWarnings("unchecked")
				List<SubModulePermissionTypeVO> urlList = (List<SubModulePermissionTypeVO>) request.getSession().getAttribute("urlList");
				if(urlList == null){
					urlList = permissionManagementService.getSubmodulepermissiontypeByUrl();
					request.getSession().setAttribute("urlList", urlList);
				}
				if(urlList != null && urlList.size() > 0){
					for(SubModulePermissionTypeVO obj : urlList){
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
