package com.JJ.service.submodulemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.SubModuleVO;
import com.JJ.dao.SubModuleDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.SubModuleDbObject;
import com.JJ.model.SubModuleDbObjectExample;

@Service
@Transactional
public class SubModuleManagementService {
	
	private SubModuleDbObjectMapper subModuleDbObjectMapper;
	
	@Autowired
	public SubModuleManagementService(SubModuleDbObjectMapper subModuleDbObjectMapper) {
		this.subModuleDbObjectMapper = subModuleDbObjectMapper;
	}
	
	public SubModuleVO findById(Integer id) {
		SubModuleDbObject dbObj = subModuleDbObjectMapper.selectByPrimaryKey(id);
		List<SubModuleVO> voList = convertToSubModuleVOList(Arrays.asList(dbObj));
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}
		return new SubModuleVO();
	}

	private List<SubModuleVO> convertToSubModuleVOList(List<SubModuleDbObject> dbObjList) {
		List<SubModuleVO> voList = new ArrayList<SubModuleVO>();
		if(dbObjList != null && !dbObjList.isEmpty()){
			for(SubModuleDbObject dbObj : dbObjList){
				SubModuleVO vo = new SubModuleVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
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

	public List<SubModuleVO> getAllSubmodules() {
		SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
		submoduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
		return convertToSubModuleVOList(submoduleList);
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
	
	public List<SubModuleVO> getAllSubmodulesByModule(Integer moduleid) {
		SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
		submoduleExample.createCriteria().andParentIdEqualTo(moduleid).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
		return convertToSubModuleVOList(submoduleList);
	}
	
	public List<SubModuleVO> getAllSubmodulesOrderByClause(String orderByClause) {
		SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
		submoduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		submoduleExample.setOrderByClause(orderByClause);
		List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
		return convertToSubModuleVOList(submoduleList);
	}
	
	public void saveSubmodule(SubModuleVO submodule) {
		List<SubModuleDbObject> dbObjList = convertToSubModuleDbObjectList(Arrays.asList(submodule));
		if(dbObjList != null && dbObjList.size() > 0){
			subModuleDbObjectMapper.insert(dbObjList.get(0));
		}
		
	}
	
	public void deleteSubmodule(Integer id) {
		SubModuleVO submodule = findById(id);
		if(submodule != null && submodule.getDeleteInd() != null){
			if(submodule.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
				SubModuleDbObject dbObj = new SubModuleDbObject();
				dbObj.setSubmoduleId(id);
				dbObj.setDeleteInd(GeneralUtils.DELETED);
				subModuleDbObjectMapper.updateByPrimaryKeySelective(dbObj);
			}
		}
		
	}
	
	public void updateSubmodule(SubModuleVO submodule) {
		if(submodule != null && submodule.getDeleteInd() != null){
			if(submodule.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
				List<SubModuleDbObject> dbObjList = convertToSubModuleDbObjectList(Arrays.asList(submodule));
				subModuleDbObjectMapper.updateByPrimaryKeySelective(dbObjList.get(0));
			}
		}
	}
	 
	private List<SubModuleDbObject> convertToSubModuleDbObjectList(List<SubModuleVO> voList) {
		List<SubModuleDbObject> dbObjList = new ArrayList<SubModuleDbObject>();
		if(voList != null && voList.size() > 0){
			for(SubModuleVO obj : voList){
				SubModuleDbObject dbObj = new SubModuleDbObject();
				dbObj.setDeleteInd(obj.getDeleteInd());
				dbObj.setIcon(obj.getIcon());
				dbObj.setName(obj.getName());
				dbObj.setParentId(obj.getParentId());
				dbObj.setSubmoduleId(obj.getSubmoduleId());
				dbObj.setUrl(obj.getUrl());
				dbObjList.add(dbObj);
			}
		}
		return dbObjList;
	}
	
}
