package com.JJ.service.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.AppUserMapper;
import com.JJ.model.AppUser;
import com.JJ.model.AppUserExample;

@Service
@Transactional
public class UserManagementService {
	
	private AppUserMapper appUserMapper;
	
	@Autowired
	public UserManagementService(AppUserMapper appUserMapper) {
		this.appUserMapper = appUserMapper;
	}

	public List<AppUser> getAllUsers(){
		AppUserExample appUserExample = new AppUserExample();
		appUserExample.createCriteria();
		List<AppUser> userList = appUserMapper.selectByExample(appUserExample);
		return userList;
	}
	
	public void saveOrUpdate(AppUser user) {
		appUserMapper.insert(user);
	}
	
	
	
}
