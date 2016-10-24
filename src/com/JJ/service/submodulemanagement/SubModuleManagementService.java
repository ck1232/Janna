package com.JJ.service.submodulemanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.SubmoduleMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Submodule;
import com.JJ.model.SubmoduleExample;

@Service
@Transactional
public class SubModuleManagementService {
	
	private SubmoduleMapper submoduleMapper;
	
	@Autowired
	public SubModuleManagementService(SubmoduleMapper roleMapper) {
		this.submoduleMapper = roleMapper;
	}
	
	public Submodule findById(Integer id) {
		return submoduleMapper.selectByPrimaryKey(id);
	}

	public List<Submodule> getAllSubmodules() {
		SubmoduleExample submoduleExample = new SubmoduleExample();
		submoduleExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Submodule> submoduleList = submoduleMapper.selectByExample(submoduleExample);
		return submoduleList;
	}
	public List<Submodule> getSubmodulesById(List<Integer> subModuleList) {
		if(subModuleList == null || subModuleList.size() == 0){
			return new ArrayList<Submodule>();
		}
		SubmoduleExample submoduleExample = new SubmoduleExample();
		submoduleExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andIdIn(subModuleList);
		List<Submodule> submoduleList = submoduleMapper.selectByExample(submoduleExample);
		return submoduleList;
	}
	
	public List<Submodule> getAllSubmodulesByModule(Integer moduleid) {
		SubmoduleExample submoduleExample = new SubmoduleExample();
		submoduleExample.createCriteria().andParentidEqualTo(moduleid)
										.andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Submodule> submoduleList = submoduleMapper.selectByExample(submoduleExample);
		return submoduleList;
	}
	
	public List<Submodule> getAllSubmodulesOrderByClause(String orderByClause) {
		SubmoduleExample submoduleExample = new SubmoduleExample();
		submoduleExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		submoduleExample.setOrderByClause(orderByClause);
		List<Submodule> submoduleList = submoduleMapper.selectByExample(submoduleExample);
		return submoduleList;
	}
	
	public void saveSubmodule(Submodule submodule) {
		submoduleMapper.insert(submodule);
	}
	
	public void deleteSubmodule(Integer id) {
		Submodule submodule = findById(id);
		if(submodule.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			submodule.setDeleteind(GeneralUtils.DELETED);
			submoduleMapper.updateByPrimaryKey(submodule);
		}
	}
	
	public void updateSubmodule(Submodule submodule) {
		if(submodule.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			submoduleMapper.updateByPrimaryKeySelective(submodule);
	}
	 
	
	
}
