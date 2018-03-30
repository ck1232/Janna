package com.JJ.service.submodulemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ModuleTO;
import com.JJ.TO.RoleTO;
import com.JJ.TO.SubModuleTO;
import com.JJ.controller.common.vo.ModuleVO;
import com.JJ.controller.common.vo.SubModuleVO;
import com.JJ.dao.SubModuleDbObjectMapper;
import com.JJ.dao.jpa.SubModuleDAO;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.SubModuleDbObject;
import com.JJ.model.SubModuleDbObjectExample;
import com.JJ.service.modulemanagement.ModuleManagementService;
import com.JJ.service.permissionmanagement.PermissionManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class SubModuleManagementService {
	
	private SubModuleDbObjectMapper subModuleDbObjectMapper;
	private SubModuleDAO submoduleDAO;
	private PermissionManagementService permissionManagementService;
	
	@Autowired
	public SubModuleManagementService(SubModuleDbObjectMapper subModuleDbObjectMapper,
			SubModuleDAO submoduleDAO,
			PermissionManagementService permissionManagementService) {
		this.subModuleDbObjectMapper = subModuleDbObjectMapper;
		this.submoduleDAO = submoduleDAO;
		this.permissionManagementService = permissionManagementService;
	}
	
	public SubModuleVO findById(Long id) {
		/*SubModuleDbObject dbObj = subModuleDbObjectMapper.selectByPrimaryKey(id);
		List<SubModuleVO> voList = convertToSubModuleVOList(Arrays.asList(dbObj));
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}
		return new SubModuleVO();*/
		SubModuleTO submoduleTO = submoduleDAO.findBySubmoduleId(id);
		List<SubModuleVO> submoduleVOList = convertToSubModuleVOList(Arrays.asList(submoduleTO));
		if(submoduleVOList != null && !submoduleVOList.isEmpty()){
			return submoduleVOList.get(0);
		}
		return new SubModuleVO();
		
	}

	public List<SubModuleVO> getAllSubmodules() {
		/*SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
		submoduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
		return convertToSubModuleVOList(submoduleList);*/
		List<SubModuleTO> submoduleTOList = submoduleDAO.findByDeleteInd(GeneralUtils.NOT_DELETED);
		return convertToSubModuleVOList(submoduleTOList);
	}
	
	public List<SubModuleVO> getSubmodulesById(List<Long> subModuleList) {
		/*if(subModuleList != null && !subModuleList.isEmpty()){
			SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
			submoduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSubmoduleIdIn(subModuleList);
			List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
			return convertToSubModuleVOList(submoduleList);
		}
		return new ArrayList<SubModuleVO>();*/
		List<SubModuleTO> submoduleTOList = submoduleDAO.findBySubmoduleIdIn(subModuleList);
		return convertToSubModuleVOList(submoduleTOList);
	}
	
	/*public List<SubModuleVO> getAllSubmodulesByModule(Integer moduleid) {
		SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
		submoduleExample.createCriteria().andParentIdEqualTo(moduleid).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
		return convertToSubModuleVOList(submoduleList);
	}*/
	
	/*public List<SubModuleVO> getAllSubmodulesOrderByClause(String orderByClause) {
		SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
		submoduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		submoduleExample.setOrderByClause(orderByClause);
		List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
		return convertToSubModuleVOList(submoduleList);
	}*/
	
	/*public void saveSubmodule(SubModuleVO submoduleVO) {
		if(submoduleVO != null){
			SubModuleDbObject dbObj = convertToSubModuleDbObjectList(Arrays.asList(submoduleVO)).get(0);
			subModuleDbObjectMapper.insert(dbObj);
		}
		List<SubModuleTO> submoduleTOList = convertToSubModuleTOList(Arrays.asList(submoduleVO));
		submoduleDAO.save(submoduleTOList);
	}*/
	
	public void deleteSubmodule(Long id) {
		deleteSubmodule(Arrays.asList(id));
		permissionManagementService.deleteSubmodulepermissionBySubmoduleId(id.intValue());
		permissionManagementService.deleteSubmodulepermissiontypeBySubmoduleId(id.intValue());
	}
	
	public void deleteSubmodule(List<Long> idList) {
		/*SubModuleDbObjectExample subModuleDbObjectExample = new SubModuleDbObjectExample();
		subModuleDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSubmoduleIdIn(idList);
		SubModuleDbObject dbObj = new SubModuleDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		subModuleDbObjectMapper.updateByExampleSelective(dbObj, subModuleDbObjectExample);*/
		List<SubModuleTO> submoduleTOList = submoduleDAO.findBySubmoduleIdIn(idList);
		if(submoduleTOList != null && !submoduleTOList.isEmpty()){
			for(SubModuleTO submoduleTO : submoduleTOList){
				submoduleTO.setDeleteInd(GeneralUtils.DELETED);
			}
			submoduleDAO.save(submoduleTOList);
		}
	}
	
	/*public void updateSubmodule(SubModuleVO vo) {
		if(submodule != null && submodule.getSubmoduleId() != null){
			List<SubModuleDbObject> dbObjList = convertToSubModuleDbObjectList(Arrays.asList(submodule));
			subModuleDbObjectMapper.updateByPrimaryKeySelective(dbObjList.get(0));
		}
		if(vo != null && vo.getSubmoduleId() != null){
			SubModuleTO submoduleTO = submoduleDAO.findBySubmoduleId(vo.getSubmoduleId());
			submoduleTO.setName(vo.getName());
			submoduleTO.setIcon(vo.getIcon());
			submoduleTO.setUrl(vo.getUrl());
			submoduleTO.setModuleTO(moduleManagementService.convertToModuleTOList(Arrays.asList(vo.getModuleVO())).get(0));
			submoduleDAO.save(submoduleTO);
		}
	}*/
	
/*	private List<SubModuleVO> convertToSubModuleVOList(List<SubModuleDbObject> dbObjList) {
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
	*/

	public List<SubModuleVO> convertToSubModuleVOList(List<SubModuleTO> toList) {
		List<SubModuleVO> voList = new ArrayList<SubModuleVO>();
		if(toList != null && !toList.isEmpty()){
			for(SubModuleTO to : toList){
				SubModuleVO vo = new SubModuleVO();
				vo.setIcon(to.getIcon());
				vo.setName(to.getName());
				vo.setSubmoduleId(to.getSubmoduleId());
				vo.setUrl(to.getUrl());
				vo.setParentId(to.getModuleTO().getModuleId());
				vo.setParentModuleName(to.getModuleTO().getModuleName());
//				vo.setModuleVO(moduleManagementService.convertToModuleVOList(Arrays.asList(to.getModuleTO())).get(0));
				voList.add(vo);
			}
		}
		return voList;
	}
	 
	public List<SubModuleTO> convertToSubModuleTOList(List<SubModuleVO> voList, ModuleTO moduleTO) {
		List<SubModuleTO> toList = new ArrayList<SubModuleTO>();
		if(voList != null && voList.size() > 0){
			Map<Long, SubModuleTO> submoduleTOMap = GeneralUtils.convertListToLongMap(moduleTO.getSubmoduleTOList(), "submoduleId");
			for(SubModuleVO vo : voList){
				SubModuleTO to = new SubModuleTO();
				SubModuleTO dbTO = submoduleTOMap.get(vo.getSubmoduleId());
				if(dbTO != null){ //update
					to = dbTO;
				}
				to.setIcon(vo.getIcon());
				to.setName(vo.getName());
				to.setModuleTO(moduleTO);
				to.setSubmoduleId(vo.getSubmoduleId());
				to.setUrl(vo.getUrl());
				toList.add(to);
			}
		}
		return toList;
	}
	
}
