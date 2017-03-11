package com.JJ.service.salarybonusmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVo;
import com.JJ.dao.EmployeeBonusMapper;
import com.JJ.dao.EmployeeSalaryMapper;
import com.JJ.helper.GeneralUtils;
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
		salaryBonusVoList.addAll(convertSalaryToVo(salaryList));
		List<EmployeeBonus> bonusList = getAllBonus();
		salaryBonusVoList.addAll(convertBonusToVo(bonusList));
		return salaryBonusVoList;
	}
	
	//convert EmployeeSalary to SalaryBonusVo
	public List<SalaryBonusVo> convertSalaryToVo(List<EmployeeSalary> salaryList) {
		List<SalaryBonusVo> salaryBonusVoList = new ArrayList<SalaryBonusVo>();
		if(salaryList != null && salaryList.size() > 0) {
			for(EmployeeSalary salary : salaryList) {
				SalaryBonusVo vo = new SalaryBonusVo();
				vo.setId(salary.getSalaryid());
				vo.setDate(salary.getSalarydate());
				vo.setDateString(GeneralUtils.convertDateToString(salary.getSalarydate(), "MMM-yyyy"));
				vo.setEmployee(employeeManagementService.findById(salary.getEmployeeid()));
				vo.setGrossamount(calculateGrossAmount(salary));
				vo.setTakehomeamount(calculateTakeHomeAmount(vo, salary));
				vo.setType(GeneralUtils.TYPE_SALARY);
				vo.setStatus(salary.getStatus());
				salaryBonusVoList.add(vo);
			}
		}
		return salaryBonusVoList;
	}
	
	//convert EmployeeBonus to SalaryBonusVo
	public List<SalaryBonusVo> convertBonusToVo(List<EmployeeBonus> bonusList) {
		List<SalaryBonusVo> salaryBonusVoList = new ArrayList<SalaryBonusVo>();
		if(bonusList != null && bonusList.size() > 0) {
			for(EmployeeBonus bonus : bonusList) {
				SalaryBonusVo vo = new SalaryBonusVo();
				vo.setId(bonus.getBonusid());
				vo.setDate(bonus.getBonusdate());
				vo.setDateString(GeneralUtils.convertDateToString(bonus.getBonusdate(), "MMM-yyyy"));
				vo.setEmployee(employeeManagementService.findById(bonus.getEmployeeid()));
				vo.setBonusamount(bonus.getBonusamount());
				vo.setType(GeneralUtils.TYPE_BONUS);
				vo.setStatus(bonus.getStatus());
				salaryBonusVoList.add(vo);
			}
		}
		return salaryBonusVoList;
	}
	
	//calculate gross amount from EmployeeSalary
	//gross amount = basic salary amount + overtime amount + allowance
	private BigDecimal calculateGrossAmount(EmployeeSalary salary) {
		BigDecimal grossamount = BigDecimal.ZERO;
		grossamount = grossamount.add(salary.getBasicsalaryamount());
		grossamount = grossamount.add(salary.getOvertimeamount());
		grossamount = grossamount.add(salary.getAllowance());
		return grossamount;
	}
	
	//calculate take home amount from EmployeeSalary and gross amount
	//take home amount = gross amount - employee cpf - cdac amount
	private BigDecimal calculateTakeHomeAmount(SalaryBonusVo vo, EmployeeSalary salary) {
		BigDecimal takehomeamount = vo.getGrossamount();
		takehomeamount = takehomeamount.subtract(salary.getEmployeecpf());
		takehomeamount = takehomeamount.subtract(salary.getCdacamount());
		return takehomeamount;
	}
	
	//get all salary from salary table 
	//not deleted
	public List<EmployeeSalary> getAllSalary() {
		EmployeeSalaryExample example = new EmployeeSalaryExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<EmployeeSalary> salaryList = employeeSalaryMapper.selectByExample(example);
		return salaryList;
	}
	
	//get all bonus from bonus table 
	//not deleted
	public List<EmployeeBonus> getAllBonus() {
		EmployeeBonusExample example = new EmployeeBonusExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<EmployeeBonus> bonusList = employeeBonusMapper.selectByExample(example);
		return bonusList;
	}
		
	/* Expense START */
	/*public List<Expense> getAllExpense() {
		ExpenseExample example = new ExpenseExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		List<Expense> expenseList = expenseMapper.selectByExample(example);
		return expenseList;
	}
	
	public List<Expense> getAllExpenseByIdList(List<Integer> idList) {
		ExpenseExample example = new ExpenseExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andExpenseidIn(idList);
		List<Expense> expenseList = expenseMapper.selectByExample(example);
		return expenseList;
	}
	
	public Expense findById(Integer id) {
		ExpenseExample example = new ExpenseExample();
		example.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andExpenseidEqualTo(id);
		List<Expense> expenseList = expenseMapper.selectByExample(example);
		if(expenseList != null && expenseList.size() > 0) {
			return expenseList.get(0);
		}
		return null;
	}
	
	public void saveExpense(Expense expense) {
		expenseMapper.insert(expense);
	}
	
	public void saveExpenseList(List<Expense> expenseList) {
		for(Expense expense : expenseList)
			saveExpense(expense);
	}
	
	public void deleteExpense(Integer id) {
		expenseMapper.deleteByPrimaryKey(id);
	}
	
	public void deleteExpenseList(List<Integer> idList) {
		for(Integer id : idList)
			deleteExpense(id);
	}
	
	public void updateExpense(Expense expense) {
		if(expense.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			expenseMapper.updateByPrimaryKeySelective(expense);
	}*/
	/* Expense END */
	
	
}
