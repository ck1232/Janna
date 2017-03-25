package com.JJ.service.usermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.UserVO;
import com.JJ.dao.UserDbObjectMapper;
import com.JJ.model.UserDbObject;
import com.JJ.model.UserDbObjectExample;

@Service
@Transactional
public class UserManagementService {
	
	private UserDbObjectMapper userMapper;
	
	@Autowired
	public UserManagementService(UserDbObjectMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public UserVO findById(Integer id) {
		UserDbObject user = userMapper.selectByPrimaryKey(id);
		List<UserVO> userVOList = convertToUserVOList(Arrays.asList(user));
		if(userVOList != null && userVOList.size() > 0){
			return userVOList.get(0);
		}
		return new UserVO();
	}
	
	public UserVO findByUserName(String userName) {
		UserDbObjectExample example = new UserDbObjectExample();
		example.createCriteria().andUserNameEqualTo(userName);
		List<UserDbObject> dbObjList = userMapper.selectByExample(example);
		List<UserVO> voList = convertToUserVOList(dbObjList);
		if(voList != null && voList.size() > 0){
			UserVO user = voList.get(0);
			return user;
		}else{
			return null;
		}
	}
	

	public List<UserVO> getAllUsers() {
		UserDbObjectExample userExample = new UserDbObjectExample();
		userExample.createCriteria();
		List<UserDbObject> userList = userMapper.selectByExample(userExample);
		return convertToUserVOList(userList);
	}
	
	public void saveUser(UserVO user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		List<UserDbObject> dbObjList = convertToUserDbObjectList(Arrays.asList(user));
		if(dbObjList != null && dbObjList.size() > 0){
			userMapper.insert(dbObjList.get(0));
		}
		
	}
	
	public void resetPassword(String userName, String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		UserDbObjectExample example = new UserDbObjectExample();
		UserDbObject user = new UserDbObject();
		user.setPassword(hashedPassword);
		example.createCriteria().andUserNameEqualTo(userName);
		userMapper.updateByExampleSelective(user, example);
	}
	
	public void deleteUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	
	public void updateUser(UserVO user) {
		user.setPassword(null);
		List<UserDbObject> dbObjList = convertToUserDbObjectList(Arrays.asList(user));
		if(dbObjList != null && dbObjList.size() > 0){
			userMapper.updateByPrimaryKeySelective(dbObjList.get(0));
		}
		
	}
	
	private List<UserVO> convertToUserVOList(List<UserDbObject> dbObjList) {
		List<UserVO> list = new ArrayList<UserVO>();
		if(dbObjList != null && dbObjList.size() > 0){
			for(UserDbObject dbObj : dbObjList){
				UserVO vo = new UserVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setEmailAddress(dbObj.getEmailAddress());
				vo.setEnabled(dbObj.getEnabled());
				vo.setEnabledBoolean(dbObj.getEnabled().equals("1")? Boolean.TRUE : Boolean.FALSE);
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
	
	private List<UserDbObject> convertToUserDbObjectList(List<UserVO> voList) {
		List<UserDbObject> list = new ArrayList<UserDbObject>();
		if(voList != null && voList.size() > 0){
			for(UserVO obj : voList){
				UserDbObject dbObj = new UserDbObject();
				dbObj.setDeleteInd(obj.getDeleteInd());
				dbObj.setEmailAddress(obj.getEmailAddress());
				dbObj.setEnabled(obj.getEnabledBoolean() == Boolean.TRUE ? "1" : "0");
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
	
	/*public List<User> getAllUsersById(List<Integer> idList) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdIn(idList);
		List<User> userList = userMapper.selectByExample(userExample);
		return userList;
	}*/
	
}
