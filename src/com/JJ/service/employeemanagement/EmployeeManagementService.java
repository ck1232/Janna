package com.JJ.service.employeemanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.employeemanagement.EmployeeVo;
import com.JJ.controller.employeemanagement.EmploymentTypeEnum;
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
	
	public List<EmployeeVo> getAllEmployeeVo() {
		List<Employee> employeeList = getAllEmployees();
		List<EmployeeVo> voList = new ArrayList<EmployeeVo>();
		if(employeeList != null && employeeList.size() > 0) {
			for(Employee employee : employeeList) {
				EmployeeVo vo = new EmployeeVo();
				vo.setEmployeeid(employee.getEmployeeid());
				vo.setName(employee.getName());
				vo.setEmploymenttype(EmploymentTypeEnum.getEnum(employee.getEmploymenttype()).getType());
				vo.setDob(employee.getDob());
				vo.setDobString(GeneralUtils.convertDateToString(employee.getDob(), "dd/MM/yyyy"));
				vo.setNationality(employee.getNationality());
				vo.setBasicsalary(employee.getBasicsalary());
				vo.setEmploystartdate(employee.getEmploystartdate());
				vo.setEmploystartdateString(GeneralUtils.convertDateToString(employee.getEmploystartdate(), "dd/MM/yyyy"));
				vo.setEmployenddate(employee.getEmployenddate());
				vo.setEmployenddateString(GeneralUtils.convertDateToString(employee.getEmployenddate(), "dd/MM/yyyy"));
				vo.setCdacind(employee.getCdacind());
				vo.setCdacindBoolean(employee.getCdacind().equals("Y") ? Boolean.TRUE: Boolean.FALSE);
				voList.add(vo);
			}
		}
		return voList;
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
