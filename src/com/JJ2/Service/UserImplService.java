/*package com.JJ2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ2.dao2.UserDAO;
import com.JJ2.entities.User;

@Service("UserImplService")
public class UserImplService {
	@Autowired
	UserDAO userRepository;
	
	@Transactional
	public User getCountry(int id) {
	  return userRepository.findOne(id);
	}
}
*/