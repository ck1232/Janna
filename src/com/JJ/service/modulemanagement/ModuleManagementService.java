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
	public ModuleManagementService(ModuleMapper roleMapper) {
		this.moduleMapper = roleMapper;
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
		moduleMapper.deleteByPrimaryKey(id);
	}
	
	public void updateModule(Module module) {
		moduleMapper.updateByPrimaryKeySelective(module);
	}
	 
	
	
}
