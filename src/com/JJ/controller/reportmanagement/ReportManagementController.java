package com.JJ.controller.reportmanagement;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.reportmanagement.ReportManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/report")
public class ReportManagementController {
	private static final Logger logger = Logger.getLogger(ReportManagementController.class);
	
	private ReportManagementService reportManagementService;
	
	@Autowired
	public ReportManagementController(ReportManagementService reportManagementService) {
		this.reportManagementService = reportManagementService;
	}
	
	@RequestMapping(value = "/viewReportGen", method = RequestMethod.GET)
	public String viewReportGen(Model model) {
		//get list of years
		List<String> yearList = new ArrayList<String>();
		for(int i=0;i>-5;i--){
			yearList.add(GeneralUtils.convertDateToString(GeneralUtils.getNewDate(i), "yyyy"));
		}
		model.addAttribute("yearList", yearList);
		ExpenseControlReportCriteria reportCriteria = new ExpenseControlReportCriteria();
		model.addAttribute("expenseControlForm", reportCriteria);
		return "viewReportGen";
	}
	
	@RequestMapping(value = "/generateExpenseControlReport", method = RequestMethod.POST)
	public String generateExpenseControlReport(@ModelAttribute("expenseControlForm") ExpenseControlReportCriteria reportCriteria,
			Model model, HttpServletRequest request, HttpServletResponse response) {
		
		logger.debug("generateExpenseControlReport() : " + reportCriteria.toString());
		List<SalaryBonusVO> bonusList = new ArrayList<SalaryBonusVO>();
		downloadExcel(bonusList, reportCriteria, request, response);
		return null;
	}
	
	public void downloadExcel(List<SalaryBonusVO> bonusList, ExpenseControlReportCriteria reportCriteria,
			HttpServletRequest request, HttpServletResponse response) {
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/template/");
        File file = new File(dataDirectory+"/expense_control_template.xlsx");
        HSSFWorkbook wb = reportManagementService.writeToFile(file, bonusList, reportCriteria);
        if(wb != null){
        	response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=Expense_Control_"+reportCriteria.getYear()+".xls");
            try{
            	wb.write(response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}