package com.JJ.lookup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.JJ.lookupservice.ExpenseTypeService;
import com.JJ.model.ExpenseType;
@Lazy
@Component
public class ExpenseTypeLookup {
	private static final Logger logger = Logger.getLogger(ExpenseTypeLookup.class);
	private ExpenseTypeService expenseTypeService;
	private List<ExpenseType> expenseTypeList;
	private Map<String, ExpenseType> expenseTypeByValueMap = new HashMap<String, ExpenseType>();
	private Map<Integer, ExpenseType> expenseTypeByIdMap = new HashMap<Integer, ExpenseType>();
	private Map<String, String> expenseTypeMap = new LinkedHashMap<String,String>();
	
	@Autowired
	public ExpenseTypeLookup(ExpenseTypeService expenseTypeService){
		logger.debug("ExpenseTypeLookup initialized");
		this.expenseTypeService = expenseTypeService;
		load();
	}
	private void load() {
		expenseTypeList = expenseTypeService.getExpenseType();
		if(expenseTypeList != null){
			for(ExpenseType expenseType : expenseTypeList){
				expenseTypeByValueMap.put(expenseType.getExpensetype(), expenseType);
				expenseTypeByIdMap.put(expenseType.getExpensetypeid(), expenseType);
				expenseTypeMap.put(expenseType.getExpensetypeid().toString(), expenseType.getExpensetype());
			}
		}
	}
	public List<ExpenseType> getExpenseTypeList() {
		return expenseTypeList;
	}
	public void setExpenseTypeList(List<ExpenseType> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}
	public Map<String, ExpenseType> getExpenseTypeByValueMap() {
		return expenseTypeByValueMap;
	}
	public void setExpenseTypeByValueMap(Map<String, ExpenseType> expenseTypeByValueMap) {
		this.expenseTypeByValueMap = expenseTypeByValueMap;
	}
	public Map<Integer, ExpenseType> getExpenseTypeByIdMap() {
		return expenseTypeByIdMap;
	}
	public void setExpenseTypeByIdMap(Map<Integer, ExpenseType> expenseTypeByIdMap) {
		this.expenseTypeByIdMap = expenseTypeByIdMap;
	}
	public Map<String, String> getExpenseTypeMap() {
		return expenseTypeMap;
	}
	public void setExpenseTypeMap(Map<String, String> expenseTypeMap) {
		this.expenseTypeMap = expenseTypeMap;
	}
	
	public String getExpenseTypeById(Integer id){
		return expenseTypeByIdMap.get(id).getExpensetype();
	}
}
