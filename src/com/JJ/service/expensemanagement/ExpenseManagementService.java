package com.JJ.service.expensemanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.expensemanagement.ExpenseStatusEnum;
import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.dao.ExpenseDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.model.ExpenseDbObject;
import com.JJ.model.ExpenseDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ExpenseManagementService {
	
	private ExpenseDbObjectMapper expenseDbObjectMapper;
	private ExpenseTypeLookup expenseTypeLookup;
	@Autowired
	public ExpenseManagementService(ExpenseDbObjectMapper expenseDbObjectMapper,
			ExpenseTypeLookup expenseTypeLookup) {
		this.expenseDbObjectMapper = expenseDbObjectMapper;
		this.expenseTypeLookup = expenseTypeLookup;
	}
		
	public List<ExpenseVO> getAllExpense() {
		ExpenseDbObjectExample expenseDbObjectExample = new ExpenseDbObjectExample();
		expenseDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ExpenseVO> expenseList = convertToExpenseVOList(expenseDbObjectMapper.selectByExample(expenseDbObjectExample));
		return expenseList;
	}
	
	public List<ExpenseVO> getAllExpense(Date startDate, Date endDate) {
		ExpenseDbObjectExample expenseDbObjectExample = new ExpenseDbObjectExample();
		expenseDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
		.andExpenseDateGreaterThanOrEqualTo(startDate).andExpenseDateLessThanOrEqualTo(endDate);
		expenseDbObjectExample.setOrderByClause("expense_date");
		List<ExpenseVO> expenseList = convertToExpenseVOList(expenseDbObjectMapper.selectByExample(expenseDbObjectExample));
		return expenseList;
	}
	
	public List<ExpenseVO> getAllExpenseExcludeParamType(Date startDate, Date endDate, List<Integer> typeList) {
		ExpenseDbObjectExample expenseDbObjectExample = new ExpenseDbObjectExample();
		expenseDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
		.andExpenseDateGreaterThanOrEqualTo(startDate).andExpenseDateLessThanOrEqualTo(endDate).andExpenseTypeIdNotIn(typeList);
		expenseDbObjectExample.setOrderByClause("expense_date");
		List<ExpenseVO> expenseList = convertToExpenseVOList(expenseDbObjectMapper.selectByExample(expenseDbObjectExample));
		return expenseList;
	}
	
	public List<ExpenseVO> getAllExpense(Date startDate, Date endDate, Integer type) {
		ExpenseDbObjectExample expenseDbObjectExample = new ExpenseDbObjectExample();
		expenseDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
		.andExpenseDateGreaterThanOrEqualTo(startDate).andExpenseDateLessThanOrEqualTo(endDate).andExpenseTypeIdEqualTo(type);
		expenseDbObjectExample.setOrderByClause("expense_date");
		List<ExpenseVO> expenseList = convertToExpenseVOList(expenseDbObjectMapper.selectByExample(expenseDbObjectExample));
		return expenseList;
	}
	
	public List<ExpenseVO> getAllExpenseByIdList(List<Integer> idList) {
		List<ExpenseVO> expenseList = new ArrayList<ExpenseVO>();
		if(idList != null && !idList.isEmpty()){
			ExpenseDbObjectExample example = new ExpenseDbObjectExample();
			example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andExpenseIdIn(idList);
			example.setOrderByClause("expense_date desc");
			expenseList.addAll(convertToExpenseVOList(expenseDbObjectMapper.selectByExample(example)));
		}
		return expenseList;
	}
	
	public List<String> getAllSupplier() {
		ExpenseDbObjectExample expenseDbObjectExample = new ExpenseDbObjectExample();
		expenseDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<ExpenseDbObject> expenseList = expenseDbObjectMapper.selectByExample(expenseDbObjectExample);
		Set<String> s = new HashSet<String>();
		for(ExpenseDbObject dbObj : expenseList) {
			if(dbObj.getSupplier() != null && !dbObj.getSupplier().isEmpty())
				s.add(dbObj.getSupplier());
		}
		return new ArrayList<String>(s);
	}
	
	public ExpenseVO findById(Integer id) {
		ExpenseDbObject expenseDbObject = expenseDbObjectMapper.selectByPrimaryKey(id);
		if(expenseDbObject != null && expenseDbObject.getExpenseId() != null){
			return convertToExpenseVOList(Arrays.asList(expenseDbObject)).get(0);
		}else{
			return new ExpenseVO();
		}
	}
	
	public void saveExpense(ExpenseVO expenseVO) {
		if(expenseVO != null){
			ExpenseDbObject dbObj = convertToExpenseDbObjectList(Arrays.asList(expenseVO)).get(0);
			dbObj.setStatus(ExpenseStatusEnum.UNPAID.toString());
			dbObj.setDeleteInd(GeneralUtils.NOT_DELETED);
			expenseDbObjectMapper.insert(dbObj);
			expenseVO.setExpenseId(dbObj.getExpenseId());
		}
	}
	
	public void saveExpenseList(List<ExpenseVO> expenseList) {
		for(ExpenseVO expense : expenseList)
			saveExpense(expense);
	}
	
	public void deleteExpense(Integer id) {
		deleteExpense(Arrays.asList(id));
	}
	
	public void deleteExpense(List<Integer> idList) {
		ExpenseDbObjectExample expenseDbObjectExample = new ExpenseDbObjectExample();
		expenseDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andExpenseIdIn(idList);
		ExpenseDbObject dbObj = new ExpenseDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		expenseDbObjectMapper.updateByExampleSelective(dbObj, expenseDbObjectExample);
	}
	
	public void updateExpense(ExpenseVO expenseVO) {
		expenseVO.setDeleteInd(GeneralUtils.NOT_DELETED);
		if(expenseVO != null && expenseVO.getDeleteInd() != null &&
				expenseVO.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			ExpenseDbObject dbObj = convertToExpenseDbObjectList(Arrays.asList(expenseVO)).get(0);
			expenseDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	private List<ExpenseVO> convertToExpenseVOList(List<ExpenseDbObject> expenseDbObjectList) {
		List<ExpenseVO> expenseVOList = new ArrayList<ExpenseVO>();
		if(expenseDbObjectList != null && expenseDbObjectList.size() > 0) {
			for(ExpenseDbObject dbObj : expenseDbObjectList) {
				ExpenseVO vo = new ExpenseVO();
				vo.setDescription(dbObj.getDescription());
				vo.setExpenseDate(dbObj.getExpenseDate());
				vo.setExpensedateString(GeneralUtils.convertDateToString(dbObj.getExpenseDate(), "dd/MM/yyyy"));
				vo.setExpenseId(dbObj.getExpenseId());
				vo.setexpensetype(expenseTypeLookup.getExpenseTypeById(dbObj.getExpenseTypeId()));
				vo.setExpenseTypeId(dbObj.getExpenseTypeId());
				vo.setInvoiceNo(dbObj.getInvoiceNo());
				vo.setRemarks(dbObj.getRemarks());
				vo.setStatus(dbObj.getStatus());
				vo.setSupplier(dbObj.getSupplier());
				vo.setTotalAmt(dbObj.getTotalAmt());
				String currency = "$";
				if(vo.getexpensetype().equals("Stock(China)"))
					currency = "¥";
				vo.setTotalAmtString(currency+vo.getTotalAmt());
				expenseVOList.add(vo);
			}
		}
		return expenseVOList;
	}
	
	private List<ExpenseDbObject> convertToExpenseDbObjectList(List<ExpenseVO> expenseVOList) {
		List<ExpenseDbObject> expenseDbObjectList = new ArrayList<ExpenseDbObject>();
		if(expenseVOList != null && expenseVOList.size() > 0){
			for(ExpenseVO vo : expenseVOList){
				ExpenseDbObject dbObj = new ExpenseDbObject();
				expenseDbObjectList.add(dbObj);
				dbObj.setDescription(vo.getDescription());
				dbObj.setExpenseDate(vo.getExpenseDate());
				dbObj.setExpenseId(vo.getExpenseId());
				dbObj.setExpenseTypeId(vo.getExpenseTypeId());
				dbObj.setInvoiceNo(vo.getInvoiceNo());
				dbObj.setRemarks(vo.getRemarks());
				dbObj.setStatus(vo.getStatus());
				dbObj.setSupplier(vo.getSupplier());
				dbObj.setTotalAmt(vo.getTotalAmt());
			}
		}
		return expenseDbObjectList;
	}

}
