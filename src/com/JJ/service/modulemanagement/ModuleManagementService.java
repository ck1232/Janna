package com.JJ.service.modulemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.ModuleVO;
import com.JJ.controller.common.vo.SubModuleVO;
import com.JJ.dao.ModuleDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ModuleDbObject;
import com.JJ.model.ModuleDbObjectExample;
import com.JJ.service.submodulemanagement.SubModuleManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ModuleManagementService {
	
	private ModuleDbObjectMapper moduleDbObjectMapper;
	private SubModuleManagementService subModuleManagementService;
	
	@Autowired
	public ModuleManagementService(ModuleDbObjectMapper moduleDbObjectMapper,
			SubModuleManagementService subModuleManagementService) {
		this.moduleDbObjectMapper = moduleDbObjectMapper;
		this.subModuleManagementService = subModuleManagementService;
	}
	
	public ModuleVO findById(Integer id) {
		ModuleDbObject dbObj = moduleDbObjectMapper.selectByPrimaryKey(id);
		List<ModuleVO> moduleVOList = convertToModuleVOList(Arrays.asList(dbObj));
		if(moduleVOList != null && moduleVOList.size() > 0){
			return moduleVOList.get(0);
		}
		return new ModuleVO();
	}
	
	public List<ModuleVO> getAllModules() {
		ModuleDbObjectExample moduleExample = new ModuleDbObjectExample();
		moduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ModuleDbObject> moduleDbObjectList = moduleDbObjectMapper.selectByExample(moduleExample);
		return convertToModuleVOList(moduleDbObjectList);
	}
	
	public void saveModule(ModuleVO module) {
		if(module != null){
			List<ModuleDbObject> dbObj = convertToModuleDbObjectList(Arrays.asList(module)); 
			moduleDbObjectMapper.insert(dbObj.get(0));
		}
		
	}
	
	public void deleteModule(Integer id) {
		deleteModule(Arrays.asList(id));
		List<SubModuleVO> submoduleVoList = subModuleManagementService.getAllSubmodulesByModule(id);
		for(SubModuleVO vo : submoduleVoList) {
			subModuleManagementService.deleteSubmodule(vo.getSubmoduleId());
		}
	}
	
	public void deleteModule(List<Integer> idList) {
		ModuleDbObjectExample moduleDbObjectExample = new ModuleDbObjectExample();
		moduleDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andModuleIdIn(idList);
		ModuleDbObject dbObj = new ModuleDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		moduleDbObjectMapper.updateByExampleSelective(dbObj, moduleDbObjectExample);
	}
	
	public void updateModule(ModuleVO moduleVO) {
		if(moduleVO != null && moduleVO.getModuleId() != null){
			ModuleDbObject dbObj = convertToModuleDbObjectList(Arrays.asList(moduleVO)).get(0);
			moduleDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	 
	private List<ModuleVO> convertToModuleVOList(List<ModuleDbObject> dbObjList) {
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
	}
	
	private List<ModuleDbObject> convertToModuleDbObjectList(List<ModuleVO> voList) {
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
	}
	
}
