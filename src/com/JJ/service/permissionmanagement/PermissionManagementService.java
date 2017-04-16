package com.JJ.service.permissionmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.SubModulePermissionTypeVO;
import com.JJ.controller.common.vo.SubModulePermissionVO;
import com.JJ.dao.SubModuleDbObjectMapper;
import com.JJ.dao.SubModulePermissionDbObjectMapper;
import com.JJ.dao.SubModulePermissionTypeDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.RoleDbObject;
import com.JJ.model.RolesToPermissionCustomDbObject;
import com.JJ.model.SubModuleDbObject;
import com.JJ.model.SubModuleDbObjectExample;
import com.JJ.model.SubModulePermissionDbObject;
import com.JJ.model.SubModulePermissionDbObjectExample;
import com.JJ.model.SubModulePermissionTypeDbObject;
import com.JJ.model.SubModulePermissionTypeDbObjectExample;
import com.JJ.service.roleassignment.RoleAssignmentService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class PermissionManagementService {
	
	private SubModulePermissionDbObjectMapper subModulePermissionDbObjectMapper;
	private SubModulePermissionTypeDbObjectMapper subModulePermissionTypeDbObjectMapper;
	private SubModuleDbObjectMapper subModuleDbObjectMapper;
	private RoleAssignmentService roleAssignmentService;
	@Autowired
	public PermissionManagementService(SubModulePermissionDbObjectMapper subModulePermissionDbObjectMapper,
			SubModulePermissionTypeDbObjectMapper subModulePermissionTypeDbObjectMapper,
			SubModuleDbObjectMapper subModuleDbObjectMapper,
			RoleAssignmentService roleAssignmentService) {
		this.subModulePermissionDbObjectMapper = subModulePermissionDbObjectMapper;
		this.subModulePermissionTypeDbObjectMapper = subModulePermissionTypeDbObjectMapper;
		this.subModuleDbObjectMapper = subModuleDbObjectMapper;
		this.roleAssignmentService = roleAssignmentService;
	}
	
	//Submodulepermission functions START

	public List<SubModulePermissionVO> getAllSubmodulepermission() {
		SubModulePermissionDbObjectExample submodulepermissionExample = new SubModulePermissionDbObjectExample();
		submodulepermissionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<SubModulePermissionDbObject> submodulepermissionList = subModulePermissionDbObjectMapper.selectByExample(submodulepermissionExample);
		return convertToSubModulePermissionVOList(submodulepermissionList);
	}
	
	public List<SubModulePermissionVO> getAllSubmodulepermissionBySubModuleId(List<Integer> subModuleIdList) {
		if(subModuleIdList != null && subModuleIdList.size() > 0){
			SubModulePermissionDbObjectExample submodulepermissionExample = new SubModulePermissionDbObjectExample();
			submodulepermissionExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSubmoduleIdIn(subModuleIdList);
			List<SubModulePermissionDbObject> submodulepermissionList = subModulePermissionDbObjectMapper.selectByExample(submodulepermissionExample);
			return convertToSubModulePermissionVOList(submodulepermissionList);
		}else{
			return new ArrayList<SubModulePermissionVO>();
		}
	}
	
	public List<SubModuleDbObject> getAllSubmodules() {
		SubModuleDbObjectExample submoduleExample = new SubModuleDbObjectExample();
		submoduleExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<SubModuleDbObject> submoduleList = subModuleDbObjectMapper.selectByExample(submoduleExample);
		return submoduleList;
	}
	
	public List<RolesToPermissionCustomDbObject> getRolesToPermission(Integer submoduleId) {
		List<RolesToPermissionCustomDbObject> dbObjList = new ArrayList<RolesToPermissionCustomDbObject>();
		List<RoleDbObject> roleList = roleAssignmentService.getAllRolesDbObject();
		List<SubModulePermissionVO> subModulePermissionList = getAllSubmodulepermissionBySubModuleId(Arrays.asList(submoduleId));
		List<SubModulePermissionTypeVO> typeVOList = getSubmodulepermissiontype();
		Map<Integer, SubModulePermissionVO> subModulePermissionMap = new HashMap<Integer, SubModulePermissionVO>();
		Map<Integer, SubModulePermissionTypeVO> typeVOMap = new HashMap<Integer, SubModulePermissionTypeVO>();
		Set<Integer> roleIdSet = new HashSet<Integer>();
		if(subModulePermissionList != null && subModulePermissionList.size() > 0){
			for(SubModulePermissionVO vo : subModulePermissionList){
				subModulePermissionMap.put(vo.getRoleId(), vo);
				roleIdSet.add(vo.getRoleId());
			}
			
		}
		
		if(typeVOList != null && typeVOList.size() > 0){
			for(SubModulePermissionTypeVO vo : typeVOList){
				typeVOMap.put(vo.getTypeId(), vo);
			}
		}
		
		if(roleList != null && roleList.size() > 0){
			
			//query 1
			for(RoleDbObject roleObj : roleList){
				RolesToPermissionCustomDbObject dbObj = new RolesToPermissionCustomDbObject();
				SubModulePermissionVO subModulePermissionVO = subModulePermissionMap.get(roleObj.getRoleId());
				dbObj.setRoleId(roleObj.getRoleId());
				dbObj.setRoleName(roleObj.getName());
				if(subModulePermissionVO != null){
					dbObj.setPermissionTypeId(subModulePermissionVO.getPermissionTypeId());
					SubModulePermissionTypeVO typeVO = typeVOMap.get(dbObj.getPermissionTypeId());
					if(typeVO != null){
						dbObj.setPermission(typeVO.getPermissionType());
					}
				}
				dbObjList.add(dbObj);
			}
			
			//query 2
			for(RoleDbObject roleObj : roleList){
				if(!roleIdSet.contains(roleObj.getRoleId())){
					RolesToPermissionCustomDbObject dbObj = new RolesToPermissionCustomDbObject();
					dbObj.setRoleId(roleObj.getRoleId());
					dbObj.setRoleName(roleObj.getName());
					dbObj.setPermission(GeneralUtils.NONE);
					dbObjList.add(dbObj);
				}
			}
		}
		
		
		
		return dbObjList;
		/*return rolesToPermissionCustomDbObjectMapper.getRolesToPermission(submoduleid);*/
	}
	
	
	public void saveSubmodulepermission(SubModulePermissionVO submodulepermission) {
		if(submodulepermission != null){
			List<SubModulePermissionDbObject> dbObjList = convertToSubModulePermissionDbObjectList(Arrays.asList(submodulepermission));
			subModulePermissionDbObjectMapper.insert(dbObjList.get(0));
		}
		
	}
	
	public List<SubModulePermissionVO> getSubmoduleByRole(List<Integer> roleIdList){
		if(roleIdList == null || roleIdList.size() == 0){
			return new ArrayList<SubModulePermissionVO>();
		}
		SubModulePermissionDbObjectExample example = new SubModulePermissionDbObjectExample();
		example.createCriteria().andRoleIdIn(roleIdList).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToSubModulePermissionVOList(subModulePermissionDbObjectMapper.selectByExample(example));
	}

	public List<SubModulePermissionVO> getSubmodulePermissionByRoleIdList(List<Integer> roleList){
		Map<Integer, SubModulePermissionVO> resultVOMap = new HashMap<Integer, SubModulePermissionVO>();
		List<SubModulePermissionVO> resultVOList = new ArrayList<SubModulePermissionVO>();
		List<SubModulePermissionVO> subModulePermissionVO = getSubmoduleByRole(roleList);
		List<SubModuleDbObject> subModuleList = getAllSubmodules();
		List<SubModulePermissionTypeVO> typeVO = getSubmodulepermissiontype();
		
		Map<Integer, SubModuleDbObject> subModuleMap = new HashMap<Integer, SubModuleDbObject>();
		Map<Integer, SubModulePermissionTypeVO> typeMap  = new HashMap<Integer, SubModulePermissionTypeVO>();
		if(subModuleList != null && subModuleList.size() > 0){
			for(SubModuleDbObject obj : subModuleList){
				subModuleMap.put(obj.getSubmoduleId(), obj);
			}
		}
		
		if(typeVO != null && typeVO.size() > 0){
			for(SubModulePermissionTypeVO vo : typeVO){
				typeMap.put(vo.getTypeId(), vo);
			}
		}
		
		if(subModulePermissionVO != null && subModulePermissionVO.size() > 0){
			for(SubModulePermissionVO permissionVO :subModulePermissionVO){
				SubModulePermissionVO vo = resultVOMap.get(permissionVO.getSubmoduleId());
				if(vo == null){
					SubModulePermissionVO resultVO = new SubModulePermissionVO();
					SubModuleDbObject subModuleDbObject = subModuleMap.get(permissionVO.getSubmoduleId());
					if(subModuleDbObject != null){
						resultVO.setSubmodulename(subModuleDbObject.getName());
					}
					
					SubModulePermissionTypeVO subModulePermissionTypeVO = typeMap.get(permissionVO.getPermissionTypeId());
					if(subModulePermissionTypeVO != null){
						resultVO.setPermissiontype(subModulePermissionTypeVO.getPermissionType());
					}
					resultVO.setPermissionTypeId(permissionVO.getPermissionTypeId());
					resultVOMap.put(permissionVO.getSubmoduleId(), resultVO);
				}
			}
		}
		resultVOList.addAll(resultVOMap.values());
		return resultVOList;
//		return rolesToPermissionCustomDbObjectMapper.getSubmodulePermissionByRoleIdList(roleList);
	}
	
	
	public void deleteSubmodulepermission(Integer roleid, Integer submoduleid) {
		SubModulePermissionDbObjectExample subModulePermissionDbObjectExample = new SubModulePermissionDbObjectExample();
		subModulePermissionDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
										.andRoleIdEqualTo(roleid).andSubmoduleIdEqualTo(submoduleid);
		SubModulePermissionDbObject dbObj = new SubModulePermissionDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		subModulePermissionDbObjectMapper.updateByExampleSelective(dbObj, subModulePermissionDbObjectExample);
	}
	
	public void deleteSubmodulepermissionBySubmoduleId(Integer submoduleid) {
		SubModulePermissionDbObjectExample subModulePermissionDbObjectExample = new SubModulePermissionDbObjectExample();
		subModulePermissionDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
										.andSubmoduleIdEqualTo(submoduleid);
		SubModulePermissionDbObject dbObj = new SubModulePermissionDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		subModulePermissionDbObjectMapper.updateByExampleSelective(dbObj, subModulePermissionDbObjectExample);
	}
	
	public void deleteSubmodulepermissionByRoleId(Integer roleid) {
		SubModulePermissionDbObjectExample subModulePermissionDbObjectExample = new SubModulePermissionDbObjectExample();
		subModulePermissionDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
										.andRoleIdEqualTo(roleid);
		SubModulePermissionDbObject dbObj = new SubModulePermissionDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		subModulePermissionDbObjectMapper.updateByExampleSelective(dbObj, subModulePermissionDbObjectExample);
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
	
	private List<SubModulePermissionDbObject> convertToSubModulePermissionDbObjectList(List<SubModulePermissionVO> voList) {
		List<SubModulePermissionDbObject> subModulePermissionDbObjectList = new ArrayList<SubModulePermissionDbObject>();
		if(voList != null && voList.size() > 0){
			for(SubModulePermissionVO vo : voList){
				SubModulePermissionDbObject dbObj = new SubModulePermissionDbObject();
				dbObj.setPermissionId(vo.getPermissionId());
				dbObj.setPermissionTypeId(vo.getPermissionTypeId());
				dbObj.setRoleId(vo.getRoleId());
				dbObj.setSubmoduleId(vo.getSubmoduleId());
				subModulePermissionDbObjectList.add(dbObj);
			}
		}
		return subModulePermissionDbObjectList;
	}
	//Submodulepermission functions END
	
	
	
	//Submodulepermissiontype functions START
	public List<SubModulePermissionTypeVO> getSubmodulepermissiontype(Integer submoduleid) {
		SubModulePermissionTypeDbObjectExample submodulepermissiontypeExample = new SubModulePermissionTypeDbObjectExample();
		submodulepermissiontypeExample.createCriteria().andSubmoduleIdEqualTo(submoduleid).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		submodulepermissiontypeExample.setOrderByClause("seq_num");
		List<SubModulePermissionTypeDbObject> submodulepermissiontypeList = subModulePermissionTypeDbObjectMapper.selectByExample(submodulepermissiontypeExample);
		return convertToSubModulePermissionTypeVOList(submodulepermissiontypeList);
	}
	
	public List<SubModulePermissionTypeVO> getSubmodulepermissiontype() {
		SubModulePermissionTypeDbObjectExample submodulepermissiontypeExample = new SubModulePermissionTypeDbObjectExample();
		submodulepermissiontypeExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		submodulepermissiontypeExample.setOrderByClause("seq_num");
		List<SubModulePermissionTypeDbObject> submodulepermissiontypeList = subModulePermissionTypeDbObjectMapper.selectByExample(submodulepermissiontypeExample);
		return convertToSubModulePermissionTypeVOList(submodulepermissiontypeList);
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
	
	public void deleteSubmodulepermissiontype(Integer id){
		deleteSubmodulepermissiontype(Arrays.asList(id));
	}
	
	public void deleteSubmodulepermissiontype(List<Integer> idList) {
		SubModulePermissionTypeDbObjectExample subModulePermissionTypeDbObjectExample = new SubModulePermissionTypeDbObjectExample();
		subModulePermissionTypeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andTypeIdIn(idList);
		SubModulePermissionTypeDbObject dbObj = new SubModulePermissionTypeDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		subModulePermissionTypeDbObjectMapper.updateByExampleSelective(dbObj, subModulePermissionTypeDbObjectExample);
	}
	
	public void deleteSubmodulepermissiontypeBySubmoduleId(Integer submoduleId) {
		SubModulePermissionTypeDbObjectExample subModulePermissionTypeDbObjectExample = new SubModulePermissionTypeDbObjectExample();
		subModulePermissionTypeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSubmoduleIdEqualTo(submoduleId);
		SubModulePermissionTypeDbObject dbObj = new SubModulePermissionTypeDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		subModulePermissionTypeDbObjectMapper.updateByExampleSelective(dbObj, subModulePermissionTypeDbObjectExample);
	}
	
	public void updateSubmodulepermissiontype(SubModulePermissionTypeVO submodulepermissiontype) {
		SubModulePermissionTypeDbObject obj = convertToSubModulePermissionTypeDbObjectList(Arrays.asList(submodulepermissiontype)).get(0);
		subModulePermissionTypeDbObjectMapper.updateByPrimaryKeySelective(obj);
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
	
	private List<SubModulePermissionTypeDbObject> convertToSubModulePermissionTypeDbObjectList(List<SubModulePermissionTypeVO> subModulePermissionTypeVOList) {
		List<SubModulePermissionTypeDbObject> subModulePermissionTypeDbObjectList = new ArrayList<SubModulePermissionTypeDbObject>();
		if(subModulePermissionTypeVOList != null && !subModulePermissionTypeVOList.isEmpty()) {
			for(SubModulePermissionTypeVO vo : subModulePermissionTypeVOList) {
				SubModulePermissionTypeDbObject dbObj = new SubModulePermissionTypeDbObject();
				dbObj.setPermissionType(vo.getPermissionType());
				dbObj.setSeqNum(vo.getSeqNum());
				dbObj.setSubmoduleId(vo.getSubmoduleId());
				dbObj.setTypeId(vo.getTypeId());
				dbObj.setUrl(vo.getUrl());
				subModulePermissionTypeDbObjectList.add(dbObj);
			}
		}
		return subModulePermissionTypeDbObjectList;
		
	}

	//Submodulepermissiontype functions END
	
}
