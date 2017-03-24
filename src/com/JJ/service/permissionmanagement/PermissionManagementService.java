package com.JJ.service.permissionmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.SubModulePermissionTypeVO;
import com.JJ.controller.common.vo.SubModulePermissionVO;
import com.JJ.dao.PermissionCustomDbObjectMapper;
import com.JJ.dao.SubModulePermissionDbObjectMapper;
import com.JJ.dao.SubModulePermissionTypeDbObjectMapper;
import com.JJ.model.RolesToPermissionCustomDbObject;
import com.JJ.model.SubModulePermissionDbObject;
import com.JJ.model.SubModulePermissionDbObjectExample;
import com.JJ.model.SubModulePermissionTypeDbObject;
import com.JJ.model.SubModulePermissionTypeDbObjectExample;

@Service
@Transactional
public class PermissionManagementService {
	
	private SubModulePermissionDbObjectMapper subModulePermissionDbObjectMapper;
	private SubModulePermissionTypeDbObjectMapper subModulePermissionTypeDbObjectMapper;
	private PermissionCustomDbObjectMapper rolesToPermissionCustomDbObjectMapper;
	@Autowired
	public PermissionManagementService(SubModulePermissionDbObjectMapper subModulePermissionDbObjectMapper,
			SubModulePermissionTypeDbObjectMapper subModulePermissionTypeDbObjectMapper,
			PermissionCustomDbObjectMapper rolesToPermissionCustomDbObjectMapper) {
		this.subModulePermissionDbObjectMapper = subModulePermissionDbObjectMapper;
		this.subModulePermissionTypeDbObjectMapper = subModulePermissionTypeDbObjectMapper;
		this.rolesToPermissionCustomDbObjectMapper = rolesToPermissionCustomDbObjectMapper;
	}
	
	//Submodulepermission functions START

	public List<SubModulePermissionVO> getAllSubmodulepermission() {
		SubModulePermissionDbObjectExample submodulepermissionExample = new SubModulePermissionDbObjectExample();
		submodulepermissionExample.createCriteria();
		List<SubModulePermissionDbObject> submodulepermissionList = subModulePermissionDbObjectMapper.selectByExample(submodulepermissionExample);
		return convertToSubModulePermissionVOList(submodulepermissionList);
	}
	
