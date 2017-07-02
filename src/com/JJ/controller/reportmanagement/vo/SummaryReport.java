package com.JJ.controller.reportmanagement.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.helper.ReportUtils;
import com.JJ.helper.vo.ExcelColumn.ColumnStyle;
import com.JJ.helper.vo.ReportMapping;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.paymentmanagement.PaymentManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;
@Component
public class SummaryReport implements ReportInterface {
	private static final Logger logger = Logger.getLogger(SummaryReport.class);

	private ExpenseManagementService expenseService;
	private PaymentManagementService paymentService;
	private SalaryBonusManagementService salaryService;
	
	private Sheet sheet;
	private List<ExpenseSummaryReportVO> expenseSummaryList;
	private List<PaymentSummaryReportVO> paymentSummaryList;
	private List<SalarySummaryReportVO> salarybonusSummaryList;
	private List<AcctPayableSummaryReportVO> accPayableSummaryList;
	private HashMap<String, ExpenseSummaryReportVO> expenseSummaryHashMap;
	private HashMap<String, PaymentSummaryReportVO> paymentSummaryHashMap;
	private HashMap<String, SalarySummaryReportVO> salarySummaryHashMap;
	private HashMap<String, AcctPayableSummaryReportVO> accPayableSummaryHashMap;
	
	private final static String monthFormat = "MMM";
	private final static String Total = "Total";
	private final static String Salary = "Salary";
	private final static String Bonus = "Bonus";
	public static final List<String> accPayableSummaryHeaders = Arrays.asList("Salary","Bonus","Total");
	
