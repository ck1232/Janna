package com.JJ.service.salarybonusmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.expensemanagement.ExpenseStatusEnum;
import com.JJ.controller.salarybonusmanagement.TypeEnum;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVo;
import com.JJ.dao.EmployeeBonusMapper;
import com.JJ.dao.EmployeeSalaryMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Employee;
import com.JJ.model.EmployeeBonus;
import com.JJ.model.EmployeeBonusExample;
import com.JJ.model.EmployeeSalary;
import com.JJ.model.EmployeeSalaryExample;
import com.JJ.service.employeemanagement.EmployeeManagementService;

@Service
@Transactional
public class SalaryBonusManagementService {
	
	private EmployeeManagementService employeeManagementService;
	private EmployeeSalaryMapper employeeSalaryMapper;
	private EmployeeBonusMapper employeeBonusMapper;
	
	@Autowired
	public SalaryBonusManagementService(EmployeeManagementService employeeManagementService,
			EmployeeSalaryMapper employeeSalaryMapper,
			EmployeeBonusMapper employeeBonusMapper) {
		this.employeeManagementService = employeeManagementService;
		this.employeeSalaryMapper = employeeSalaryMapper;
		this.employeeBonusMapper = employeeBonusMapper;
		
	}
	
	//get all salary and bonus
	public List<SalaryBonusVo> getAllSalaryBonusVo() {
		List<SalaryBonusVo> salaryBonusVoList = new ArrayList<SalaryBonusVo>();
		
		List<EmployeeSalary> salaryList = getAllSalary();
		if(salaryList != null && !salaryList.isEmpty()){
			for(EmployeeSalary salary : salaryList) {
				SalaryBonusVo vo = convertSalaryToVo(salary);
				salaryBonusVoList.add(vo);
			}
		}
		
		List<EmployeeBonus> bonusList = getAllBonus();
		if(bonusList != null && !bonusList.isEmpty()) {
			for(EmployeeBonus bonus : bonusList) {
				SalaryBonusVo vo = convertBonusToVo(bonus);
				salaryBonusVoList.add(vo);
			}
		}
		return salaryBonusVoList;
	}
	
