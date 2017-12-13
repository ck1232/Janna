package com.JJ.service.salarybonusmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.employeemanagement.EmploymentTypeEnum;
import com.JJ.controller.employeemanagement.vo.EmployeeVO;
import com.JJ.controller.expensemanagement.ExpenseStatusEnum;
import com.JJ.controller.salarybonusmanagement.TypeEnum;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.dao.EmployeeBonusDbObjectMapper;
import com.JJ.dao.EmployeeSalaryDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.EmployeeBonusDbObject;
import com.JJ.model.EmployeeBonusDbObjectExample;
import com.JJ.model.EmployeeSalaryDbObject;
import com.JJ.model.EmployeeSalaryDbObjectExample;
import com.JJ.service.employeemanagement.EmployeeManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class SalaryBonusManagementService {
	
	private EmployeeManagementService employeeManagementService;
	private EmployeeSalaryDbObjectMapper employeeSalaryDbObjectMapper;
	private EmployeeBonusDbObjectMapper employeeBonusDbObjectMapper;
	
	@Autowired
	public SalaryBonusManagementService(EmployeeManagementService employeeManagementService,
			EmployeeSalaryDbObjectMapper employeeSalaryDbObjectMapper,
			EmployeeBonusDbObjectMapper employeeBonusDbObjectMapper) {
		this.employeeManagementService = employeeManagementService;
		this.employeeSalaryDbObjectMapper = employeeSalaryDbObjectMapper;
		this.employeeBonusDbObjectMapper = employeeBonusDbObjectMapper;
		
	}
	
	//get all salary and bonus
	public List<SalaryBonusVO> getAllSalaryBonusVo() {
		List<SalaryBonusVO> salaryBonusVoList = new ArrayList<SalaryBonusVO>();
		salaryBonusVoList.addAll(getAllSalaryVo());
		salaryBonusVoList.addAll(getAllBonusVo());
		return salaryBonusVoList;
	}
	
	public List<SalaryBonusVO> getAllSalaryVo(){
		List<SalaryBonusVO> salaryBonusVoList = new ArrayList<SalaryBonusVO>();
		EmployeeSalaryDbObjectExample employeeSalaryDbObjectExample = new EmployeeSalaryDbObjectExample();
		employeeSalaryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<EmployeeSalaryDbObject> salaryList = employeeSalaryDbObjectMapper.selectByExample(employeeSalaryDbObjectExample);
		if(salaryList != null && !salaryList.isEmpty()){
			salaryBonusVoList.addAll(convertSalaryToSalaryBonusVOList(salaryList));
		}
		return salaryBonusVoList;
	}
	
	public List<SalaryBonusVO> getAllSalaryVo(Date startDate, Date endDate){
		List<SalaryBonusVO> salaryBonusVoList = new ArrayList<SalaryBonusVO>();
		EmployeeSalaryDbObjectExample employeeSalaryDbObjectExample = new EmployeeSalaryDbObjectExample();
		employeeSalaryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
		.andSalaryDateGreaterThanOrEqualTo(startDate).andSalaryDateLessThanOrEqualTo(endDate);
		employeeSalaryDbObjectExample.setOrderByClause("salary_date");
		List<EmployeeSalaryDbObject> salaryList = employeeSalaryDbObjectMapper.selectByExample(employeeSalaryDbObjectExample);
		if(salaryList != null && !salaryList.isEmpty()){
			salaryBonusVoList.addAll(convertSalaryToSalaryBonusVOList(salaryList));
		}
		return salaryBonusVoList;
	}
	
	public List<SalaryBonusVO> getAllBonusVo(){
		List<SalaryBonusVO> salaryBonusVoList = new ArrayList<SalaryBonusVO>();
		EmployeeBonusDbObjectExample employeeBonusDbObjectExample = new EmployeeBonusDbObjectExample();
		employeeBonusDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<EmployeeBonusDbObject> bonusList = employeeBonusDbObjectMapper.selectByExample(employeeBonusDbObjectExample);
		if(bonusList != null && !bonusList.isEmpty()) {
			salaryBonusVoList.addAll(convertBonusToSalaryBonusVOList(bonusList));
		}
		return salaryBonusVoList;
	}
	
	public List<SalaryBonusVO> getAllBonusVo(Date startDate, Date endDate){
		List<SalaryBonusVO> salaryBonusVoList = new ArrayList<SalaryBonusVO>();
		EmployeeBonusDbObjectExample employeeBonusDbObjectExample = new EmployeeBonusDbObjectExample();
		employeeBonusDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
		.andBonusDateGreaterThanOrEqualTo(startDate).andBonusDateLessThanOrEqualTo(endDate);
		employeeBonusDbObjectExample.setOrderByClause("bonus_date");
		List<EmployeeBonusDbObject> bonusList = employeeBonusDbObjectMapper.selectByExample(employeeBonusDbObjectExample);
		if(bonusList != null && !bonusList.isEmpty()) {
			salaryBonusVoList.addAll(convertBonusToSalaryBonusVOList(bonusList));
		}
		return salaryBonusVoList;
	}
	
	public SalaryBonusVO findSalaryById(Integer id) {
		EmployeeSalaryDbObject employeeSalaryDbObject = employeeSalaryDbObjectMapper.selectByPrimaryKey(id);
		if(employeeSalaryDbObject != null && employeeSalaryDbObject.getSalaryId() != null){
			return convertSalaryToSalaryBonusVOList(Arrays.asList(employeeSalaryDbObject)).get(0);
		}else{
			return new SalaryBonusVO();
		}
	}
	
	public SalaryBonusVO findBonusById(Integer id) {
		EmployeeBonusDbObject employeeBonusDbObject = employeeBonusDbObjectMapper.selectByPrimaryKey(id);
		if(employeeBonusDbObject != null && employeeBonusDbObject.getBonusId() != null){
			return convertBonusToSalaryBonusVOList(Arrays.asList(employeeBonusDbObject)).get(0);
		}else{
			return new SalaryBonusVO();
		}
	}
	
	public List<SalaryBonusVO> getAllSalaryByIdList(List<Integer> idList) {
		if(idList != null && idList.size() > 0){
			EmployeeSalaryDbObjectExample employeeSalaryDbObjectExample = new EmployeeSalaryDbObjectExample();
			employeeSalaryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSalaryIdIn(idList);
			employeeSalaryDbObjectExample.setOrderByClause("salary_date desc");
			return convertSalaryToSalaryBonusVOList(employeeSalaryDbObjectMapper.selectByExample(employeeSalaryDbObjectExample));
		}
		return new ArrayList<SalaryBonusVO>();
	}
	
	public List<SalaryBonusVO> getAllSalaryByEmpId(Integer employeeId) {
		EmployeeSalaryDbObjectExample employeeSalaryDbObjectExample = new EmployeeSalaryDbObjectExample();
		employeeSalaryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andEmployeeIdEqualTo(employeeId);
		employeeSalaryDbObjectExample.setOrderByClause("salary_date desc");
		return convertSalaryToSalaryBonusVOList(employeeSalaryDbObjectMapper.selectByExample(employeeSalaryDbObjectExample));
	}
	
	public List<SalaryBonusVO> getAllBonusByIdList(List<Integer> idList) {
		if(idList != null && idList.size() > 0){
			EmployeeBonusDbObjectExample employeeBonusDbObjectExample = new EmployeeBonusDbObjectExample();
			employeeBonusDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andBonusIdIn(idList);
			employeeBonusDbObjectExample.setOrderByClause("bonus_date desc");
			return convertBonusToSalaryBonusVOList(employeeBonusDbObjectMapper.selectByExample(employeeBonusDbObjectExample));
		}
		return new ArrayList<SalaryBonusVO>();
	}
	
	public List<SalaryBonusVO> getAllBonusByEmpId(Integer employeeId) {
		EmployeeBonusDbObjectExample employeeBonusDbObjectExample = new EmployeeBonusDbObjectExample();
		employeeBonusDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andEmployeeIdEqualTo(employeeId);
		employeeBonusDbObjectExample.setOrderByClause("bonus_date desc");
		return convertBonusToSalaryBonusVOList(employeeBonusDbObjectMapper.selectByExample(employeeBonusDbObjectExample));
	}
	
	public void saveSalaryBonus(SalaryBonusVO salaryBonusVO) {
		if(salaryBonusVO != null){
			salaryBonusVO.setStatus(ExpenseStatusEnum.UNPAID.toString());
			if(salaryBonusVO.getType().equals(TypeEnum.SALARY.toString())) {
				EmployeeSalaryDbObject dbObj = convertToSalaryDbObjectList(Arrays.asList(salaryBonusVO)).get(0);
				employeeSalaryDbObjectMapper.insert(dbObj);
				salaryBonusVO.setId(dbObj.getSalaryId());
			}else if(salaryBonusVO.getType().equals(TypeEnum.BONUS.toString())) {
				EmployeeBonusDbObject dbObj = convertToBonusDbObjectList(Arrays.asList(salaryBonusVO)).get(0);
				employeeBonusDbObjectMapper.insert(dbObj);
				salaryBonusVO.setId(dbObj.getBonusId());
			}
		}
	}
	

	public void updateSalaryBonus(SalaryBonusVO salaryBonusVO) {
		if(salaryBonusVO != null && salaryBonusVO.getId() != null){
			if(salaryBonusVO.getType().equals("Salary")) {
				EmployeeSalaryDbObject dbObj = convertToSalaryDbObjectList(Arrays.asList(salaryBonusVO)).get(0);
				employeeSalaryDbObjectMapper.updateByPrimaryKeySelective(dbObj);
				
			}else if(salaryBonusVO.getType().equals("Bonus")) {
				EmployeeBonusDbObject dbObj = convertToBonusDbObjectList(Arrays.asList(salaryBonusVO)).get(0);
				employeeBonusDbObjectMapper.updateByPrimaryKeySelective(dbObj);
			}
		}
	}
	
	
	//delete salary and bonus from idList
	public void deleteSalaryBonus(List<String> idList) {
		for(String id : idList) {
			String[] splitId = id.split("-");
			if(splitId[0] != null && splitId[1] != null){
				if(splitId[1].toLowerCase().equals("salary")) {
					deleteSalary(Arrays.asList(Integer.valueOf(splitId[0])));
				}else if(splitId[1].toLowerCase().equals("bonus")) {
					deleteBonus(Arrays.asList(Integer.valueOf(splitId[0])));
				}
			}
		}
	}
	
	public void deleteSalary(List<Integer> idList) {
		EmployeeSalaryDbObjectExample employeeSalaryDbObjectExample = new EmployeeSalaryDbObjectExample();
		employeeSalaryDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andSalaryIdIn(idList);
		EmployeeSalaryDbObject dbObj = new EmployeeSalaryDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		employeeSalaryDbObjectMapper.updateByExampleSelective(dbObj, employeeSalaryDbObjectExample);
	}
	
	public void deleteBonus(List<Integer> idList) {
		EmployeeBonusDbObjectExample employeeBonusDbObjectExample = new EmployeeBonusDbObjectExample();
		employeeBonusDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andBonusIdIn(idList);
		EmployeeBonusDbObject dbObj = new EmployeeBonusDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		employeeBonusDbObjectMapper.updateByExampleSelective(dbObj, employeeBonusDbObjectExample);
	}	

	//calculate gross amount from EmployeeSalary
	//gross amount = basic salary amount + overtime amount + allowance + medical
	private BigDecimal calculateGrossAmount(EmployeeSalaryDbObject salary) {
		BigDecimal grossamount = BigDecimal.ZERO;
		if(salary.getBasicSalaryAmt() != null)
			grossamount = grossamount.add(salary.getBasicSalaryAmt());
		if(salary.getOverTimeAmt() != null)
			grossamount = grossamount.add(salary.getOverTimeAmt());
		if(salary.getAllowance() != null)
			grossamount = grossamount.add(salary.getAllowance());
		if(salary.getMedical() != null)
			grossamount = grossamount.add(salary.getMedical());
		if(salary.getUnpaidLeaveAmt() != null){
			grossamount = grossamount.subtract(salary.getUnpaidLeaveAmt());
		}
		return grossamount;
	}
	
	//calculate take home amount from EmployeeSalary and gross amount
	//take home amount = gross amount - employee cpf
	private BigDecimal calculateTakeHomeAmount(SalaryBonusVO vo, EmployeeSalaryDbObject salary) {
		BigDecimal takehomeamount = vo.getGrossAmt();
		if(salary.getEmployeeCpf() != null)
			takehomeamount = takehomeamount.subtract(salary.getEmployeeCpf());
		return takehomeamount;
	}
	
	private BigDecimal calculateTakeHomeAmountBonus(SalaryBonusVO vo, EmployeeBonusDbObject bonus) {
		BigDecimal takehomeamount = vo.getBonusAmt();
		if(bonus.getEmployeeCpf() != null)
			takehomeamount = takehomeamount.subtract(bonus.getEmployeeCpf());
		return takehomeamount;
	}
	
	public List<SalaryBonusVO> convertBonusToSalaryBonusVOList(List<EmployeeBonusDbObject> bonusDbObjectList) {
		List<SalaryBonusVO> voList = new ArrayList<SalaryBonusVO>();
		if(bonusDbObjectList != null && bonusDbObjectList.size() > 0){
			for(EmployeeBonusDbObject dbObj : bonusDbObjectList) {
				SalaryBonusVO vo = new SalaryBonusVO();
				vo.setId(dbObj.getBonusId());
				vo.setDate(dbObj.getBonusDate());
				vo.setDateString(GeneralUtils.convertDateToString(dbObj.getBonusDate(), "yyyy"));
				EmployeeVO employeeVO = employeeManagementService.findById(dbObj.getEmployeeId());
				vo.setEmployeeId(employeeVO.getEmployeeId());
				vo.setName(employeeVO.getName());
				vo.setEmployeeType(employeeVO.getEmployeeType());
				vo.setEmployeeTypeString(EmploymentTypeEnum.getEnum(employeeVO.getEmployeeType()));
				vo.setDob(employeeVO.getDob());
				vo.setNationality(employeeVO.getNationality());
				vo.setBasicSalaryAmt(employeeVO.getBasicSalary());
				vo.setEmploymentStartDate(employeeVO.getEmploymentStartDate());
				vo.setEmploymentEndDate(employeeVO.getEmploymentEndDate());
				vo.setCdacInd(employeeVO.getCdacInd());
				vo.setBonusAmt(dbObj.getBonusAmt());
				vo.setBonusAmtString("$"+dbObj.getBonusAmt());
				vo.setEmployeeCpf(dbObj.getEmployeeCpf());
				vo.setEmployerCpf(dbObj.getEmployerCpf());
				vo.setTakehomeAmt(calculateTakeHomeAmountBonus(vo, dbObj));
				vo.setTakehomeAmtString("$"+vo.getTakehomeAmt());
				vo.setType(GeneralUtils.TYPE_BONUS);
				vo.setStatus(dbObj.getStatus());
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setVersion(dbObj.getVersion());
				voList.add(vo);
			}
		}
		return voList;
	}

	public List<SalaryBonusVO> convertSalaryToSalaryBonusVOList(List<EmployeeSalaryDbObject> salaryDbObjectList) {
		List<SalaryBonusVO> voList = new ArrayList<SalaryBonusVO>();
		if(salaryDbObjectList != null && salaryDbObjectList.size() > 0){
			for(EmployeeSalaryDbObject dbObj : salaryDbObjectList){
				SalaryBonusVO vo = new SalaryBonusVO();
				vo.setId(dbObj.getSalaryId());
				vo.setDate(dbObj.getSalaryDate());
				vo.setDateString(GeneralUtils.convertDateToString(dbObj.getSalaryDate(), "MM-yyyy"));
				EmployeeVO employee = employeeManagementService.findById(dbObj.getEmployeeId());
				vo.setEmployeeId(employee.getEmployeeId());
				vo.setName(employee.getName());
				vo.setEmployeeType(employee.getEmployeeType());
				vo.setEmployeeTypeString(EmploymentTypeEnum.getEnum(employee.getEmployeeType()));
				vo.setDob(employee.getDob());
				vo.setNationality(employee.getNationality());
				vo.setBasicSalaryAmt(dbObj.getBasicSalaryAmt());
				vo.setEmploymentStartDate(employee.getEmploymentStartDate());
				vo.setEmploymentEndDate(employee.getEmploymentEndDate());
				vo.setCdacInd(employee.getCdacInd());
				vo.setOverTimeAmt(dbObj.getOverTimeAmt());
				vo.setOverTimeHours(dbObj.getOverTimeHours());
				vo.setOverTimeRemarks(dbObj.getOverTimeRemarks());
				vo.setAllowance(dbObj.getAllowance());
				vo.setMedical(dbObj.getMedical());
				vo.setEmployeeCpf(dbObj.getEmployeeCpf());
				vo.setEmployerCpf(dbObj.getEmployerCpf());
				vo.setLeaveBalance(dbObj.getLeaveBalance());
				vo.setLeaveTaken(dbObj.getLeaveTaken());
				vo.setUnpaidLeaveAmt(dbObj.getUnpaidLeaveAmt());
				vo.setUnpaidLeaveRemarks(dbObj.getUnpaidLeaveRemarks());
				vo.setCdacAmt(dbObj.getCdacAmt());
				vo.setSdlAmt(dbObj.getSdlAmt());
				vo.setFwLevy(dbObj.getFwLevy());
				vo.setGrossAmt(calculateGrossAmount(dbObj));
				vo.setGrossAmtString("$"+vo.getGrossAmt());
				vo.setTakehomeAmt(calculateTakeHomeAmount(vo, dbObj));
				vo.setTakehomeAmtString("$"+vo.getTakehomeAmt());
				vo.setType(GeneralUtils.TYPE_SALARY);
				vo.setStatus(dbObj.getStatus());
				voList.add(vo);
			}
		}
		return voList;
	}
	
	private List<EmployeeSalaryDbObject> convertToSalaryDbObjectList(List<SalaryBonusVO> salaryBonusVoList) {
		List<EmployeeSalaryDbObject> employeeSalaryDbObjectList = new ArrayList<EmployeeSalaryDbObject>();
		if(salaryBonusVoList != null && !salaryBonusVoList.isEmpty()) {
			for(SalaryBonusVO vo : salaryBonusVoList) {
				EmployeeSalaryDbObject dbObj = new EmployeeSalaryDbObject();
				dbObj.setSalaryId(vo.getId());
				dbObj.setSalaryDate(GeneralUtils.convertStringToDate(vo.getDateString(), "dd/MM/yyyy"));
				dbObj.setEmployeeId(vo.getEmployeeId());
				dbObj.setBasicSalaryAmt(vo.getBasicSalaryAmt());
				dbObj.setOverTimeAmt(vo.getOverTimeAmt());
				dbObj.setOverTimeHours(vo.getOverTimeHours());
				dbObj.setOverTimeRemarks(vo.getOverTimeRemarks());
				dbObj.setAllowance(vo.getAllowance());
				dbObj.setMedical(vo.getMedical());
				dbObj.setLeaveBalance(vo.getLeaveBalance());
				dbObj.setLeaveTaken(vo.getLeaveTaken());
				dbObj.setUnpaidLeaveAmt(vo.getUnpaidLeaveAmt());
				dbObj.setUnpaidLeaveRemarks(vo.getUnpaidLeaveRemarks());
				dbObj.setEmployeeCpf(vo.getEmployeeCpf());
				dbObj.setEmployerCpf(vo.getEmployerCpf());
				dbObj.setCdacAmt(vo.getCdacAmt());
				dbObj.setSdlAmt(vo.getSdlAmt());
				dbObj.setFwLevy(vo.getFwLevy());
				dbObj.setStatus(vo.getStatus());
				employeeSalaryDbObjectList.add(dbObj);
			}
		}
		
		return employeeSalaryDbObjectList;
	}
	
	private List<EmployeeBonusDbObject> convertToBonusDbObjectList(List<SalaryBonusVO> salaryBonusVoList) {
		List<EmployeeBonusDbObject> employeeBonusDbObjectList = new ArrayList<EmployeeBonusDbObject>();
		if(salaryBonusVoList != null && !salaryBonusVoList.isEmpty()) {
			for(SalaryBonusVO vo : salaryBonusVoList) {
				EmployeeBonusDbObject dbObj = new EmployeeBonusDbObject();
				dbObj.setBonusId(vo.getId());
				dbObj.setBonusDate(vo.getDate());
				dbObj.setEmployeeId(vo.getEmployeeId());
				dbObj.setBonusAmt(vo.getBonusAmt());
				dbObj.setEmployeeCpf(vo.getEmployeeCpf());
				dbObj.setEmployerCpf(vo.getEmployerCpf());
				dbObj.setStatus(vo.getStatus());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setVersion(vo.getVersion());
				employeeBonusDbObjectList.add(dbObj);
			}
		}
		
		return employeeBonusDbObjectList;
	}
}
