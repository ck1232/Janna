package com.JJ.service.modulemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ModuleMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Module;
import com.JJ.model.ModuleExample;

@Service
@Transactional
public class ModuleManagementService {
	
	private ModuleMapper moduleMapper;
	
	@Autowired
	public ModuleManagementService(ModuleMapper moduleMapper) {
		this.moduleMapper = moduleMapper;
	}
	
	public Module findById(Integer id) {
		return moduleMapper.selectByPrimaryKey(id);
	}
	
	public List<Module> getAllModules() {
		ModuleExample moduleExample = new ModuleExample();
		moduleExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Module> moduleList = moduleMapper.selectByExample(moduleExample);
		return moduleList;
	}
	
	public void saveModule(Module module) {
		moduleMapper.insert(module);
	}
	
	public void deleteModule(Integer id) {
		Module module = findById(id);
		if(module.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			module.setDeleteind(GeneralUtils.DELETED);
			moduleMapper.updateByPrimaryKey(module);
		}
	}
	
	public void updateModule(Module module) {
		if(module.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			moduleMapper.updateByPrimaryKeySelective(module);
	}
	 
	
	
}
