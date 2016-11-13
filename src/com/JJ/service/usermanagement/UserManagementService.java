package com.JJ.service.usermanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.UserMapper;
import com.JJ.model.CustomUser;
import com.JJ.model.GrantedAuthorityRole;
import com.JJ.model.Role;
import com.JJ.model.User;
import com.JJ.model.UserExample;
import com.JJ.model.UserRole;
import com.JJ.service.roleassignment.RoleAssignmentService;
import com.JJ.service.rolemanagement.RoleManagementService;

@Service
@Transactional
public class UserManagementService {
	
	private UserMapper userMapper;
	private RoleAssignmentService roleAssignmentService;
	private RoleManagementService roleManagementService;
	
	@Autowired
	public UserManagementService(UserMapper userMapper, RoleAssignmentService roleAssignmentService,
			RoleManagementService roleManagementService) {
		this.userMapper = userMapper;
		this.roleAssignmentService = roleAssignmentService;
		this.roleManagementService = roleManagementService;
	}
	
	public User findById(Integer id) {
		User user = userMapper.selectByPrimaryKey(id);
		user.setPassword(null);
		return user;
	}
	
	public User findByUserId(String userid) {
		UserExample example = new UserExample();
		example.createCriteria().andUseridEqualTo(userid);
		List<User> users = userMapper.selectByExample(example);
		if(users != null && users.size() > 0){
			User user = users.get(0);
			user.setPassword(null);
			return user;
		}else{
			return null;
		}
	}
	
	public CustomUser findCustomUserByUserId(String userid) {
		User user = findByUserId(userid);
		if(user != null){
			CustomUser u = new CustomUser();
			u.setUsername(user.getUserid());
			u.setPassword(user.getPassword());
			u.setEmail(user.getEmailaddress());
			u.setEnabled(user.getEnabled());
			List<UserRole> urList = roleAssignmentService.getRoleListByUserId(user.getId());
			List<Integer> rIdList = new ArrayList<Integer>();
			List<GrantedAuthorityRole> garList = new ArrayList<GrantedAuthorityRole>();
			for(UserRole ur: urList) {
				rIdList.add(ur.getRoleid());
			}
			List<Role> rList = roleManagementService.getAllRolesByIdList(rIdList);
			for(Role r: rList) {
				GrantedAuthorityRole role = new GrantedAuthorityRole();
				role.setName(r.getName());
				garList.add(role);
			}
			u.setAuthorities(garList);
			return u;
		}else{
			return null;
		}
	}
	

	public List<User> getAllUsers() {
		UserExample userExample = new UserExample();
		userExample.createCriteria();
		List<User> userList = userMapper.selectByExample(userExample);
		return userList;
	}
	
	public void saveUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		userMapper.insert(user);
	}
	
	public void resetPassword(String userid, String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		UserExample example = new UserExample();
		User user = new User();
		user.setPassword(hashedPassword);
		example.createCriteria().andUseridEqualTo(userid);
		userMapper.updateByExampleSelective(user, example);
	}
	
	public void deleteUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	
	public void updateUser(User user) {
		user.setPassword(null);
		userMapper.updateByPrimaryKeySelective(user);
	}
	
	/*public List<User> getAllUsersById(List<Integer> idList) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdIn(idList);
		List<User> userList = userMapper.selectByExample(userExample);
		return userList;
	}*/
	
}
