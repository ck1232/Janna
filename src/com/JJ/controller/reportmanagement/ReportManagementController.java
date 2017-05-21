package com.JJ.controller.reportmanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.controller.reportmanagement.vo.ExpenseReport;
import com.JJ.controller.reportmanagement.vo.ReportInterface;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.reportmanagement.ReportManagementService;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/report")
public class ReportManagementController {
	private static final Logger logger = Logger.getLogger(ReportManagementController.class);
	
	private ReportManagementService reportManagementService;
	private ExpenseReport expenseReport;
	@Autowired
	public ReportManagementController(ReportManagementService reportManagementService, ExpenseReport expenseReport) {
		this.reportManagementService = reportManagementService;
		this.expenseReport = expenseReport;
	}
	
	@RequestMapping(value = "/viewReportGen", method = RequestMethod.GET)
	public String viewReportGen(Model model) {
		//get list of years
//		List<String> yearList = new ArrayList<String>();
//		for(int i=0;i>-5;i--){
//			yearList.add(GeneralUtils.convertDateToString(GeneralUtils.getNewDate(i), "yyyy"));
//		}
//		model.addAttribute("yearList", yearList);
		ExpenseControlReportCriteria reportCriteria = new ExpenseControlReportCriteria();
		List<String> allReportTypeList = new ArrayList<String>();
		if(ReportTypeEnum.values().length > 0){
			for(ReportTypeEnum reportType:ReportTypeEnum.values()){
				allReportTypeList.add(reportType.getName());
			}
		}
		
		model.addAttribute("expenseControlForm", reportCriteria);
		model.addAttribute("reportList", allReportTypeList);
		return "viewReportGen";
	}
	
	@RequestMapping(value = "/generateExpenseControlReport", method = RequestMethod.POST)
	public String generateExpenseControlReport(@ModelAttribute("expenseControlForm") ExpenseControlReportCriteria reportCriteria,
			Model model, HttpServletRequest request, HttpServletResponse response) {
		
		logger.debug("generateExpenseControlReport() : " + reportCriteria.toString());
		reportCriteria.setStartDate(GeneralUtils.convertStringToDate(reportCriteria.getStartdateString(), GeneralUtils.STANDARD_DATE_FORMAT));
		reportCriteria.setEndDate(GeneralUtils.convertStringToDate(reportCriteria.getEnddateString(), GeneralUtils.STANDARD_DATE_FORMAT));
		if(reportCriteria != null && reportCriteria.getType()!= null 
				&& reportCriteria.getType().size() > 0){
			List<ReportTypeEnum> enumList = new ArrayList<ReportTypeEnum>();
			for(String reportType :reportCriteria.getType()){
				ReportTypeEnum reportEnum = ReportTypeEnum.getEnumFromName(reportType);
				if(reportEnum != null){
					enumList.add(reportEnum);
				}
			}
			
			List<ReportInterface> reportControllerList = getReportController(enumList);
			//create a blank workbook
			Workbook wb = new HSSFWorkbook();
			//generate report
			for(ReportInterface report :reportControllerList){
				wb = report.exportReport(wb, reportCriteria.getStartDate(), reportCriteria.getEndDate(), null);
			}
			
			downloadExcel(wb, request, response);
		}
		return null;
	}
	
	private List<ReportInterface> getReportController(List<ReportTypeEnum> enumList) {
		List<ReportInterface> list = new ArrayList<ReportInterface>();
		if(enumList != null && enumList.size() > 0){
			for(ReportTypeEnum typeEnum : enumList){
				switch (typeEnum) {
				case EXPENSE:
					list.add(expenseReport);
					break;
				case BONUS:
					break;
				case CHINA_STOCK:
					break;
				case GRANT:
					break;
				case INVOICE:
					break;
				case SALARY:
					break;
				case SUMMARY:
					break;
				default:
					break;
				}
			}
		}
		return list;
	}

	public void downloadExcel(Workbook wb, HttpServletRequest request, HttpServletResponse response) {
        if(wb != null){
        	response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment; filename=Expense_Control_"+ "2017"/*reportCriteria.getYear()*/+".xls");
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