	public List<SalaryBonusVo> getAllSalaryByIdList(List<Integer> idList) {
		List<EmployeeSalary> salaryList = getAllSalaryByIdListWithOrderBy(idList, "salaryDate desc");
		List<SalaryBonusVo> voList = new ArrayList<SalaryBonusVo>();
		if(salaryList != null && !salaryList.isEmpty()) {
			for(EmployeeSalary salary : salaryList) {
				SalaryBonusVo vo = convertSalaryToVo(salary);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public List<SalaryBonusVo> getAllSalaryByEmpId(Integer employeeId) {
		List<EmployeeSalary> salaryList = getAllSalaryByEmpIdWithOrderBy(employeeId, "salaryDate desc");
		List<SalaryBonusVo> voList = new ArrayList<SalaryBonusVo>();
		if(salaryList != null && !salaryList.isEmpty()) {
			for(EmployeeSalary salary : salaryList) {
				SalaryBonusVo vo = convertSalaryToVo(salary);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public List<SalaryBonusVo> getAllBonusByIdList(List<Integer> idList) {
		List<EmployeeBonus> bonusList = getAllBonusByIdListWithOrderBy(idList, "bonusDate desc");
		List<SalaryBonusVo> voList = new ArrayList<SalaryBonusVo>();
		if(bonusList != null && !bonusList.isEmpty()) {
			for(EmployeeBonus bonus : bonusList) {
				SalaryBonusVo vo = convertBonusToVo(bonus);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public List<SalaryBonusVo> getAllBonusByEmpId(Integer employeeId) {
		List<EmployeeBonus> bonusList = getAllBonusByEmpIdWithOrderBy(employeeId, "bonusDate desc");
		List<SalaryBonusVo> voList = new ArrayList<SalaryBonusVo>();
		if(bonusList != null && !bonusList.isEmpty()) {
			for(EmployeeBonus bonus : bonusList) {
				SalaryBonusVo vo = convertBonusToVo(bonus);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public void saveSalaryBonus(SalaryBonusVo vo) {
		vo.setStatus(ExpenseStatusEnum.UNPAID.toString());
		if(vo.getType().equals(TypeEnum.SALARY.toString())) {
			EmployeeSalary salary = convertVoToSalary(vo, new EmployeeSalary());
			saveSalary(salary);
			vo.setId(salary.getSalaryid());
			
		}else if(vo.getType().equals(TypeEnum.BONUS.toString())) {
			EmployeeBonus bonus = convertVoToBonus(vo, new EmployeeBonus());
			saveBonus(bonus);
			vo.setId(bonus.getBonusid());
		}
	}
	
	public void updateSalaryBonus(SalaryBonusVo vo) {
		if(vo.getType().equals("Salary")) {
			EmployeeSalary salary = getSalaryById(vo.getId());
			salary = convertVoToSalary(vo, salary);
			updateSalary(salary);
			
		}else if(vo.getType().equals("Bonus")) {
			EmployeeBonus bonus = getBonusById(vo.getId());
			bonus = convertVoToBonus(vo, bonus);
			updateBonus(bonus);
		}
	}
	
	
	//delete salary and bonus from idList
	public void deleteSalaryBonus(List<String> idList) {
		for(String id : idList) {
			String[] splitId = id.split(",");
			if(splitId[0] != null && splitId[1] != null){
				if(splitId[1].toLowerCase().equals("salary")) {
					deleteSalary(Integer.valueOf(splitId[0]));
				}else if(splitId[1].toLowerCase().equals("bonus")) {
					deleteBonus(Integer.valueOf(splitId[0]));
				}
			}
		}
	}
	
	public void deleteSalaryList(List<Integer> idList) {
		for(Integer id : idList)
			deleteSalary(id);
	}
	
	public void deleteBonusList(List<Integer> idList) {
		for(Integer id : idList)
			deleteBonus(id);
	}
	
	public SalaryBonusVo convertSalaryToVo(EmployeeSalary salary) {
		SalaryBonusVo vo = new SalaryBonusVo();
		vo.setId(salary.getSalaryid());
		vo.setDate(salary.getSalarydate());
		vo.setDateString(GeneralUtils.convertDateToString(salary.getSalarydate(), "MMM-yyyy"));
		Employee employee = employeeManagementService.findById(salary.getEmployeeid());
		vo.setEmployeeid(employee.getEmployeeid());
		vo.setName(employee.getName());
		vo.setEmploymenttype(employee.getEmploymenttype());
		vo.setDob(employee.getDob());
		vo.setNationality(employee.getNationality());
		vo.setBasicsalary(employee.getBasicsalary());
		vo.setEmploystartdate(employee.getEmploystartdate());
		vo.setEmployenddate(employee.getEmployenddate());
		vo.setCdacind(employee.getCdacind());
		vo.setGrossamount(calculateGrossAmount(salary));
		vo.setTakehomeamount(calculateTakeHomeAmount(vo, salary));
		vo.setType(GeneralUtils.TYPE_SALARY);
		vo.setStatus(salary.getStatus());
		return vo;
	}
	
	public EmployeeSalary convertVoToSalary(SalaryBonusVo vo, EmployeeSalary salary) {
		if(salary == null)
			salary = new EmployeeSalary();
		salary.setSalarydate(vo.getDate());
		salary.setEmployeeid(vo.getEmployeeid());
		salary.setBasicsalaryamount(vo.getBasicsalary());
		salary.setOvertimeamount(vo.getOvertimeamount());
		salary.setOvertimehours(vo.getOvertimehours());
		salary.setOvertimeremark(vo.getOvertimeremark());
		salary.setAllowance(vo.getAllowance());
		salary.setUnpaidleaveamount(vo.getUnpaidleaveamount());
		salary.setUnpaidleaveremark(vo.getUnpaidleaveremark());
		salary.setEmployeecpf(vo.getEmployeecpf());
		salary.setEmployercpf(vo.getEmployercpf());
		salary.setCdacamount(vo.getCdacamount());
		salary.setSdlamount(vo.getSdlamount());
		salary.setFwlevy(vo.getFwlevy());
		salary.setStatus(vo.getStatus());
		return salary;
	}
	
	public SalaryBonusVo convertBonusToVo(EmployeeBonus bonus) {
		SalaryBonusVo vo = new SalaryBonusVo();
		vo.setId(bonus.getBonusid());
		vo.setDate(bonus.getBonusdate());
		vo.setDateString(GeneralUtils.convertDateToString(bonus.getBonusdate(), "yyyy"));
		Employee employee = employeeManagementService.findById(bonus.getEmployeeid());
		vo.setEmployeeid(employee.getEmployeeid());
		vo.setName(employee.getName());
		vo.setEmploymenttype(employee.getEmploymenttype());
		vo.setDob(employee.getDob());
		vo.setNationality(employee.getNationality());
		vo.setBasicsalary(employee.getBasicsalary());
		vo.setEmploystartdate(employee.getEmploystartdate());
		vo.setEmployenddate(employee.getEmployenddate());
		vo.setCdacind(employee.getCdacind());
		vo.setBonusamount(bonus.getBonusamount());
		vo.setType(GeneralUtils.TYPE_BONUS);
		vo.setStatus(bonus.getStatus());
		return vo;
	}

	public EmployeeBonus convertVoToBonus(SalaryBonusVo vo, EmployeeBonus bonus) {
		if(bonus == null)
			bonus = new EmployeeBonus();
		bonus.setBonusdate(vo.getDate());
		bonus.setEmployeeid(vo.getEmployeeid());
		bonus.setBonusamount(vo.getBonusamount());
		bonus.setEmployeecpf(vo.getEmployeecpf());
		bonus.setEmployercpf(vo.getEmployercpf());
		bonus.setStatus(vo.getStatus());
		return bonus;
	}
	
	//calculate gross amount from EmployeeSalary
	//gross amount = basic salary amount + overtime amount + allowance
	private BigDecimal calculateGrossAmount(EmployeeSalary salary) {
		BigDecimal grossamount = BigDecimal.ZERO;
		if(salary.getBasicsalaryamount() != null)
			grossamount = grossamount.add(salary.getBasicsalaryamount());
		if(salary.getOvertimeamount() != null)
			grossamount = grossamount.add(salary.getOvertimeamount());
		if(salary.getAllowance() != null)
			grossamount = grossamount.add(salary.getAllowance());
		return grossamount;
	}
	
	//calculate take home amount from EmployeeSalary and gross amount
	//take home amount = gross amount - employee cpf - cdac amount
	private BigDecimal calculateTakeHomeAmount(SalaryBonusVo vo, EmployeeSalary salary) {
		BigDecimal takehomeamount = vo.getGrossamount();
		if(salary.getOvertimeamount() != null)
			takehomeamount = takehomeamount.subtract(salary.getEmployeecpf());
		if(salary.getOvertimeamount() != null)
			takehomeamount = takehomeamount.subtract(salary.getCdacamount());
		return takehomeamount;
	}
		
	
	public List<EmployeeSalary> getAllSalary() {
		EmployeeSalaryExample example = new EmployeeSalaryExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<EmployeeSalary> salaryList = employeeSalaryMapper.selectByExample(example);
		return salaryList;
	}
	
	public List<EmployeeSalary> getAllSalaryWithOrderBy(String orderByClause) {
		EmployeeSalaryExample example = new EmployeeSalaryExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		example.setOrderByClause(orderByClause);
		List<EmployeeSalary> salaryList = employeeSalaryMapper.selectByExample(example);
		return salaryList;
	}
	
	public List<EmployeeSalary> getAllSalaryByIdListWithOrderBy(List<Integer> idList, String orderByClause) {
		EmployeeSalaryExample example = new EmployeeSalaryExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andSalaryidIn(idList);
		example.setOrderByClause(orderByClause);
		List<EmployeeSalary> salaryList = employeeSalaryMapper.selectByExample(example);
		return salaryList;
	}
	
	public List<EmployeeSalary> getAllSalaryByEmpIdWithOrderBy(Integer empId, String orderByClause) {
		EmployeeSalaryExample example = new EmployeeSalaryExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andEmployeeidEqualTo(empId);
		example.setOrderByClause(orderByClause);
		List<EmployeeSalary> salaryList = employeeSalaryMapper.selectByExample(example);
		return salaryList;
	}
	
	public List<EmployeeBonus> getAllBonus() {
		EmployeeBonusExample example = new EmployeeBonusExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<EmployeeBonus> bonusList = employeeBonusMapper.selectByExample(example);
		return bonusList;
	}
	
	public List<EmployeeBonus> getAllBonusWithOrderBy(String orderByClause) {
		EmployeeBonusExample example = new EmployeeBonusExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		example.setOrderByClause(orderByClause);
		List<EmployeeBonus> bonusList = employeeBonusMapper.selectByExample(example);
		return bonusList;
	}
	
	public List<EmployeeBonus> getAllBonusByIdListWithOrderBy(List<Integer> idList, String orderByClause) {
		EmployeeBonusExample example = new EmployeeBonusExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andBonusidIn(idList);
		example.setOrderByClause(orderByClause);
		List<EmployeeBonus> bonusList = employeeBonusMapper.selectByExample(example);
		return bonusList;
	}
	
	public List<EmployeeBonus> getAllBonusByEmpIdWithOrderBy(Integer empId, String orderByClause) {
		EmployeeBonusExample example = new EmployeeBonusExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andEmployeeidEqualTo(empId);
		example.setOrderByClause(orderByClause);
		List<EmployeeBonus> bonusList = employeeBonusMapper.selectByExample(example);
		return bonusList;
	}
	
	public EmployeeSalary getSalaryById(Integer id) {
		EmployeeSalaryExample example = new EmployeeSalaryExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andSalaryidEqualTo(id);
		List<EmployeeSalary> salaryList = employeeSalaryMapper.selectByExample(example);
		if(salaryList != null && !salaryList.isEmpty()) {
			return salaryList.get(0);
		}
		return null;
	}
	
	public EmployeeBonus getBonusById(Integer id) {
		EmployeeBonusExample example = new EmployeeBonusExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andBonusidEqualTo(id);
		List<EmployeeBonus> bonusList = employeeBonusMapper.selectByExample(example);
		if(bonusList != null && !bonusList.isEmpty()) {
			return bonusList.get(0);
		}
		return null;
	}
	
	
	public void deleteSalary(Integer id) {
		employeeSalaryMapper.deleteByPrimaryKey(id);
	}
	
	public void deleteBonus(Integer id) {
		employeeBonusMapper.deleteByPrimaryKey(id);
	}
	
	public void saveSalary(EmployeeSalary salary) {
		employeeSalaryMapper.insert(salary);
	}
	
	public void saveBonus(EmployeeBonus bonus) {
		employeeBonusMapper.insert(bonus);
	}
	
	public void updateSalary(EmployeeSalary salary) {
		if(salary.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			employeeSalaryMapper.updateByPrimaryKeySelective(salary);
	}
	
	public void updateBonus(EmployeeBonus bonus) {
		if(bonus.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			employeeBonusMapper.updateByPrimaryKeySelective(bonus);
	}
}
