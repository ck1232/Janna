package com.JJ.service.modulemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.ModuleTO;
import com.JJ.TO.RoleTO;
import com.JJ.controller.common.vo.ModuleVO;
import com.JJ.controller.common.vo.SubModuleVO;
import com.JJ.dao.ModuleDbObjectMapper;
import com.JJ.dao.jpa.ModuleDAO;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ModuleDbObject;
import com.JJ.model.ModuleDbObjectExample;
import com.JJ.service.submodulemanagement.SubModuleManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ModuleManagementService {
	
	private ModuleDbObjectMapper moduleDbObjectMapper;
	private ModuleDAO moduleDAO;
	private SubModuleManagementService subModuleManagementService;
	
	@Autowired
	public ModuleManagementService(ModuleDbObjectMapper moduleDbObjectMapper,
			ModuleDAO moduleDAO,
			SubModuleManagementService subModuleManagementService) {
		this.moduleDbObjectMapper = moduleDbObjectMapper;
		this.moduleDAO = moduleDAO;
		this.subModuleManagementService = subModuleManagementService;
	}
	
	public ModuleVO findById(Long id) {
		/*ModuleDbObject dbObj = moduleDbObjectMapper.selectByPrimaryKey(id);
		List<ModuleVO> moduleVOList = convertToModuleVOList(Arrays.asList(dbObj));
		if(moduleVOList != null && moduleVOList.size() > 0){
			return moduleVOList.get(0);
		}
		return new ModuleVO();*/
		ModuleTO moduleTO = moduleDAO.findByModuleId(id);
		List<ModuleVO> moduleVOList = convertToModuleVOList(Arrays.asList(moduleTO));
		if(moduleVOList != null && !moduleVOList.isEmpty()){
			return moduleVOList.get(0);
		}
		return new ModuleVO();
	}
	
	public List<ModuleVO> getAllModules() {
		/*ModuleDbObjectExample moduleExample = new ModuleDbObjectExample();
		moduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ModuleDbObject> moduleDbObjectList = moduleDbObjectMapper.selectByExample(moduleExample);
		return convertToModuleVOList(moduleDbObjectList);*/
		List<ModuleTO> moduleTOList = moduleDAO.findByDeleteInd(GeneralUtils.NOT_DELETED);
		return convertToModuleVOList(moduleTOList);
	}
	
	public void saveModule(ModuleVO moduleVO) {
		/*if(module != null){
			List<ModuleDbObject> dbObj = convertToModuleDbObjectList(Arrays.asList(module)); 
			moduleDbObjectMapper.insert(dbObj.get(0));
		}*/
		List<ModuleTO> moduleTOList = convertToModuleTOList(Arrays.asList(moduleVO));
		moduleDAO.save(moduleTOList);
	}
	
	public void deleteModule(Long id) {
		deleteModule(Arrays.asList(id));
		List<SubModuleVO> submoduleVoList = subModuleManagementService.getAllSubmodulesByModule(id.intValue());
		for(SubModuleVO vo : submoduleVoList) {
			subModuleManagementService.deleteSubmodule(vo.getSubmoduleId());
		}
	}
	
	public void deleteModule(List<Long> idList) {
		/*ModuleDbObjectExample moduleDbObjectExample = new ModuleDbObjectExample();
		moduleDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andModuleIdIn(idList);
		ModuleDbObject dbObj = new ModuleDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		moduleDbObjectMapper.updateByExampleSelective(dbObj, moduleDbObjectExample);*/
		List<ModuleTO> moduleTOList = moduleDAO.findByModuleIdIn(idList);
		if(moduleTOList != null && !moduleTOList.isEmpty()){
			for(ModuleTO moduleTO : moduleTOList){
				moduleTO.setDeleteInd(GeneralUtils.DELETED);
			}
			moduleDAO.save(moduleTOList);
		}
	}
	
	public void updateModule(ModuleVO vo) {
		/*if(moduleVO != null && moduleVO.getModuleId() != null){
			ModuleDbObject dbObj = convertToModuleDbObjectList(Arrays.asList(moduleVO)).get(0);
			moduleDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}*/
		if(vo != null && vo.getModuleId() != null){
			ModuleTO to = moduleDAO.findByModuleId(vo.getModuleId());
			to.setModuleName(vo.getModuleName());
			to.setIcon(vo.getIcon());
			moduleDAO.save(to);
		}
	}
	 
	/*private List<ModuleVO> convertToModuleVOList(List<ModuleDbObject> dbObjList) {
		List<ModuleVO> voList = new ArrayList<ModuleVO>();
		if(dbObjList != null && !dbObjList.isEmpty()){
			for(ModuleDbObject dbObj : dbObjList){
				ModuleVO vo = new ModuleVO();
				vo.setIcon(dbObj.getIcon());
				vo.setModuleId(dbObj.getModuleId());
				vo.setModuleName(dbObj.getModuleName());
				voList.add(vo);
			}
		}
		return voList;
	}*/
	
	private List<ModuleVO> convertToModuleVOList(List<ModuleTO> toList) {
		List<ModuleVO> voList = new ArrayList<ModuleVO>();
		if(toList != null && !toList.isEmpty()){
			for(ModuleTO to : toList){
				ModuleVO vo = new ModuleVO();
				vo.setIcon(to.getIcon());
				vo.setModuleId(to.getModuleId());
				vo.setModuleName(to.getModuleName());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	/*private List<ModuleDbObject> convertToModuleDbObjectList(List<ModuleVO> voList) {
		List<ModuleDbObject> dbObjList = new ArrayList<ModuleDbObject>();
		if(voList != null && voList.size() > 0){
			for(ModuleVO vo : voList){
				ModuleDbObject dbObj = new ModuleDbObject();
				dbObj.setIcon(vo.getIcon());
				dbObj.setModuleId(vo.getModuleId());
				dbObj.setModuleName(vo.getModuleName());
				dbObjList.add(dbObj);
			}
		}
		return dbObjList;
	}*/
	
	private List<ModuleTO> convertToModuleTOList(List<ModuleVO> voList) {
		List<ModuleTO> toList = new ArrayList<ModuleTO>();
		if(voList != null && !voList.isEmpty()){
			for(ModuleVO vo : voList){
				ModuleTO to = new ModuleTO();
				to.setIcon(vo.getIcon());
				to.setModuleId(vo.getModuleId());
				to.setModuleName(vo.getModuleName());
				toList.add(to);
			}
		}
		return toList;
	}
}