	@Autowired
	public SummaryReport(ExpenseManagementService expenseService,
			PaymentManagementService paymentService,
			SalaryBonusManagementService salaryService) {
		this.expenseService = expenseService;
		this.paymentService = paymentService;
		this.salaryService = salaryService;
	}

	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		//init
		initReport(workbook);
		generateExpensePaymentReport(dateAsOf, endDate);
		generateSalaryBonusReport(dateAsOf, endDate);
		generateAccPayableReport(dateAsOf, endDate);
		return workbook;
	}
	
	private void initReport(Workbook workbook){
		sheet = workbook.createSheet("Summary");
		expenseSummaryList = new ArrayList<ExpenseSummaryReportVO>();
		paymentSummaryList = new ArrayList<PaymentSummaryReportVO>();
		salarybonusSummaryList = new ArrayList<SalarySummaryReportVO>();
		accPayableSummaryList = new ArrayList<AcctPayableSummaryReportVO>();
		
		expenseSummaryHashMap = new HashMap<String, ExpenseSummaryReportVO>();
		paymentSummaryHashMap = new HashMap<String, PaymentSummaryReportVO>();
		salarySummaryHashMap = new HashMap<String, SalarySummaryReportVO>();
		accPayableSummaryHashMap = new HashMap<String, AcctPayableSummaryReportVO>();
		
		expenseSummaryHashMap.put(Total, new ExpenseSummaryReportVO(Total));
		paymentSummaryHashMap.put(Total, new PaymentSummaryReportVO(Total));
		
		salarySummaryHashMap.put(Salary, new SalarySummaryReportVO(Salary));
		salarySummaryHashMap.put(Bonus, new SalarySummaryReportVO(Bonus));
		salarySummaryHashMap.put(Total, new SalarySummaryReportVO(Total));
		accPayableSummaryHashMap.put(Total, new AcctPayableSummaryReportVO(Total));
	}


	private void generateExpensePaymentReport(Date dateAsOf, Date endDate) {
		List<ExpenseVO> dbVoList = expenseService.getAllExpenseExcludeParamType(dateAsOf, endDate, GeneralUtils.EXPENSE_TYPE_CHINA_STOCK);
		if(dbVoList != null && !dbVoList.isEmpty()) {
			for(ExpenseVO vo : dbVoList) {
				String expMonth = GeneralUtils.convertDateToString(vo.getExpenseDate(), monthFormat);
				if(!expenseSummaryHashMap.containsKey(expMonth)){
					expenseSummaryHashMap.put(expMonth, new ExpenseSummaryReportVO(expMonth));
				}
				addCurrentExpenseVO(expenseSummaryHashMap.get(expMonth),vo);
				addCurrentExpenseVO(expenseSummaryHashMap.get(Total),vo);
				List<PaymentDetailVO> paymentVOList = paymentService.getAllPaymentByRefTypeAndRefId("expense", vo.getExpenseId());
				if(!paymentVOList.isEmpty()){ //if paid
					for(PaymentDetailVO payment : paymentVOList){
						String payMonth = GeneralUtils.convertDateToString(payment.getPaymentDate(), monthFormat);
						if(!paymentSummaryHashMap.containsKey(payMonth)){
							paymentSummaryHashMap.put(payMonth, new PaymentSummaryReportVO(payMonth));
						}
						addPaymentForCurrentExpenseVO(paymentSummaryHashMap.get(payMonth), payment);
						addPaymentForCurrentExpenseVO(paymentSummaryHashMap.get(Total), payment);
					}
				}else{ //if unpaid
					if(!paymentSummaryHashMap.containsKey(expMonth)){
						paymentSummaryHashMap.put(expMonth, new PaymentSummaryReportVO(expMonth));
					}
					PaymentDetailVO payment = new PaymentDetailVO();
					payment.setPaymentAmt(vo.getTotalAmt());
					payment.setPaymentMode(0); //0 = unpaid
					addPaymentForCurrentExpenseVO(paymentSummaryHashMap.get(expMonth), payment);
					addPaymentForCurrentExpenseVO(paymentSummaryHashMap.get(Total), payment);
				}
			}
			expenseSummaryList.addAll(expenseSummaryHashMap.values());
			expenseSummaryList = GeneralUtils.sortByMonth(expenseSummaryList);
			paymentSummaryList.addAll(paymentSummaryHashMap.values());
			paymentSummaryList = GeneralUtils.sortByMonth(paymentSummaryList);
		}
		//Expense ReportMapping
		ReportUtils.writeBlankRows(sheet, 2);
		ReportUtils.writeRow(sheet, "Expenses by Type (exclude Salary)", 0, ColumnStyle.Bold);
		ReportUtils.writeData(sheet, expenseSummaryList, initExpenseReportMapping(), "month");		
		
		//Payment ReportMapping
		ReportUtils.writeBlankRows(sheet, 2);
		ReportUtils.writeRow(sheet, "Payment records (exclude salary)", 0, ColumnStyle.Bold);
		ReportUtils.writeData(sheet, paymentSummaryList, initPaymentReportMapping(), "month");	
	}
	
	private void generateSalaryBonusReport(Date dateAsOf, Date endDate) {
		List<SalaryBonusVO> salaryDbVoList = salaryService.getAllSalaryVo(dateAsOf, endDate);
		if(salaryDbVoList != null && !salaryDbVoList.isEmpty()) {
			for(SalaryBonusVO vo : salaryDbVoList) {
				addCurrentSalary(salarySummaryHashMap.get(Salary), vo);
				addCurrentSalary(salarySummaryHashMap.get(Total), vo);
			}
		}
		List<SalaryBonusVO> bonusDbVoList = salaryService.getAllBonusVo(dateAsOf, endDate);
		if(bonusDbVoList != null && !bonusDbVoList.isEmpty()) {
			for(SalaryBonusVO vo : bonusDbVoList) {
				addCurrentBonus(salarySummaryHashMap.get(Bonus), vo);
				addCurrentBonus(salarySummaryHashMap.get(Total), vo);
			}
		}
		salarybonusSummaryList.addAll(salarySummaryHashMap.values());	
		salarybonusSummaryList = GeneralUtils.sortAccordingToSortList(salarybonusSummaryList, accPayableSummaryHeaders, "month");
		//Salary ReportMapping
		ReportUtils.writeBlankRows(sheet, 2);
		ReportUtils.writeRow(sheet, "Salary and Bonus", 0, ColumnStyle.Bold);
		ReportUtils.writeData(sheet, salarybonusSummaryList, initSalaryBonusReportMapping(), "month");		
	}
	
	private void generateAccPayableReport(Date dateAsOf, Date endDate) {
		if(paymentSummaryList.isEmpty()) {
			List<ExpenseVO> dbVoList = expenseService.getAllExpenseExcludeParamType(dateAsOf, endDate, GeneralUtils.EXPENSE_TYPE_CHINA_STOCK);
			if(dbVoList != null && !dbVoList.isEmpty()) {
				for(ExpenseVO vo : dbVoList) {
					String expMonth = GeneralUtils.convertDateToString(vo.getExpenseDate(), monthFormat);
					List<PaymentDetailVO> paymentVOList = paymentService.getAllPaymentByRefTypeAndRefId("expense", vo.getExpenseId());
					if(paymentVOList.isEmpty()){ //if unpaid
						if(!paymentSummaryHashMap.containsKey(expMonth)){
							paymentSummaryHashMap.put(expMonth, new PaymentSummaryReportVO(expMonth));
						}
						PaymentDetailVO payment = new PaymentDetailVO();
						payment.setPaymentAmt(vo.getTotalAmt());
						payment.setPaymentMode(0);
						addPaymentForCurrentExpenseVO(paymentSummaryHashMap.get(expMonth), payment);
						addPaymentForCurrentExpenseVO(paymentSummaryHashMap.get(Total), payment);
					}
				}
				paymentSummaryList.addAll(paymentSummaryHashMap.values());
			}
		}
		
		for(PaymentSummaryReportVO paymentVO : paymentSummaryList) {
			String month = paymentVO.getMonth();
			if(month == null){
				logger.info("generateAccPayableReport - no month found in paymentVO");
				continue;
			}
			if(!accPayableSummaryHashMap.containsKey(month)) {
				accPayableSummaryHashMap.put(month, new AcctPayableSummaryReportVO(month));
			}
			addCurrentAccPayable(accPayableSummaryHashMap.get(month), paymentVO);
			addCurrentAccPayable(accPayableSummaryHashMap.get(Total), paymentVO);
		}
		accPayableSummaryList.addAll(accPayableSummaryHashMap.values());
		accPayableSummaryList = GeneralUtils.sortByMonth(accPayableSummaryList);
		
		//account payable ReportMapping
		ReportUtils.writeBlankRows(sheet, 2);
		ReportUtils.writeRow(sheet, "Accounts Payable", 0, ColumnStyle.Bold);
		ReportUtils.writeData(sheet, accPayableSummaryList, initAccPayableReportMapping(), "month");
	}
	

	private ReportMapping initExpenseReportMapping() {
		ReportMapping reportMapping = new ReportMapping();
		reportMapping.addTextMapping("", "month");
		reportMapping.addMoneyMapping("Stock", "stockAmt");
		reportMapping.addMoneyMapping("Sub-Con", "subConAmt");
		reportMapping.addMoneyMapping("Vehicle - Fuel", "vehiclefuelAmt");
		reportMapping.addMoneyMapping("Vehicle - Road Tax", "vehicleRoadTaxAmt");
		reportMapping.addMoneyMapping("Vehicle - Repair", "vehicleRepairAmt");
		reportMapping.addMoneyMapping("Vehicle - Car Parking and ERP", "vehicleParkingERPAmt");
		reportMapping.addMoneyMapping("Vehicle - Insurance", "vehicleInsuranceAmt");
		reportMapping.addMoneyMapping("Office Expenses", "officeExpenseAmt");
		reportMapping.addMoneyMapping("Asset - Equipment", "assetEquipmentAmt");
		reportMapping.addMoneyMapping("Asset - Vehicle", "assetVehicleAmt");
		reportMapping.addMoneyMapping("Rent Expenses", "rentExpenseAmt");
		reportMapping.addMoneyMapping("Meal Expenses", "mealExpenseAmt");
		reportMapping.addMoneyMapping("Entertainment", "entertainmentAmt");
		reportMapping.addMoneyMapping("Fees and Taxes", "feeTaxesAmt");
		reportMapping.addMoneyMapping("Total", "totalAmt");
		return reportMapping;
	}
	
	private ReportMapping initPaymentReportMapping() {
		ReportMapping reportMapping = new ReportMapping();
		reportMapping.addTextMapping("", "month");
		reportMapping.addMoneyMapping("Cash", "cashAmt");
		reportMapping.addMoneyMapping("Cheque", "chequeAmt");
		reportMapping.addMoneyMapping("Giro", "giroAmt");
		reportMapping.addMoneyMapping("Paid by Director", "paidByDirectorAmt");
		reportMapping.addMoneyMapping("Not Paid", "notPaidAmt");
		reportMapping.addMoneyMapping("Total", "totalAmt");
		return reportMapping;
	}
	
	private ReportMapping initSalaryBonusReportMapping() {
		ReportMapping reportMapping = new ReportMapping();
		reportMapping.addTextMapping("", "month");
		reportMapping.addMoneyMapping("Gross Salary", "grossSalaryAmt");
		reportMapping.addMoneyMapping("Overtime", "overtimeAmt");
		reportMapping.addMoneyMapping("Bonus", "bonusAmt");
		reportMapping.addMoneyMapping("Allowance", "allowanceAmt");
		reportMapping.addMoneyMapping("Medical", "medicalAmt");
		reportMapping.addMoneyMapping("Employee CPF", "employeeCPFAmt");
		reportMapping.addMoneyMapping("Salary Paid", "salaryPaidAmt");
		reportMapping.addMoneyMapping("Employer CPF", "employerCPFAmt");
		reportMapping.addMoneyMapping("CDAC", "cdacAmt");
		reportMapping.addMoneyMapping("SDL", "sdlAmt");
		reportMapping.addMoneyMapping("Foreign Worker Levy", "fwlAmt");
		reportMapping.addMoneyMapping("Total remuneration", "totalRemuneration");
		return reportMapping;
	}
	
	private ReportMapping initAccPayableReportMapping() {
		ReportMapping reportMapping = new ReportMapping();
		reportMapping.addTextMapping("", "month");
		reportMapping.addMoneyMapping("From expenses other than RMB purchases", "expensePurchaseAmt");
		return reportMapping;
	}


	private void addCurrentExpenseVO(ExpenseSummaryReportVO expenseSummary, ExpenseVO vo) {
		expenseSummary.setTotalAmt(expenseSummary.getTotalAmt().add(vo.getTotalAmt()));
		switch (vo.getExpenseTypeId()) {
		case 1: //Stock
			expenseSummary.setStockAmt(expenseSummary.getStockAmt().add(vo.getTotalAmt()));
			return;
		case 2: //Sub-Con
			expenseSummary.setSubConAmt(expenseSummary.getSubConAmt().add(vo.getTotalAmt()));
			return;
		case 3: //Vehicle-Fuel
			expenseSummary.setVehicleFuelAmt(expenseSummary.getVehicleFuelAmt().add(vo.getTotalAmt()));
			return;
		case 4: //Vehicle-Road Tax
			expenseSummary.setVehicleRoadTaxAmt(expenseSummary.getVehicleRoadTaxAmt().add(vo.getTotalAmt()));
			return;
		case 5: //Vehicle-Repair
			expenseSummary.setVehicleRepairAmt(expenseSummary.getVehicleRepairAmt().add(vo.getTotalAmt()));
			return;
		case 6: //Vehicle-Car Parking and ERP
			expenseSummary.setVehicleParkingERPAmt(expenseSummary.getVehicleParkingERPAmt().add(vo.getTotalAmt()));
			return;
		case 7: //Vehicle-Insurance
			expenseSummary.setVehicleInsuranceAmt(expenseSummary.getVehicleInsuranceAmt().add(vo.getTotalAmt()));
			return;
		case 8: //Office Expenses
			expenseSummary.setOfficeExpenseAmt(expenseSummary.getOfficeExpenseAmt().add(vo.getTotalAmt()));
			return;
		case 9: //Asset-Equipment
			expenseSummary.setAssetEquipmentAmt(expenseSummary.getAssetEquipmentAmt().add(vo.getTotalAmt()));
			return;
		case 10: //Asset-Vehicle
			expenseSummary.setAssetVehicleAmt(expenseSummary.getAssetVehicleAmt().add(vo.getTotalAmt()));
			return;
		case 11: //Rent Expenses
			expenseSummary.setRentExpenseAmt(expenseSummary.getRentExpenseAmt().add(vo.getTotalAmt()));
			return;
		case 12: //Meal Expenses
			expenseSummary.setMealExpenseAmt(expenseSummary.getMealExpenseAmt().add(vo.getTotalAmt()));
			return;
		case 13: //Entertainment
			expenseSummary.setEntertainmentAmt(expenseSummary.getEntertainmentAmt().add(vo.getTotalAmt()));
			return;
		case 14: //Fees and Taxes
			expenseSummary.setFeeTaxesAmt(expenseSummary.getFeeTaxesAmt().add(vo.getTotalAmt()));
			return;
		default:
			return;
		}
	}
	
	private void addPaymentForCurrentExpenseVO(PaymentSummaryReportVO paymentSummaryReportVO, PaymentDetailVO vo) {
		paymentSummaryReportVO.setTotalAmt(paymentSummaryReportVO.getTotalAmt().add(vo.getPaymentAmt()));
		switch (vo.getPaymentMode()) {
		case 1: //Cash
			paymentSummaryReportVO.setCashAmt(paymentSummaryReportVO.getCashAmt().add(vo.getPaymentAmt()));
			return;
		case 2: //Cheque
			paymentSummaryReportVO.setChequeAmt(paymentSummaryReportVO.getChequeAmt().add(vo.getPaymentAmt()));
			return;
		case 3: //Pay By Director
			paymentSummaryReportVO.setPaidByDirectorAmt(paymentSummaryReportVO.getPaidByDirectorAmt().add(vo.getPaymentAmt()));
			return;
		case 5: //GIRO
			paymentSummaryReportVO.setGiroAmt(paymentSummaryReportVO.getGiroAmt().add(vo.getPaymentAmt()));
			return;	
		default:
			paymentSummaryReportVO.setNotPaidAmt(paymentSummaryReportVO.getNotPaidAmt().add(vo.getPaymentAmt()));
			return;
		}
		
	}
	
	private void addCurrentSalary(SalarySummaryReportVO reportVO, SalaryBonusVO vo) {
		BigDecimal total = BigDecimal.ZERO;
		if(vo.getGrossAmt() != null) 
			reportVO.setGrossSalaryAmt(reportVO.getGrossSalaryAmt().add(vo.getGrossAmt()));
		
		if(vo.getOverTimeAmt() != null)
			reportVO.setOvertimeAmt(reportVO.getOvertimeAmt().add(vo.getOverTimeAmt()));
		
		if(vo.getAllowance() != null) 
			reportVO.setAllowanceAmt(reportVO.getAllowanceAmt().add(vo.getAllowance()));
		
		if(vo.getMedical() != null) 
			reportVO.setMedicalAmt(reportVO.getMedicalAmt().add(vo.getMedical()));
		
		if(vo.getEmployeeCpf() != null) 
			reportVO.setEmployeeCPFAmt(reportVO.getEmployeeCPFAmt().add(vo.getEmployeeCpf()));
		
		if(vo.getTakehomeAmt() != null) {
			reportVO.setSalaryPaidAmt(reportVO.getSalaryPaidAmt().add(vo.getTakehomeAmt()));
			total = total.add(vo.getTakehomeAmt());
		}
		if(vo.getEmployerCpf() != null) {
			reportVO.setEmployerCPFAmt(reportVO.getEmployerCPFAmt().add(vo.getEmployerCpf()));
			total = total.add(vo.getEmployerCpf());
		}
		if(vo.getCdacAmt() != null) {
			reportVO.setCdacAmt(reportVO.getCdacAmt().add(vo.getCdacAmt()));
			total = total.add(vo.getCdacAmt());
		}
		if(vo.getSdlAmt() != null) {
			reportVO.setSdlAmt(reportVO.getSdlAmt().add(vo.getSdlAmt()));
			total = total.add(vo.getSdlAmt());
		}
		if(vo.getFwLevy() != null) {
			reportVO.setFwlAmt(reportVO.getFwlAmt().add(vo.getFwLevy()));
			total = total.add(vo.getFwLevy());
		}
		reportVO.setTotalRemuneration(reportVO.getTotalRemuneration().add(total));
	}
	
	private void addCurrentBonus(SalarySummaryReportVO reportVO, SalaryBonusVO vo) {
		BigDecimal total = BigDecimal.ZERO;
		if(vo.getBonusAmt() != null) {
			reportVO.setBonusAmt(reportVO.getBonusAmt().add(vo.getBonusAmt()));
		}
		if(vo.getEmployeeCpf() != null) {
			reportVO.setEmployeeCPFAmt(reportVO.getEmployeeCPFAmt().add(vo.getEmployeeCpf()));
		}
		if(vo.getTakehomeAmt() != null) {
			reportVO.setTotalRemuneration(reportVO.getTotalRemuneration().add(total));
			total = total.add(vo.getTakehomeAmt());
		}
		if(vo.getEmployerCpf() != null) {
			reportVO.setEmployerCPFAmt(reportVO.getEmployerCPFAmt().add(vo.getEmployerCpf()));
			total = total.add(vo.getEmployerCpf());
		}
		reportVO.setTotalRemuneration(reportVO.getTotalRemuneration().add(total));
	}
	
	private void addCurrentAccPayable(AcctPayableSummaryReportVO reportVO, PaymentSummaryReportVO paymentVO) {
		if(paymentVO.getNotPaidAmt() != null) {
			reportVO.setExpensePurchaseAmt(paymentVO.getNotPaidAmt());
		}
	}
}