	private List<SubModulePermissionVO> convertToSubModulePermissionVOList(List<SubModulePermissionDbObject> dbObjList) {
		List<SubModulePermissionVO> voList = new ArrayList<SubModulePermissionVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(SubModulePermissionDbObject dbObj : dbObjList){
				SubModulePermissionVO vo = new SubModulePermissionVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setPermissionId(dbObj.getPermissionId());
				vo.setPermissionTypeId(dbObj.getPermissionTypeId());
				vo.setRoleId(dbObj.getRoleId());
				vo.setSubmoduleId(dbObj.getSubmoduleId());
				voList.add(vo);
			}
		}
		return voList;
	}

	public List<RolesToPermissionCustomDbObject> getRolesToPermission(String submoduleid) {
		return rolesToPermissionCustomDbObjectMapper.getRolesToPermission(submoduleid);
	}
	
	
	public void saveSubmodulepermission(SubModulePermissionVO submodulepermission) {
		if(submodulepermission != null){
			List<SubModulePermissionDbObject> dbObjList = convertToSubModulePermissionDbObjectList(Arrays.asList(submodulepermission));
			subModulePermissionDbObjectMapper.insert(dbObjList.get(0));
		}
		
	}
	
	private List<SubModulePermissionDbObject> convertToSubModulePermissionDbObjectList(
			List<SubModulePermissionVO> voList) {
		List<SubModulePermissionDbObject> objList = new ArrayList<SubModulePermissionDbObject>();
		if(voList != null && voList.size() > 0){
			for(SubModulePermissionVO vo : voList){
				SubModulePermissionDbObject obj = new SubModulePermissionDbObject();
				obj.setDeleteInd(vo.getDeleteInd());
				obj.setPermissionId(vo.getPermissionId());
				obj.setPermissionTypeId(vo.getPermissionTypeId());
				obj.setRoleId(vo.getRoleId());
				obj.setSubmoduleId(vo.getSubmoduleId());
				obj.setVersion(vo.getVersion());
				objList.add(obj);
			}
		}
		return null;
	}

	public List<SubModulePermissionVO> getSubmoduleByRole(List<Integer> roleIdList){
		if(roleIdList == null || roleIdList.size() == 0){
			return new ArrayList<SubModulePermissionVO>();
		}
		SubModulePermissionDbObjectExample example = new SubModulePermissionDbObjectExample();
		example.createCriteria().andRoleIdIn(roleIdList);
		return convertToSubModulePermissionVOList(subModulePermissionDbObjectMapper.selectByExample(example));
	}

	public List<SubModulePermissionVO> getSubmodulePermissionByRoleIdList(Map<String, List<String>> roleList){
		return convertToSubModulePermissionVOList(rolesToPermissionCustomDbObjectMapper.getSubmodulePermissionByRoleIdList(roleList));
	}
	
	
	public void deleteSubmodulepermission(String roleid, String submoduleid) {
		SubModulePermissionDbObjectExample submodulepermissionExample = new SubModulePermissionDbObjectExample();
		submodulepermissionExample.createCriteria().andSubmoduleIdEqualTo(new Integer(submoduleid)).andRoleIdEqualTo(new Integer(roleid));
		subModulePermissionDbObjectMapper.deleteByExample(submodulepermissionExample);
	}
	//Submodulepermission functions END
	
	
	
	//Submodulepermissiontype functions START
	public List<SubModulePermissionTypeVO> getSubmodulepermissiontype(Integer submoduleid) {
		SubModulePermissionTypeDbObjectExample submodulepermissiontypeExample = new SubModulePermissionTypeDbObjectExample();
		submodulepermissiontypeExample.createCriteria().andSubmoduleIdEqualTo(submoduleid);
		submodulepermissiontypeExample.setOrderByClause("seqno");
		List<SubModulePermissionTypeDbObject> submodulepermissiontypeList = subModulePermissionTypeDbObjectMapper.selectByExample(submodulepermissiontypeExample);
		return convertToSubModulePermissionTypeVOList(submodulepermissiontypeList);
	}
	
	private List<SubModulePermissionTypeVO> convertToSubModulePermissionTypeVOList(
			List<SubModulePermissionTypeDbObject> dbObjList) {
		List<SubModulePermissionTypeVO> voList = new ArrayList<SubModulePermissionTypeVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(SubModulePermissionTypeDbObject obj : dbObjList){
				SubModulePermissionTypeVO vo = new SubModulePermissionTypeVO();
				vo.setDeleteInd(obj.getDeleteInd());
				vo.setPermissionType(obj.getPermissionType());
				vo.setSeqNum(obj.getSeqNum());
				vo.setSubmoduleId(obj.getSubmoduleId());
				vo.setTypeId(obj.getTypeId());
				vo.setUrl(obj.getUrl());
				vo.setVersion(obj.getVersion());
				voList.add(vo);
			}
		}
		return voList;
	}

	public SubModulePermissionTypeVO getSubmodulepermissiontypeByUrl(String url){
		SubModulePermissionTypeDbObjectExample example = new SubModulePermissionTypeDbObjectExample();
		example.createCriteria().andUrlEqualTo(url);
		List<SubModulePermissionTypeDbObject> resultList = subModulePermissionTypeDbObjectMapper.selectByExample(example);
		List<SubModulePermissionTypeVO> voList = convertToSubModulePermissionTypeVOList(resultList);
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}else{
			return new SubModulePermissionTypeVO();
		}
	}
	
	public List<SubModulePermissionTypeVO> getSubmodulepermissiontypeByUrl(){
		SubModulePermissionTypeDbObjectExample example = new SubModulePermissionTypeDbObjectExample();
		example.createCriteria();
		List<SubModulePermissionTypeDbObject> resultList = subModulePermissionTypeDbObjectMapper.selectByExample(example);
		List<SubModulePermissionTypeVO> voList = convertToSubModulePermissionTypeVOList(resultList);
		return voList;
	}
	
	public SubModulePermissionTypeVO findById(Integer id) {
		SubModulePermissionTypeDbObject dbObj = subModulePermissionTypeDbObjectMapper.selectByPrimaryKey(id);
		List<SubModulePermissionTypeVO> voList= convertToSubModulePermissionTypeVOList(Arrays.asList(dbObj));
		if(voList != null && voList.size() > 0){
			return voList.get(0);
		}
		return new SubModulePermissionTypeVO();
	}
	
	public void saveSubmodulepermissiontype(SubModulePermissionTypeVO submodulepermissiontype) {
		if(submodulepermissiontype != null){
			SubModulePermissionTypeDbObject dbObj = convertToSubModulePermissionTypeDbObjectList(Arrays.asList(submodulepermissiontype)).get(0);
			subModulePermissionTypeDbObjectMapper.insert(dbObj);
		}
		
	}
	
	private List<SubModulePermissionTypeDbObject> convertToSubModulePermissionTypeDbObjectList(
			List<SubModulePermissionTypeVO> asList) {
		return null;
		
	}

	public void deleteSubmodulepermissiontype(Integer id){
		subModulePermissionTypeDbObjectMapper.deleteByPrimaryKey(id);
	}
	
	public void updateSubmodulepermissiontype(SubModulePermissionTypeVO submodulepermissiontype) {
		SubModulePermissionTypeDbObject obj = convertToSubModulePermissionTypeDbObjectList(Arrays.asList(submodulepermissiontype)).get(0);
		subModulePermissionTypeDbObjectMapper.updateByPrimaryKeySelective(obj);
	}

	//Submodulepermissiontype functions END
	
}
