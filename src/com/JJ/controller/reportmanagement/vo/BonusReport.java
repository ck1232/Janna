package com.JJ.controller.reportmanagement.vo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.helper.ReportUtils;
import com.JJ.helper.vo.ExcelColumn.ColumnStyle;
import com.JJ.helper.vo.ReportMapping;
import com.JJ.lookup.PaymentModeLookup;
import com.JJ.lookup.vo.PaymentModeVO;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;
@Component
public class BonusReport implements ReportInterface {

	private SalaryBonusManagementService bonusService;
	private PaymentManagementService paymentService;
	private PaymentModeLookup paymentModeLookup;
	
	@Autowired
	public BonusReport(SalaryBonusManagementService bonusService,
			PaymentManagementService paymentService,
			PaymentModeLookup paymentModeLookup) {
		this.bonusService = bonusService;
		this.paymentService = paymentService;
		this.paymentModeLookup = paymentModeLookup;
	}

	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(dateAsOf);
	    int year = cal.get(Calendar.YEAR);
	    SalaryBonusReportVO salaryReportVo;
	    
	    List<SalaryBonusReportVO> paidBonusReportList = new ArrayList<SalaryBonusReportVO>();
		List<SalaryBonusReportVO> unpaidBonusReportList = new ArrayList<SalaryBonusReportVO>();
	    PaymentModeVO chequeModeVo = paymentModeLookup.getPaymentModeByValueMap().get("Cheque");
		List<SalaryBonusVO> dbVoList = bonusService.getAllBonusVo();
		if(dbVoList != null && !dbVoList.isEmpty()) {
			for(SalaryBonusVO vo : dbVoList) {
				List<PaymentDetailVO> paymentDetailList = paymentService.getAllPaymentByRefTypeAndRefId("bonus", vo.getId(), dateAsOf, endDate);
				
				if(paymentDetailList != null && !paymentDetailList.isEmpty()) {
					for(PaymentDetailVO paymentVO : paymentDetailList) {
						salaryReportVo = new SalaryBonusReportVO();
						salaryReportVo.setSalarybonus(vo);
						if(paymentVO.getPaymentMode() == chequeModeVo.getPaymentModeId() && 
								(paymentVO.getBounceChequeInd() != null && paymentVO.getBounceChequeInd().equals("Y")))
							continue;
						if(dateAsOf.before(paymentVO.getPaymentDate()) && endDate.after(paymentVO.getPaymentDate())){
							salaryReportVo.setPaymentDetail(paymentVO);
							paidBonusReportList.add(salaryReportVo);
						}
					}
				}else{
					if((dateAsOf.before(vo.getDate()) || dateAsOf.equals(vo.getDate())) && (endDate.after(vo.getDate()) || endDate.equals(vo.getDate()))) {
						salaryReportVo = new SalaryBonusReportVO();
						salaryReportVo.setSalarybonus(vo);
						unpaidBonusReportList.add(salaryReportVo);
					}
				}
			}
		}
		ReportMapping reportMapping = new ReportMapping();
		reportMapping.addDateMonthYearMapping("Month", "salarybonus.date");
		reportMapping.addTextMapping("Name", "salarybonus.name");
		reportMapping.addTextMapping("Type", "salarybonus.employeeTypeString");
		reportMapping.addDateMapping("DOB", "salarybonus.dob");
		reportMapping.addTextMapping("Nationality", "salarybonus.nationality");
		reportMapping.addMoneyMapping("Bonus", "salarybonus.bonusAmt");
		reportMapping.addMoneyMapping("Employee CPF", "salarybonus.employeeCpf");
		reportMapping.addMoneyMapping("Employer CPF", "salarybonus.employerCpf");
		reportMapping.addMoneyMapping("Take Home Salary", "salarybonus.takehomeAmt");
		reportMapping.addTextMapping("Mode of Payment", "paymentDetail.paymentModeString");
		reportMapping.addTextMapping("Cheque No.", "paymentDetail.chequeNum");
		Sheet sheet = workbook.createSheet("Bonus");
		ReportUtils.writeRow(sheet, (year-1) + " Bonus paid in " + year + " (already recognise in " + (year-1) + " Income Statement)", 0, ColumnStyle.Bold);
		ReportUtils.writeData(sheet, paidBonusReportList, reportMapping, "");
		ReportUtils.writeBlankRows(sheet, 2);
		ReportUtils.writeRow(sheet, year + " Bonus not paid - To add as accruals as it will be paid in " + (year+1), 0, ColumnStyle.Bold);
		ReportUtils.writeData(sheet, unpaidBonusReportList, reportMapping, "");
		return workbook;
	}

}
