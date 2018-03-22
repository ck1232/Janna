package com.JJ.service.usermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.UserTO;
import com.JJ.controller.common.vo.UserVO;
import com.JJ.dao.UserDbObjectMapper;
import com.JJ.dao.jpa.UserDAO;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.UserDbObject;
import com.JJ.service.roleassignment.RoleAssignmentService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class UserManagementService {
	
	private UserDbObjectMapper userDbObjectMapper;
	private RoleAssignmentService roleAssignmentService;
	private UserDAO userDAO;
	@Autowired
	public UserManagementService(UserDbObjectMapper userMapper,
			RoleAssignmentService roleAssignmentService,
			UserDAO userDAO) {
		this.userDbObjectMapper = userMapper;
		this.roleAssignmentService = roleAssignmentService;
		this.userDAO = userDAO;
	}
	
	public UserVO findById(Long id) {
		/*UserDbObject user = userDbObjectMapper.selectByPrimaryKey(id);*/
		UserTO user = userDAO.findByUserId(id);
		List<UserVO> userVOList = convertToUserVOList(Arrays.asList(user));
		if(userVOList != null && !userVOList.isEmpty()){
			return userVOList.get(0);
		}
		return new UserVO();
	}
	
	public UserVO findByUserName(String userName) {
		/*UserDbObjectExample example = new UserDbObjectExample();
		example.createCriteria().andUserNameEqualTo(userName).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<UserDbObject> dbObjList = userDbObjectMapper.selectByExample(example);*/
		List<UserTO> dbObjList = userDAO.findByUserNameAndDeleteInd(userName, GeneralUtils.NOT_DELETED);
		List<UserVO> voList = convertToUserVOList(dbObjList);
		if(voList != null && voList.size() > 0){
			UserVO user = voList.get(0);
			return user;
		}else{
			return null;
		}
	}
	

	public List<UserVO> getAllUsers() {
		/*UserDbObjectExample userExample = new UserDbObjectExample();
		userExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<UserDbObject> userList = userDbObjectMapper.selectByExample(userExample);*/
		List<UserTO> userList = userDAO.findByDeleteInd(GeneralUtils.NOT_DELETED);
		return convertToUserVOList(userList);
	}
	
	public void saveUser(UserVO user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		/*List<UserDbObject> dbObjList = convertToUserDbObjectList(Arrays.asList(user));
		if(dbObjList != null && dbObjList.size() > 0){
			userDbObjectMapper.insert(dbObjList.get(0));
		}*/
		List<UserTO> userTOList = convertToUserTOList(Arrays.asList(user));
		userDAO.save(userTOList);
	}
	
	public void resetPassword(String userName, String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		/*UserDbObjectExample example = new UserDbObjectExample();
		UserDbObject user = new UserDbObject();
		user.setPassword(hashedPassword);
		example.createCriteria().andUserNameEqualTo(userName);
		userDbObjectMapper.updateByExampleSelective(user, example);*/
		List<UserTO> userList = userDAO.findByUserNameAndDeleteInd(userName, GeneralUtils.NOT_DELETED);
		if(userList != null && !userList.isEmpty()){
			for(UserTO userTO : userList){
				userTO.setPassword(hashedPassword);
			}
			userDAO.save(userList);
		}
	}
	
	public void deleteUser(Long id) {
		deleteUser(Arrays.asList(id));
		roleAssignmentService.deleteRoleListByUserId(id.intValue());
	}
	
	public void deleteUser(List<Long> idList) {
		/*UserDbObjectExample userDbObjectExample = new UserDbObjectExample();
		userDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andUserIdIn(idList);
		UserDbObject dbObj = new UserDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		userDbObjectMapper.updateByExampleSelective(dbObj, userDbObjectExample);*/
		
		List<UserTO> userToList = userDAO.findByUserIdIn(idList);
		if(userToList != null && !userToList.isEmpty()){
			for(UserTO userTo : userToList){
				userTo.setDeleteInd(GeneralUtils.DELETED);
			}
			userDAO.save(userToList);
		}
	}
	
	public void updateUser(UserVO vo) {
//		userVO.setPassword(null);
		if(vo != null && vo.getUserId() != null){
			/*UserDbObject dbObj = convertToUserDbObjectList(Arrays.asList(userVO)).get(0);
			userDbObjectMapper.updateByPrimaryKeySelective(dbObj);*/
			UserTO userTO = userDAO.findByUserId(vo.getUserId().longValue());
			userTO.setUserName(vo.getUserName());
			userTO.setName(vo.getName());
			userTO.setEmailAddress(vo.getEmailAddress());
			userTO.setEnabled(vo.getEnabled() == null ? "N": vo.getEnabled());
//			UserTO dbObj = convertToUserTOList(Arrays.asList(userDbVO)).get(0);
			userDAO.save(userTO);
		}
	}
	
	private List<UserVO> convertToUserVOListOld(List<UserDbObject> dbObjList) {
		List<UserVO> list = new ArrayList<UserVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(UserDbObject dbObj : dbObjList){
				UserVO vo = new UserVO();
				vo.setEmailAddress(dbObj.getEmailAddress());
				vo.setEnabled(dbObj.getEnabled());
				vo.setEnabledBoolean(dbObj.getEnabled().equals("Y")? Boolean.TRUE : Boolean.FALSE);
				vo.setLastLogin(dbObj.getLastLogin());
				vo.setName(dbObj.getName());
				vo.setPassword(dbObj.getPassword());
				vo.setStatus(dbObj.getStatus());
				vo.setUserId(dbObj.getUserId());
				vo.setUserName(dbObj.getUserName());
				list.add(vo);
			}
		}
		return list;
	}
	
	private List<UserVO> convertToUserVOList(List<UserTO> dbObjList) {
		List<UserVO> list = new ArrayList<UserVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(UserTO dbObj : dbObjList){
				UserVO vo = new UserVO();
				vo.setEmailAddress(dbObj.getEmailAddress());
				vo.setEnabled(dbObj.getEnabled());
				vo.setEnabledBoolean(dbObj.getEnabled().equals("Y")? Boolean.TRUE : Boolean.FALSE);
				vo.setLastLogin(dbObj.getLastLogin());
				vo.setName(dbObj.getName());
				vo.setPassword(dbObj.getPassword());
				vo.setStatus(dbObj.getStatus());
				vo.setUserId(dbObj.getUserId().intValue());
				vo.setUserName(dbObj.getUserName());
				vo.setCreatedBy(dbObj.getCreatedBy());
				vo.setCreatedOn(dbObj.getCreatedOn());
				vo.setUpdatedBy(dbObj.getUpdatedBy());
				vo.setUpdatedOn(dbObj.getUpdatedOn());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setVersion(dbObj.getVersion());
				list.add(vo);
			}
		}
		return list;
	}
	
	private List<UserDbObject> convertToUserDbObjectList(List<UserVO> voList) {
		List<UserDbObject> list = new ArrayList<UserDbObject>();
		if(voList != null && voList.size() > 0){
			for(UserVO obj : voList){
				UserDbObject dbObj = new UserDbObject();
				dbObj.setEmailAddress(obj.getEmailAddress());
				dbObj.setEnabled(obj.getEnabledBoolean() == Boolean.TRUE ? "Y" : "N");
				dbObj.setLastLogin(obj.getLastLogin());
				dbObj.setName(obj.getName());
				dbObj.setPassword(obj.getPassword());
				dbObj.setStatus(obj.getStatus());
				dbObj.setUserId(obj.getUserId());
				dbObj.setUserName(obj.getUserName());
				list.add(dbObj);
			}
		}
		return list;
	}
	
	private List<UserTO> convertToUserTOList(List<UserVO> voList) {
		List<UserTO> userTOlist = new ArrayList<UserTO>();
		if(voList != null && voList.size() > 0){
			for(UserVO vo : voList){
				UserTO to = new UserTO();
				to.setEmailAddress(vo.getEmailAddress());
				to.setEnabled(vo.getEnabledBoolean() == Boolean.TRUE ? "Y" : "N");
				to.setLastLogin(vo.getLastLogin());
				to.setName(vo.getName());
				to.setPassword(vo.getPassword());
				to.setStatus(vo.getStatus());
				to.setUserId(vo.getUserId()==null?null:vo.getUserId().longValue());
				to.setUserName(vo.getUserName());
				userTOlist.add(to);
			}
		}
		return userTOlist;
	}
	
	/*public List<User> getAllUsersById(List<Integer> idList) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdIn(idList);
		List<User> userList = userMapper.selectByExample(userExample);
		return userList;
	}*/
	
}
