package com.JJ.service.employeemanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.EmployeeMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Employee;
import com.JJ.model.EmployeeExample;

@Service
@Transactional
public class EmployeeManagementService {
	
	private EmployeeMapper employeeMapper;
	
	@Autowired
	public EmployeeManagementService(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}
	
	public Employee findById(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	
	public List<Employee> getAllEmployees() {
		EmployeeExample employeeExample = new EmployeeExample();
		employeeExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
		return employeeList;
	}
	
	public void saveEmployee(Employee employee) {
		employeeMapper.insert(employee);
	}
	
	public void deleteEmployee(Integer id) {
		Employee employee = findById(id);
		if(employee.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			employee.setDeleteind(GeneralUtils.DELETED);
			employeeMapper.updateByPrimaryKey(employee);
		}
	}
	
	public void updateEmployee(Employee employee) {
		if(employee.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			employeeMapper.updateByPrimaryKeySelective(employee);
	}
	 
	
	
}
