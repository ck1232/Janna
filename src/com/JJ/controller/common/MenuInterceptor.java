package com.JJ.controller.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.JJ.controller.common.vo.ModuleVO;
import com.JJ.controller.common.vo.SubModulePermissionTypeVO;
import com.JJ.controller.common.vo.SubModulePermissionVO;
import com.JJ.controller.common.vo.SubModuleVO;
import com.JJ.controller.common.vo.UserRoleVO;
import com.JJ.controller.common.vo.UserVO;
import com.JJ.dao.ModuleDbObjectMapper;
import com.JJ.dao.SubModuleDbObjectMapper;
import com.JJ.dao.SubModulePermissionDbObjectMapper;
import com.JJ.dao.SubModulePermissionTypeDbObjectMapper;
import com.JJ.dao.UserDbObjectMapper;
import com.JJ.dao.UserRoleDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ModuleDbObject;
import com.JJ.model.ModuleDbObjectExample;
import com.JJ.model.SubModuleDbObject;
import com.JJ.model.SubModuleDbObjectExample;
import com.JJ.model.SubModulePermissionDbObject;
import com.JJ.model.SubModulePermissionDbObjectExample;
import com.JJ.model.SubModulePermissionTypeDbObject;
import com.JJ.model.SubModulePermissionTypeDbObjectExample;
import com.JJ.model.UserDbObject;
import com.JJ.model.UserDbObjectExample;
import com.JJ.model.UserRoleDbObject;
import com.JJ.model.UserRoleDbObjectExample;
@Component
public class MenuInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private SubModulePermissionTypeDbObjectMapper subModulePermissionTypeDbObjectMapper;
	@Autowired
	private ModuleDbObjectMapper moduleDbObjectMapper;
	@Autowired
	private UserDbObjectMapper userDbObjectMapper;
	@Autowired
	private UserRoleDbObjectMapper userRoleDbObjectMapper;
	@Autowired
	private SubModulePermissionDbObjectMapper subModulePermissionDbObjectMapper;
	@Autowired
	private SubModuleDbObjectMapper subModuleDbObjectMapper;
	public MenuInterceptor() {
		super();
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
				menu = populateMenu(user);
				request.getSession().setAttribute("menu", menu);
				List<SubModulePermissionTypeVO> urlList = getSubmodulepermissiontypeByUrl();
				request.getSession().setAttribute("urlList", urlList);
			}

			String urlPrefix = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
			String mappedUrl = request.getRequestURI().toString().replace(urlPrefix, "").replace(request.getContextPath(), "");
			if(!mappedUrl.contains("development")){
				@SuppressWarnings("unchecked")
				List<SubModulePermissionTypeVO> urlList = (List<SubModulePermissionTypeVO>) request.getSession().getAttribute("urlList");
				if(urlList == null){
					urlList = getSubmodulepermissiontypeByUrl();
					request.getSession().setAttribute("urlList", urlList);
				}
				if(urlList != null && urlList.size() > 0){
					for(SubModulePermissionTypeVO obj : urlList){
						if(obj != null && (obj.getUrl().contains(mappedUrl) || mappedUrl.contains(obj.getUrl()))){
							request.getSession().setAttribute("menuSubmodule", obj);
						}
					}
				}
			}
			
		}
		return super.preHandle(request, response, handler);
	}
	
	public MenuVO populateMenu(UserDetails user){
		MenuVO menu = new MenuVO();
		
		List<SubModuleVO> subModuleList = getAllSubModuleByUserId(user.getUsername());
		List<ModuleVO> moduleList = getAllModules();
//		List<Submodule> submoduleList = subModuleManagementService.getAllSubmodules();
		
		if(subModuleList != null && subModuleList.size() > 0){
			Map<Integer, List<SubModuleVO>> subModuleMap = new HashMap<Integer, List<SubModuleVO>>();
			for(SubModuleVO subModule : subModuleList){
				if(subModuleMap.get(subModule.getParentId()) == null){
					subModuleMap.put(subModule.getParentId(), new ArrayList<SubModuleVO>());
				}
				subModuleMap.get(subModule.getParentId()).add(subModule);
			}
			for(ModuleVO module : moduleList){
				module.setSubModuleList(subModuleMap.get(module.getModuleId()));
			}
			
		}
		menu.setModuleList(moduleList);
		menu.setDteUpdated(new Date());
		return menu;
	}
	
	private List<SubModuleVO> getAllSubModuleByUserId(String userId){
		List<Integer> roleIdList = new ArrayList<Integer>();
		List<Integer> subModuleIdList = new ArrayList<Integer>();
		UserVO dbUser = findByUserName(userId);
		if(dbUser == null){
			return null;
		}
		List<UserRoleVO> roleList = getRoleListByUserId(dbUser.getUserId());
		for(UserRoleVO userRole: roleList){
			roleIdList.add(userRole.getRoleId());
		}
		if(roleIdList.size() == 0){
			return null;
		}
		List<SubModulePermissionVO> submodulepermissionList = getSubmoduleByRole(roleIdList);
		for(SubModulePermissionVO obj : submodulepermissionList){
			subModuleIdList.add(obj.getSubmoduleId());
		}
		if(subModuleIdList.size() == 0){
			return null;
		}
		return getSubmodulesById(subModuleIdList);
	}
	
	public List<SubModulePermissionTypeVO> getSubmodulepermissiontypeByUrl(){
		SubModulePermissionTypeDbObjectExample example = new SubModulePermissionTypeDbObjectExample();
		example.createCriteria();
		List<SubModulePermissionTypeDbObject> resultList = subModulePermissionTypeDbObjectMapper.selectByExample(example);
		List<SubModulePermissionTypeVO> voList = convertToSubModulePermissionTypeVOList(resultList);
		return voList;
	}
	
	public List<ModuleVO> getAllModules() {
		ModuleDbObjectExample moduleExample = new ModuleDbObjectExample();
		moduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ModuleDbObject> moduleDbObjectList = moduleDbObjectMapper.selectByExample(moduleExample);
		return convertToModuleVOList(moduleDbObjectList);
	}
	
	private List<ModuleVO> convertToModuleVOList(List<ModuleDbObject> dbObjList) {
		List<ModuleVO> voList = new ArrayList<ModuleVO>();
		if(dbObjList != null && !dbObjList.isEmpty()){
			for(ModuleDbObject dbObj : dbObjList){
				ModuleVO vo = new ModuleVO();
				vo.setIcon(dbObj.getIcon());
				vo.setModuleId(dbObj.getModuleId().longValue());
				vo.setModuleName(dbObj.getModuleName());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public UserVO findByUserName(String userName) {
		UserDbObjectExample example = new UserDbObjectExample();
		example.createCriteria().andUserNameEqualTo(userName).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<UserDbObject> dbObjList = userDbObjectMapper.selectByExample(example);
		List<UserVO> voList = convertToUserVOList(dbObjList);
		if(voList != null && voList.size() > 0){
			UserVO user = voList.get(0);
			return user;
		}else{
			return null;
		}
	}
	
	private List<UserVO> convertToUserVOList(List<UserDbObject> dbObjList) {
		List<UserVO> list = new ArrayList<UserVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(UserDbObject dbObj : dbObjList){
				UserVO vo = new UserVO();
				vo.setEmailAddress(dbObj.getEmailAddress());
				vo.setEnabled(dbObj.getEnabled());
				vo.setEnabledBoolean(dbObj.getEnabled().equals("Y")? Boolean.TRUE : Boolean.FALSE);
				vo.setLastLogin(dbObj.getLastLogin());
				vo.setName(dbObj.getName());
				vo.setPassword(dbObj.getPassword());
				vo.setStatus(dbObj.getStatus());
				vo.setUserId(dbObj.getUserId());
				vo.setUserName(dbObj.getUserName());
				list.add(vo);
			}
		}
		return list;
	}
	
	private List<SubModulePermissionTypeVO> convertToSubModulePermissionTypeVOList(List<SubModulePermissionTypeDbObject> dbObjList) {
		List<SubModulePermissionTypeVO> voList = new ArrayList<SubModulePermissionTypeVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(SubModulePermissionTypeDbObject obj : dbObjList){
				SubModulePermissionTypeVO vo = new SubModulePermissionTypeVO();
				vo.setPermissionType(obj.getPermissionType());
				vo.setSeqNum(obj.getSeqNum());
				vo.setSubmoduleId(obj.getSubmoduleId());
				vo.setTypeId(obj.getTypeId());
				vo.setUrl(obj.getUrl());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public List<UserRoleVO> getRoleListByUserId(Integer userId){
		UserRoleDbObjectExample userRoleExample = new UserRoleDbObjectExample();
		userRoleExample.createCriteria().andUserIdEqualTo(userId).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToUserRoleVOList(userRoleDbObjectMapper.selectByExample(userRoleExample));
	}
	
	private List<UserRoleVO> convertToUserRoleVOList(List<UserRoleDbObject> objList) {
		List<UserRoleVO> voList = new ArrayList<UserRoleVO>();
		if(objList != null && objList.size() > 0){
			for(UserRoleDbObject obj : objList){
				UserRoleVO vo = new UserRoleVO();
				vo.setDeleteInd(obj.getDeleteInd());
				vo.setRoleId(obj.getRoleId());
				vo.setUserId(obj.getUserId());
				vo.setUserRoleId(obj.getUserRoleId());
				vo.setVersion(obj.getVersion());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public List<SubModulePermissionVO> getSubmoduleByRole(List<Integer> roleIdList){
		if(roleIdList == null || roleIdList.size() == 0){
			return new ArrayList<SubModulePermissionVO>();
		}
		SubModulePermissionDbObjectExample example = new SubModulePermissionDbObjectExample();
		example.createCriteria().andRoleIdIn(roleIdList).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToSubModulePermissionVOList(subModulePermissionDbObjectMapper.selectByExample(example));
	}
	
	private List<SubModulePermissionVO> convertToSubModulePermissionVOList(List<SubModulePermissionDbObject> dbObjList) {
		List<SubModulePermissionVO> voList = new ArrayList<SubModulePermissionVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(SubModulePermissionDbObject dbObj : dbObjList){
				SubModulePermissionVO vo = new SubModulePermissionVO();
				vo.setPermissionId(dbObj.getPermissionId());
				vo.setPermissionTypeId(dbObj.getPermissionTypeId());
				vo.setRoleId(dbObj.getRoleId());
				vo.setSubmoduleId(dbObj.getSubmoduleId());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public List<SubModuleVO> getSubmodulesById(List<Integer> subModuleList) {
		if(subModuleList != null && !subModuleList.isEmpty()){
			SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
			submoduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSubmoduleIdIn(subModuleList);
			List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
			return convertToSubModuleVOList(submoduleList);
		}
		return new ArrayList<SubModuleVO>();
	}
	
	private List<SubModuleVO> convertToSubModuleVOList(List<SubModuleDbObject> dbObjList) {
		List<SubModuleVO> voList = new ArrayList<SubModuleVO>();
		if(dbObjList != null && !dbObjList.isEmpty()){
			for(SubModuleDbObject dbObj : dbObjList){
				SubModuleVO vo = new SubModuleVO();
				vo.setIcon(dbObj.getIcon());
				vo.setName(dbObj.getName());
				vo.setParentId(dbObj.getParentId());
				vo.setSubmoduleId(dbObj.getSubmoduleId());
				vo.setUrl(dbObj.getUrl());
				voList.add(vo);
			}
		}
		return voList;
	}
}
