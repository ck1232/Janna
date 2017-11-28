package com.JJ2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ2.dao2.UserDAO;
import com.JJ2.entities.User;


@Service("UserService")
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public UserService(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	@Transactional
	public User getUserById(Integer userId) {
		return userDAO.findOne(userId);
	}
	
}