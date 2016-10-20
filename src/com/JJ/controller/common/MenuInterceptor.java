package com.JJ.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.JJ.model.Menu;
@Component
public class MenuInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private CommonController commonController;
	@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		Menu menu  = (Menu) request.getSession().getAttribute("menu");
		UserDetails user = (UserDetails) request.getSession().getAttribute("user");
		
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
			
		}
		return super.preHandle(request, response, handler);
	}
}
