package com.JJ.controller.reportmanagement.vo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.helper.ReportUtils;
import com.JJ.helper.vo.ReportMapping;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;

public class BonusReport implements ReportInterface {

	private SalaryBonusManagementService bonusService;
	private PaymentManagementService paymentService;
	
	@Autowired
	public BonusReport(SalaryBonusManagementService bonusService,
			PaymentManagementService paymentService) {
		this.bonusService = bonusService;
		this.paymentService = paymentService;
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
		
		List<SalaryBonusVO> dbVoList = bonusService.getAllSalaryVo(dateAsOf, endDate);
		if(dbVoList != null && !dbVoList.isEmpty()) {
			List<SalaryReportVO> salaryReportList = new ArrayList<SalaryReportVO>();
			for(SalaryBonusVO vo : dbVoList) {
				List<PaymentDetailVO> paymentDetailList = paymentService.getAllPaymentByRefTypeAndRefId("salary", vo.getId());
				SalaryReportVO salaryReportVo;
				if(paymentDetailList != null && !paymentDetailList.isEmpty()) {
					for(PaymentDetailVO paymentVO : paymentDetailList) {
						salaryReportVo = new SalaryReportVO();
						salaryReportVo.setSalary(vo);
						if(paymentVO.getPaymentMode() == 2 && 
								(paymentVO.getBounceChequeInd() != null && paymentVO.getBounceChequeInd().equals("Y")))
							continue;
						salaryReportVo.setPaymentDetail(paymentVO);
						salaryReportList.add(salaryReportVo);
					}
				}else{
					salaryReportVo = new SalaryReportVO();
					salaryReportVo.setSalary(vo);
					salaryReportList.add(salaryReportVo);
				}
			}
			ReportMapping reportMapping = new ReportMapping();
			reportMapping.addDateMonthYearMapping("Month", "salary.date");
			reportMapping.addTextMapping("Name", "salary.name");
			reportMapping.addTextMapping("Type", "salary.employeeTypeString");
			reportMapping.addDateMapping("DOB", "salary.dob");
			reportMapping.addTextMapping("Nationality", "salary.nationality");
			reportMapping.addMoneyMapping("Amount", "salary.grossAmt");
			reportMapping.addMoneyMapping("Overtime", "salary.overTimeAmt");
			reportMapping.addMoneyMapping("Allowance", "salary.allowance");
			reportMapping.addMoneyMapping("Medical", "salary.medical");
			reportMapping.addMoneyMapping("Employee CPF", "salary.employeeCpf");
			reportMapping.addMoneyMapping("Employer CPF", "salary.employerCpf");
			reportMapping.addMoneyMapping("CDAC", "salary.cdacAmt");
			reportMapping.addMoneyMapping("SDL", "salary.sdlAmt");
			reportMapping.addMoneyMapping("Foreign Worker Levy", "salary.fwLevy");
			reportMapping.addMoneyMapping("Take Home Salary", "salary.takehomeAmt");
			reportMapping.addTextMapping("Mode of Payment", "paymentDetail.paymentModeString");
			reportMapping.addTextMapping("Cheque No.", "paymentDetail.chequeNum");
			Sheet sheet = workbook.createSheet("Salary");
			ReportUtils.writeData(sheet, salaryReportList, reportMapping);
		}
		return workbook;
	}

}
