package com.JJ.service.employeemanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.employeemanagement.EmploymentTypeEnum;
import com.JJ.controller.employeemanagement.vo.EmployeeVO;
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
	
	public List<EmployeeVO> getAllEmployeeVo() {
		List<Employee> employeeList = getAllEmployees();
		List<EmployeeVO> voList = new ArrayList<EmployeeVO>();
		if(employeeList != null && employeeList.size() > 0) {
			for(Employee employee : employeeList) {
				EmployeeVO vo = convertEmployeeToVo(employee);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public List<EmployeeVO> getAllEmployeeVoInAscendingName() {
		List<Employee> employeeList = getAllEmployees("name asc");
		List<EmployeeVO> voList = new ArrayList<EmployeeVO>();
		if(employeeList != null && employeeList.size() > 0) {
			for(Employee employee : employeeList) {
				EmployeeVO vo = convertEmployeeToVo(employee);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public EmployeeVO getEmployeeById(Integer id) {
		EmployeeVO vo = new EmployeeVO();
		Employee employee = findById(id);
		if(employee != null) {
			vo = convertEmployeeToVo(employee);
		}
		return vo;
	}
	
	public void saveEmployee(EmployeeVO vo) {
		Employee employee = convertVoToEmployee(vo, new Employee());
		saveEmployee(employee);
	}
	
	public void updateEmployee(EmployeeVO vo) {
		Employee employee = findById(vo.getEmployeeid());
		if(employee!=null){
			employee = convertVoToEmployee(vo, employee);
			updateEmployee(employee);
		}
	}
	
	//convert employeeVo to employee
	public Employee convertVoToEmployee(EmployeeVO vo, Employee employee) {
		if(employee == null) {
			employee = new Employee();
		}
		employee.setName(vo.getName());
		employee.setEmploymenttype(vo.getEmploymenttype());
		employee.setDob(vo.getDob());
		employee.setNationality(vo.getNationality());
		employee.setBasicsalary(vo.getBasicsalary());
		employee.setEmploystartdate(vo.getEmploystartdate());
		employee.setEmployenddate(vo.getEmployenddate());
		employee.setCdacind(vo.getCdacind());
		return employee;
	}
	
	//convert employeeVo to employee
	public EmployeeVO convertEmployeeToVo(Employee employee) {
		EmployeeVO vo = new EmployeeVO();
		vo.setEmployeeid(employee.getEmployeeid());
		vo.setName(employee.getName());
		vo.setEmploymenttype(employee.getEmploymenttype());
		vo.setEmploymenttypeString(EmploymentTypeEnum.getEnum(employee.getEmploymenttype()));
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
		return vo;
	}
	
	public Employee findById(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	
	public List<Employee> getAllEmployees() {
		EmployeeExample example = new EmployeeExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Employee> employeeList = employeeMapper.selectByExample(example);
		return employeeList;
	}
	
	public List<Employee> getAllEmployees(String ordByClause) {
		EmployeeExample example = new EmployeeExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		example.setOrderByClause(ordByClause);
		List<Employee> employeeList = employeeMapper.selectByExample(example);
		return employeeList;
	}
	
	public void saveEmployee(Employee employee) {
		employeeMapper.insert(employee);
	}
	
	public void deleteEmployee(Integer id) {
		Employee employee = findById(id);
		if(employee.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			employee.setDeleteInd(GeneralUtils.DELETED);
			employeeMapper.updateByPrimaryKey(employee);
		}
	}
	
	public void updateEmployee(Employee employee) {
		if(employee.getDeleteInd().equals(GeneralUtils.NOT_DELETED))
			employeeMapper.updateByPrimaryKeySelective(employee);
	}
	 
	
	
}
