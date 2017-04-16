package com.JJ.service.reportmanagement;

import java.io.File;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.reportmanagement.ExpenseControlReportCriteria;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.service.reportmanagement.expensecontrol.ExcelFileHelper;

@Service
@Transactional
public class ReportManagementService {
	
	private ExcelFileHelper excelFileHelper;
	
	//@Autowired
	public ReportManagementService() {
	}
	
	public HSSFWorkbook writeToFile(File inputfile, List<SalaryBonusVO> bonusList, ExpenseControlReportCriteria reportCriteria) {
		excelFileHelper = new ExcelFileHelper();
		HSSFWorkbook wb = excelFileHelper.writeToFile(inputfile, bonusList, reportCriteria);
		return wb;
	}
	
	
	
}
