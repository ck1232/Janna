package com.JJ2.dao2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JJ2.entities.User;

public interface UserDAO extends JpaRepository<User, Integer>{
	
    User findByUserId(Integer userId);
}