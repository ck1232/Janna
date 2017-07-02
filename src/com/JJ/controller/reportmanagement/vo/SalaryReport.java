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
import com.JJ.helper.vo.ReportMapping;
import com.JJ.lookup.PaymentModeLookup;
import com.JJ.lookup.vo.PaymentModeVO;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;
@Component
public class SalaryReport implements ReportInterface {
	
	private SalaryBonusManagementService salaryService;
	private PaymentManagementService paymentService;
	private PaymentModeLookup paymentModeLookup;
	
	@Autowired
	public SalaryReport(SalaryBonusManagementService salaryService,
			PaymentManagementService paymentService,
			PaymentModeLookup paymentModeLookup) {
		this.salaryService = salaryService;
		this.paymentService = paymentService;
		this.paymentModeLookup = paymentModeLookup;
	}



	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		
		Calendar firstDay = Calendar.getInstance();
		firstDay.setTime(dateAsOf);
		firstDay.set(Calendar.DAY_OF_MONTH, firstDay.getActualMinimum(Calendar.DAY_OF_MONTH));
		dateAsOf = firstDay.getTime();
		
		Calendar lastDay = Calendar.getInstance();
		lastDay.setTime(endDate);
		lastDay.set(Calendar.DAY_OF_MONTH, lastDay.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate = lastDay.getTime();
		
		PaymentModeVO chequeModeVo = paymentModeLookup.getPaymentModeByValueMap().get("Cheque");
		
		List<SalaryBonusVO> dbVoList = salaryService.getAllSalaryVo(dateAsOf, endDate);
		if(dbVoList != null && !dbVoList.isEmpty()) {
			List<SalaryBonusReportVO> salaryReportList = new ArrayList<SalaryBonusReportVO>();
			for(SalaryBonusVO vo : dbVoList) {
				List<PaymentDetailVO> paymentDetailList = paymentService.getAllPaymentByRefTypeAndRefId("salary", vo.getId());
				SalaryBonusReportVO salaryReportVo;
				if(paymentDetailList != null && !paymentDetailList.isEmpty()) {
					for(PaymentDetailVO paymentVO : paymentDetailList) {
						salaryReportVo = new SalaryBonusReportVO();
						salaryReportVo.setSalarybonus(vo);
						if(paymentVO.getPaymentMode() == chequeModeVo.getPaymentModeId() && 
								(paymentVO.getBounceChequeInd() != null && paymentVO.getBounceChequeInd().equals("Y")))
							continue;
						salaryReportVo.setPaymentDetail(paymentVO);
						salaryReportList.add(salaryReportVo);
					}
				}else{
					salaryReportVo = new SalaryBonusReportVO();
					salaryReportVo.setSalarybonus(vo);
					salaryReportList.add(salaryReportVo);
				}
			}
			ReportMapping reportMapping = new ReportMapping();
			reportMapping.addDateMonthYearMapping("Month", "salarybonus.date");
			reportMapping.addTextMapping("Name", "salarybonus.name");
			reportMapping.addTextMapping("Type", "salarybonus.employeeTypeString");
			reportMapping.addDateMapping("DOB", "salarybonus.dob");
			reportMapping.addTextMapping("Nationality", "salarybonus.nationality");
			reportMapping.addMoneyMapping("Amount", "salarybonus.grossAmt");
			reportMapping.addMoneyMapping("Overtime", "salarybonus.overTimeAmt");
			reportMapping.addMoneyMapping("Allowance", "salarybonus.allowance");
			reportMapping.addMoneyMapping("Medical", "salarybonus.medical");
			reportMapping.addMoneyMapping("Employee CPF", "salarybonus.employeeCpf");
			reportMapping.addMoneyMapping("Employer CPF", "salarybonus.employerCpf");
			reportMapping.addMoneyMapping("CDAC", "salarybonus.cdacAmt");
			reportMapping.addMoneyMapping("SDL", "salarybonus.sdlAmt");
			reportMapping.addMoneyMapping("Foreign Worker Levy", "salarybonus.fwLevy");
			reportMapping.addMoneyMapping("Take Home Salary", "salarybonus.takehomeAmt");
			reportMapping.addTextMapping("Mode of Payment", "paymentDetail.paymentModeString");
			reportMapping.addTextMapping("Cheque No.", "paymentDetail.chequeNum");
			Sheet sheet = workbook.createSheet("Salary");
			ReportUtils.writeData(sheet, salaryReportList, reportMapping, "");
		}
		return workbook;
	}
	
}
