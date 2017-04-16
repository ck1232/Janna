package com.JJ.lookupservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ExpenseTypeDbObjectMapper;
import com.JJ.lookup.VO.ExpenseTypeVO;
import com.JJ.model.ExpenseTypeDbObject;
import com.JJ.model.ExpenseTypeDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ExpenseTypeService {
	private ExpenseTypeDbObjectMapper expenseTypeMapper;
	
	@Autowired
	public ExpenseTypeService(ExpenseTypeDbObjectMapper expenseTypeMapper) {
		super();
		this.expenseTypeMapper = expenseTypeMapper;
	}
	public List<ExpenseTypeVO> getExpenseType(){
		ExpenseTypeDbObjectExample expenseTypeDbObjectExample = new ExpenseTypeDbObjectExample();
		return convertToExpenseTypeVOList(expenseTypeMapper.selectByExample(expenseTypeDbObjectExample));
	}

	private List<ExpenseTypeVO> convertToExpenseTypeVOList(List<ExpenseTypeDbObject> expenseTypeDbObjectList) {
		List<ExpenseTypeVO> expenseTypeVOList = new ArrayList<ExpenseTypeVO>();
		if(expenseTypeDbObjectList != null && expenseTypeDbObjectList.size() > 0) {
			for(ExpenseTypeDbObject dbObj : expenseTypeDbObjectList) {
				ExpenseTypeVO vo = new ExpenseTypeVO();
				vo.setDeleteInd(dbObj.getDeleteInd());;
				vo.setExpenseType(dbObj.getExpenseType());
				vo.setExpenseTypeId(dbObj.getExpenseTypeId());
				vo.setVersion(dbObj.getVersion());
				expenseTypeVOList.add(vo);
			}
		}
		return expenseTypeVOList;
	}
	
}
