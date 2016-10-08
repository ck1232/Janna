package com.JJ.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.AdminmoduleMapper;
import com.JJ.model.Adminmodule;
import com.JJ.model.AdminmoduleExample;

@Service
@Transactional
public class TestingService {
	private AdminmoduleMapper adminModuleMapper;
	
	public TestingService (AdminmoduleMapper adminModuleMapper){
		this.adminModuleMapper = adminModuleMapper;
		
	}
	public void testing(){
		AdminmoduleExample example = new AdminmoduleExample();
		example.createCriteria();
		List<Adminmodule> objList = adminModuleMapper.selectByExample(example);
		for(Adminmodule module : objList){
			System.out.println(module.getId());
		}
	}
}
