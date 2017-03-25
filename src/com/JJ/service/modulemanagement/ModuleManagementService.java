package com.JJ.service.modulemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.ModuleVO;
import com.JJ.dao.ModuleDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ModuleDbObject;
import com.JJ.model.ModuleDbObjectExample;

@Service
@Transactional
public class ModuleManagementService {
	
	private ModuleDbObjectMapper moduleDbObjectMapper;
	
	@Autowired
	public ModuleManagementService(ModuleDbObjectMapper moduleDbObjectMapper) {
		this.moduleDbObjectMapper = moduleDbObjectMapper;
	}
	
	public ModuleVO findById(Integer id) {
		ModuleDbObject dbObj = moduleDbObjectMapper.selectByPrimaryKey(id);
		List<ModuleVO> moduleVOList = convertToModuleVOList(Arrays.asList(dbObj));
		if(moduleVOList != null && moduleVOList.size() > 0){
			return moduleVOList.get(0);
		}
		return new ModuleVO();
	}
	
	private List<ModuleVO> convertToModuleVOList(List<ModuleDbObject> dbObjList) {
		List<ModuleVO> voList = new ArrayList<ModuleVO>();
		if(dbObjList != null && !dbObjList.isEmpty()){
			for(ModuleDbObject dbObj : dbObjList){
				ModuleVO vo = new ModuleVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setIcon(dbObj.getIcon());
				vo.setModuleId(dbObj.getModuleId());
				vo.setModuleName(dbObj.getModuleName());
				voList.add(vo);
			}
		}
		return voList;
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
	
	private List<ModuleDbObject> convertToModuleDbObjectList(List<ModuleVO> voList) {
		List<ModuleDbObject> dbObjList = new ArrayList<ModuleDbObject>();
		if(voList != null && voList.size() > 0){
			for(ModuleVO vo : voList){
				ModuleDbObject dbObj = new ModuleDbObject();
				dbObj.setDeleteInd(dbObj.getDeleteInd());
				dbObj.setIcon(vo.getIcon());
				dbObj.setModuleId(vo.getModuleId());
				dbObj.setModuleName(vo.getModuleName());
				dbObjList.add(dbObj);
			}
		}
		return dbObjList;
	}

	public void deleteModule(Integer id) {
		ModuleVO module = findById(id);
		if(module != null && module.getDeleteInd() != null){
			if(module.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
				ModuleDbObject dbObj = new ModuleDbObject();
				dbObj.setDeleteInd(GeneralUtils.DELETED);
				dbObj.setModuleId(id);
				moduleDbObjectMapper.updateByPrimaryKey(dbObj);
			}
		}
		
	}
	
	public void updateModule(ModuleVO module) {
		if(module != null && module.getDeleteInd() != null){
			if(module.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
				List<ModuleDbObject> dbObjList = convertToModuleDbObjectList(Arrays.asList(module));
				moduleDbObjectMapper.updateByPrimaryKeySelective(dbObjList.get(0));
			}
		}
	}
	 
	
	
}
