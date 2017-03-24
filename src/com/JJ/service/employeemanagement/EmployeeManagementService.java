package com.JJ.service.employeemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.employeemanagement.EmploymentTypeEnum;
import com.JJ.controller.employeemanagement.vo.EmployeeVO;
import com.JJ.dao.EmployeeDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.EmployeeDbObject;
import com.JJ.model.EmployeeDbObjectExample;

@Service
@Transactional
public class EmployeeManagementService {
	
	private EmployeeDbObjectMapper employeeDbObjectMapper;
	
	@Autowired
	public EmployeeManagementService(EmployeeDbObjectMapper employeeDbObjectMapper) {
		this.employeeDbObjectMapper = employeeDbObjectMapper;
	}
	
	public List<EmployeeVO> getAllEmployee() {
		EmployeeDbObjectExample employeeDbObjectExample = new EmployeeDbObjectExample();
		employeeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToEmployeeVOList(employeeDbObjectMapper.selectByExample(employeeDbObjectExample));
	}
	
	public List<EmployeeVO> getAllEmployeeInAscendingName() {
		EmployeeDbObjectExample employeeDbObjectExample = new EmployeeDbObjectExample();
		employeeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		employeeDbObjectExample.setOrderByClause("name asc");
		return convertToEmployeeVOList(employeeDbObjectMapper.selectByExample(employeeDbObjectExample));
	}
	
	public EmployeeVO findById(Integer id) {
		EmployeeDbObject employeeDbObject = employeeDbObjectMapper.selectByPrimaryKey(id);
		if(employeeDbObject != null && employeeDbObject.getEmployeeId() != null){
			return convertToEmployeeVOList(Arrays.asList(employeeDbObject)).get(0);
		}else{
			return new EmployeeVO();
		}
	}
	
	public void saveEmployee(EmployeeVO employeeVO) {
		if(employeeVO != null){
			EmployeeDbObject dbObj = convertToEmployeeDbObjectList(Arrays.asList(employeeVO)).get(0);
			employeeDbObjectMapper.insert(dbObj);
		}
	}
	
	public void deleteEmployee(Integer id) {
		deleteEmployee(Arrays.asList(id));
	}
	
	public void deleteEmployee(List<Integer> idList) {
		EmployeeDbObjectExample employeeDbObjectExample = new EmployeeDbObjectExample();
		employeeDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andEmployeeIdIn(idList);
		EmployeeDbObject dbObj = new EmployeeDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		employeeDbObjectMapper.updateByExampleSelective(dbObj, employeeDbObjectExample);
	}	
	
	public void updateEmployee(EmployeeVO employeeVO) {
		if(employeeVO != null && employeeVO.getDeleteInd() != null &&
				employeeVO.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			EmployeeDbObject dbObj = convertToEmployeeDbObjectList(Arrays.asList(employeeVO)).get(0);
			employeeDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	public List<EmployeeVO> convertToEmployeeVOList(List<EmployeeDbObject> employeeDbObjectList) {
		List<EmployeeVO> voList = new ArrayList<EmployeeVO>();
		if(employeeDbObjectList != null && !employeeDbObjectList.isEmpty()) {
			for(EmployeeDbObject dbObj : employeeDbObjectList) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmployeeId(dbObj.getEmployeeId());
				vo.setName(dbObj.getName());
				vo.setEmployeeType(dbObj.getEmployeeType());
				vo.setEmployeeTypeString(EmploymentTypeEnum.getEnum(dbObj.getEmployeeType()));
				vo.setDob(dbObj.getDob());
				vo.setDobString(GeneralUtils.convertDateToString(dbObj.getDob(), "dd/MM/yyyy"));
				vo.setNationality(dbObj.getNationality());
				vo.setBasicSalary(dbObj.getBasicSalary());
				vo.setEmploymentStartDate(dbObj.getEmploymentStartDate());
				vo.setEmploymentStartDateString(GeneralUtils.convertDateToString(dbObj.getEmploymentStartDate(), "dd/MM/yyyy"));
				vo.setEmploymentEndDate(dbObj.getEmploymentEndDate());
				vo.setEmploymentEndDateString(GeneralUtils.convertDateToString(dbObj.getEmploymentEndDate(), "dd/MM/yyyy"));
				vo.setCdacInd(dbObj.getCdacInd());
				vo.setCdacIndBoolean(dbObj.getCdacInd().equals("Y") ? Boolean.TRUE: Boolean.FALSE);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public List<EmployeeDbObject> convertToEmployeeDbObjectList(List<EmployeeVO> employeeVOList/*, Employee employee*/) {
		List<EmployeeDbObject> employeeDbObjectList = new ArrayList<EmployeeDbObject>();
		if(employeeVOList != null && !employeeVOList.isEmpty()) {
			for(EmployeeVO vo : employeeVOList) {
				EmployeeDbObject dbObj = new EmployeeDbObject();
				dbObj.setName(vo.getName());
				dbObj.setEmployeeType(vo.getEmployeeType());
				dbObj.setDob(vo.getDob());
				dbObj.setNationality(vo.getNationality());
				dbObj.setBasicSalary(vo.getBasicSalary());
				dbObj.setEmploymentStartDate(vo.getEmploymentStartDate());
				dbObj.setEmploymentEndDate(vo.getEmploymentEndDate());
				dbObj.setCdacInd(vo.getCdacInd());
				employeeDbObjectList.add(dbObj);
			}
		}
		return employeeDbObjectList;
	}
}
