package com.JJ.service.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.UserMapper;
import com.JJ.model.User;
import com.JJ.model.UserExample;

@Service
@Transactional
public class UserManagementService {
	
	private UserMapper userMapper;
	
	@Autowired
	public UserManagementService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public User findById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public List<User> getAllUsers() {
		UserExample userExample = new UserExample();
		userExample.createCriteria();
		List<User> userList = userMapper.selectByExample(userExample);
		return userList;
	}
	
	public void saveUser(User user) {
		userMapper.insert(user);
	}
	
	public void deleteUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	 
	
	
}
