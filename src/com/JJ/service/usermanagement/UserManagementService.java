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
	public UserManagementService(UserMapper UserMapper) {
		this.userMapper = UserMapper;
	}

	public List<User> getAllUsers(){
		UserExample UserExample = new UserExample();
		UserExample.createCriteria();
		List<User> userList = userMapper.selectByExample(UserExample);
		return userList;
	}
	
	public void saveOrUpdate(User user) {
		userMapper.insert(user);
	}
	
	
	
}
