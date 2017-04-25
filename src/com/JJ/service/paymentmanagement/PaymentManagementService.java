package com.JJ.service.paymentmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.chequemanagement.vo.ChequeVO;
import com.JJ.controller.expensemanagement.ExpenseStatusEnum;
import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.controller.invoicemanagement.InvoiceStatusEnum;
import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.controller.paymentmanagement.PaymentManagementController;
import com.JJ.controller.paymentmanagement.vo.PaymentDetailVO;
import com.JJ.controller.paymentmanagement.vo.PaymentRsVO;
import com.JJ.controller.paymentmanagement.vo.PaymentVO;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;
import com.JJ.dao.ChequeDbObjectMapper;
import com.JJ.dao.PaymentDetailDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.lookup.ExpenseTypeLookup;
import com.JJ.lookup.PaymentModeLookup;
import com.JJ.model.ChequeDbObject;
import com.JJ.model.PaymentDetailDbObject;
import com.JJ.model.PaymentDetailDbObjectExample;
import com.JJ.service.chequemanagement.ChequeManagementService;
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.grantmanagement.GrantManagementService;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class PaymentManagementService {
	
	private PaymentDetailDbObjectMapper paymentDetailDbObjectMapper;
	private ChequeDbObjectMapper chequeDbObjectMapper;
	private ExpenseTypeLookup expenseTypeLookup;
	private ExpenseManagementService expenseManagementService;
	private InvoiceManagementService invoiceManagementService;
	private GrantManagementService grantManagementService;
	private SalaryBonusManagementService salaryBonusManagementService;
	private ChequeManagementService chequeManagementService;
	private PaymentRSManagementService paymentRSManagementService;
	private PaymentModeLookup paymentModeLookup;
	
	@Autowired
	public PaymentManagementService(PaymentDetailDbObjectMapper paymentDetailMapper,
			ChequeDbObjectMapper chequeDbObjectMapper,
			ExpenseTypeLookup expenseTypeLookup,  
			ExpenseManagementService expenseManagementService, 
			InvoiceManagementService invoiceManagementService,
			GrantManagementService grantManagementService,
			SalaryBonusManagementService salaryBonusManagementService,
			ChequeManagementService chequeManagementService,
			PaymentRSManagementService paymentRSManagementService,
			PaymentModeLookup paymentModeLookup) {
		this.paymentDetailDbObjectMapper = paymentDetailMapper;
		this.chequeDbObjectMapper = chequeDbObjectMapper;
		this.expenseTypeLookup = expenseTypeLookup;
		this.expenseManagementService = expenseManagementService;
		this.invoiceManagementService = invoiceManagementService;
		this.grantManagementService = grantManagementService;
		this.salaryBonusManagementService = salaryBonusManagementService;
		this.chequeManagementService = chequeManagementService;
		this.paymentRSManagementService = paymentRSManagementService;
		this.paymentModeLookup = paymentModeLookup;
	}
	public void saveExpensePayment(PaymentVO paymentVo, List<Integer> expenseidList) {
		List<ExpenseVO> expenseList = expenseManagementService.getAllExpenseByIdList(expenseidList);
		List<PaymentDetailVO> paymentDetailList = genPaymentDetail(paymentVo);
		
		for(PaymentDetailVO paymentdetail : paymentDetailList) {
			for(ExpenseVO expense : expenseList) {
				expense.setexpensetype(expenseTypeLookup.getExpenseTypeById(expense.getExpenseTypeId()));
				PaymentRsVO paymentRsVO = new PaymentRsVO();
				paymentRsVO.setReferenceType(GeneralUtils.MODULE_EXPENSE);
				paymentRsVO.setReferenceId(expense.getExpenseId());
				paymentRsVO.setPaymentDetailId(paymentdetail.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				if(expense.getexpensetype().toLowerCase().contains(GeneralUtils.KEYWORD_STOCK_CHINA))
					expense.setStatus(ExpenseStatusEnum.UNPAID.toString());
				else
					expense.setStatus(ExpenseStatusEnum.PAID.toString());
				expenseManagementService.updateExpense(expense);
			}
		}
	}
	
	public void saveInvoicePayment(PaymentVO paymentVo, List<Integer> invoiceidList) {
		List<InvoiceVO> invoiceList = invoiceManagementService.getAllInvoiceByIdList(invoiceidList);
		List<PaymentDetailVO> paymentDetailVOList = genPaymentDetail(paymentVo);
		
		for(PaymentDetailVO paymentdetail : paymentDetailVOList) {
			for(InvoiceVO invoice : invoiceList) {
				PaymentRsVO paymentRsVO = new PaymentRsVO();
				paymentRsVO.setReferenceType(GeneralUtils.MODULE_INVOICE);
				paymentRsVO.setReferenceId(invoice.getInvoiceId());
				paymentRsVO.setPaymentDetailId(paymentdetail.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				
				invoice.setStatus(InvoiceStatusEnum.PAID.toString());
				invoiceManagementService.updateInvoice(invoice);
			}
		}
	}
	
	public void saveGrantPayment(PaymentVO paymentVo, List<Integer> grantidList) {
		List<InvoiceVO> grantList = grantManagementService.getAllGrantByIdList(grantidList);
		List<PaymentDetailVO> paymentDetailVOList = genPaymentDetail(paymentVo);
		
		for(PaymentDetailVO paymentdetail : paymentDetailVOList) {
			for(InvoiceVO grant : grantList) {
				PaymentRsVO paymentRsVO = new PaymentRsVO();
				paymentRsVO.setReferenceType(GeneralUtils.MODULE_GRANT);
				paymentRsVO.setReferenceId(grant.getGrantId());
				paymentRsVO.setPaymentDetailId(paymentdetail.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				
				grant.setStatus(InvoiceStatusEnum.PAID.toString());
				grantManagementService.updateGrant(grant);
			}
		}
	}
	
	public void saveSalaryBonusPayment(PaymentVO paymentVo, List<Integer> salaryidList, List<Integer> bonusidList) {
		List<SalaryBonusVO> salaryVoList = salaryBonusManagementService.getAllSalaryByIdList(salaryidList);
		List<SalaryBonusVO> bonusVoList = salaryBonusManagementService.getAllBonusByIdList(bonusidList);
		List<PaymentDetailVO> paymentDetailVOList = genPaymentDetail(paymentVo);
		
		for(PaymentDetailVO paymentdetail : paymentDetailVOList) {
			for(SalaryBonusVO salary : salaryVoList) {
				PaymentRsVO paymentRsVO = new PaymentRsVO();
				paymentRsVO.setReferenceType(GeneralUtils.MODULE_SALARY);
				paymentRsVO.setReferenceId(salary.getId());
				paymentRsVO.setPaymentDetailId(paymentdetail.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				
				salary.setStatus(ExpenseStatusEnum.PAID.toString());
				salaryBonusManagementService.updateSalaryBonus(salary);
			}
			
			for(SalaryBonusVO bonus : bonusVoList) {
				PaymentRsVO paymentRsVO = new PaymentRsVO();
				paymentRsVO.setReferenceType(GeneralUtils.MODULE_BONUS);
				paymentRsVO.setReferenceId(bonus.getId());
				paymentRsVO.setPaymentDetailId(paymentdetail.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				
				bonus.setStatus(ExpenseStatusEnum.PAID.toString());
				salaryBonusManagementService.updateSalaryBonus(bonus);
			}
		}
	}
	
	public void saveSalaryPayment(PaymentVO paymentVo, List<Integer> salaryidList) {
		List<SalaryBonusVO> salaryBonusVoList = salaryBonusManagementService.getAllSalaryByIdList(salaryidList);
		List<PaymentDetailVO> paymentDetailVOList = genPaymentDetail(paymentVo);
		
		for(PaymentDetailVO paymentdetail : paymentDetailVOList) {
			for(SalaryBonusVO salary : salaryBonusVoList) {
				PaymentRsVO paymentRsVO = new PaymentRsVO();
				paymentRsVO.setReferenceType(GeneralUtils.MODULE_SALARY);
				paymentRsVO.setReferenceId(salary.getId());
				paymentRsVO.setPaymentDetailId(paymentdetail.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				
				salary.setStatus(ExpenseStatusEnum.PAID.toString());
				salaryBonusManagementService.updateSalaryBonus(salary);
			}
		}
	}
	
	public void saveBonusPayment(PaymentVO paymentVo, List<Integer> bonusidList) {
		List<SalaryBonusVO> salaryBonusVoList = salaryBonusManagementService.getAllBonusByIdList(bonusidList);
		List<PaymentDetailVO> paymentDetailVOList = genPaymentDetail(paymentVo);
		
		for(PaymentDetailVO paymentDetailVO : paymentDetailVOList) {
			for(SalaryBonusVO bonus : salaryBonusVoList) {
				PaymentRsVO paymentRsVO = new PaymentRsVO();
				paymentRsVO.setReferenceType(GeneralUtils.MODULE_BONUS);
				paymentRsVO.setReferenceId(bonus.getId());
				paymentRsVO.setPaymentDetailId(paymentDetailVO.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				
				bonus.setStatus(ExpenseStatusEnum.PAID.toString());
				salaryBonusManagementService.updateSalaryBonus(bonus);
			}
		}
	}
	
	
	
	public PaymentDetailVO savePaymentDetail(PaymentDetailVO paymentDetailVO) {
		if(paymentDetailVO != null){
			PaymentDetailDbObject dbObj = convertToPaymentDetailDbObjectList(Arrays.asList(paymentDetailVO)).get(0);
			paymentDetailDbObjectMapper.insert(dbObj);
			return convertToPaymentDetailVOList(Arrays.asList(dbObj)).get(0);
		}
		return new PaymentDetailVO();
	}
	
	public void saveBounceCheque(PaymentVO paymentVo, List<Integer> bouncechequeidList, List<PaymentRsVO> paymentRsList){
		chequeManagementService.bounceCheque(bouncechequeidList, paymentVo.getBounceDate());
		
		if(paymentRsList != null && !paymentRsList.isEmpty()) {
			List<Integer> idList = new ArrayList<Integer>();
			for(PaymentRsVO vo : paymentRsList) {
				if(vo.getReferenceId() != null)
					idList.add(vo.getReferenceId());
			}
			switch(paymentVo.getReferenceType()) {
				case GeneralUtils.MODULE_EXPENSE:
					saveExpensePayment(paymentVo, idList);
					break;
				case GeneralUtils.MODULE_GRANT:
					saveGrantPayment(paymentVo, idList);
					break;
				case GeneralUtils.MODULE_INVOICE:
					saveInvoicePayment(paymentVo, idList);
					break;
				case GeneralUtils.MODULE_SALARY:
					saveSalaryPayment(paymentVo, idList);
					break;
				case GeneralUtils.MODULE_BONUS:
					saveBonusPayment(paymentVo, idList);
					break;
			}
		}
	}
	
	
	private List<PaymentDetailVO> genPaymentDetail(PaymentVO paymentVo) {
		List<PaymentDetailVO> paymentDetailList = new ArrayList<PaymentDetailVO>();
		if(paymentVo.getPaymentmodecash()){
			PaymentDetailVO paymentDetailVO = convertCashPaymentToPaymentDetailVOList(Arrays.asList(paymentVo)).get(0);
			paymentDetailVO = savePaymentDetail(paymentDetailVO);
			paymentDetailList.add(paymentDetailVO);
		}
		
		if(paymentVo.getPaymentmodecheque()){
			ChequeDbObject chequeDbObj = convertPaymentToChequeDbObjectList(Arrays.asList(paymentVo)).get(0);
			chequeDbObjectMapper.insert(chequeDbObj);
			paymentVo.setChequeId(Integer.toString(chequeDbObj.getChequeId()));
			PaymentDetailVO paymentDetailVO = convertChequePaymentToPaymentDetailVOList(Arrays.asList(paymentVo)).get(0);
			paymentDetailVO = savePaymentDetail(paymentDetailVO);
			paymentDetailList.add(paymentDetailVO);
		}
		if(PaymentManagementController.payByDirectorModuleList.contains(paymentVo.getType()) && paymentVo.getPaymentmodedirector()){
			PaymentDetailVO paymentDetailVO = convertDirectorPaymentToPaymentDetailVOList(Arrays.asList(paymentVo)).get(0);
			paymentDetailVO = savePaymentDetail(paymentDetailVO);
			paymentDetailList.add(paymentDetailVO);
		}
		if(PaymentManagementController.giroModuleList.contains(paymentVo.getType()) && paymentVo.getPaymentmodegiro()){
			PaymentDetailVO paymentDetailVO = convertGiroPaymentToPaymentDetailVOList(Arrays.asList(paymentVo)).get(0);
			paymentDetailVO = savePaymentDetail(paymentDetailVO);
			paymentDetailList.add(paymentDetailVO);
		}
		return paymentDetailList;
	}
	
	public List<PaymentDetailVO> getAllPaymentByRefTypeAndRefId(String refType, Integer refId) {
		List<PaymentDetailVO> paymentdetailList = new ArrayList<PaymentDetailVO>();
		List<PaymentRsVO> paymentRsVOList = paymentRSManagementService.getAllPaymentByRefTypeAndRefId(refType, refId);
		List<Integer> idList = new ArrayList<Integer>();
		if(paymentRsVOList != null && paymentRsVOList.size() > 0) {
			for(PaymentRsVO paymentRs : paymentRsVOList) {
				idList.add(paymentRs.getPaymentDetailId());
			}
			PaymentDetailDbObjectExample example = new PaymentDetailDbObjectExample();
			example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andPaymentDetailIdIn(idList);
			example.setOrderByClause("payment_date desc, payment_mode asc, cheque_id asc");				
			paymentdetailList = convertToPaymentDetailVOList(paymentDetailDbObjectMapper.selectByExample(example));
		}
		return paymentdetailList;
	}
	
	public List<PaymentRsVO> getPaymentReferenceTypeByChequeId(String chequeId) {
		PaymentDetailDbObjectExample example = new PaymentDetailDbObjectExample();
		example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andChequeIdEqualTo(chequeId);
		List<PaymentDetailDbObject> paymentDetailDbList = paymentDetailDbObjectMapper.selectByExample(example);
		
		if(paymentDetailDbList != null && !paymentDetailDbList.isEmpty()) {
			for(PaymentDetailDbObject dbObj : paymentDetailDbList) {
				List<PaymentRsVO> retrievedList = paymentRSManagementService.getAllPaymentByPaymentDetailId(dbObj.getPaymentDetailId());
				if(retrievedList != null && !retrievedList.isEmpty()) {
					return retrievedList;
				}
			}
		}		
		return null;
	}
	
	
	public List<PaymentRsVO> getAllPaymentByChequeId(String chequeId) {
		PaymentDetailDbObjectExample example = new PaymentDetailDbObjectExample();
		example.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andChequeIdEqualTo(chequeId);
		List<PaymentDetailDbObject> paymentDetailDbList = paymentDetailDbObjectMapper.selectByExample(example);
		List<PaymentRsVO> voList = new ArrayList<PaymentRsVO>();
		if(paymentDetailDbList != null && !paymentDetailDbList.isEmpty()) {
			for(PaymentDetailDbObject dbObj : paymentDetailDbList) {
				List<PaymentRsVO> retrievedList = paymentRSManagementService.getAllPaymentByPaymentDetailId(dbObj.getPaymentDetailId());
				if(retrievedList != null && !retrievedList.isEmpty()) {
					voList.addAll(retrievedList);
				}
			}
		}		
		return voList;
	}
	
	private List<ChequeDbObject> convertPaymentToChequeDbObjectList(List<PaymentVO> paymentVOList) {
		List<ChequeDbObject> chequeDbObjectList = new ArrayList<ChequeDbObject>();
		if(paymentVOList != null && paymentVOList.size() > 0){
			for(PaymentVO vo : paymentVOList){
				ChequeDbObject dbObj = new ChequeDbObject();
				dbObj.setBounceChequeInd(GeneralUtils.UNBOUNCED);
				dbObj.setChequeAmt(vo.getChequeamount());
				dbObj.setChequeDate(vo.getChequedate());
				dbObj.setChequeNum(vo.getChequeno());
				chequeDbObjectList.add(dbObj);
			}
		}
		return chequeDbObjectList;
	}
	
	private List<PaymentDetailVO> convertCashPaymentToPaymentDetailVOList(List<PaymentVO> paymentVOList) {
		List<PaymentDetailVO> paymentDetailDbObjectList = new ArrayList<PaymentDetailVO>();
		if(paymentVOList != null && paymentVOList.size() > 0){
			for(PaymentVO vo : paymentVOList){
				PaymentDetailVO paymentDetailVO = new PaymentDetailVO();
				paymentDetailVO.setDeleteInd(GeneralUtils.NOT_DELETED);
				paymentDetailVO.setPaymentAmt(vo.getCashamount());
				paymentDetailVO.setPaymentDate(vo.getPaymentDate());
				paymentDetailVO.setPaymentMode(1);
				paymentDetailDbObjectList.add(paymentDetailVO);
			}
		}
		return paymentDetailDbObjectList;
	}
	
	private List<PaymentDetailVO> convertChequePaymentToPaymentDetailVOList(List<PaymentVO> paymentVOList) {
		List<PaymentDetailVO> paymentDetailDbObjectList = new ArrayList<PaymentDetailVO>();
		if(paymentVOList != null && paymentVOList.size() > 0){
			for(PaymentVO vo : paymentVOList){
				PaymentDetailVO paymentDetailVO = new PaymentDetailVO();
				paymentDetailVO.setChequeId(vo.getChequeId());
				paymentDetailVO.setDeleteInd(GeneralUtils.NOT_DELETED);
				paymentDetailVO.setPaymentAmt(vo.getChequeamount());
				paymentDetailVO.setPaymentDate(vo.getPaymentDate());
				paymentDetailVO.setPaymentMode(2);
				paymentDetailDbObjectList.add(paymentDetailVO);
			}
		}
		return paymentDetailDbObjectList;
	}
	
	private List<PaymentDetailVO> convertDirectorPaymentToPaymentDetailVOList(List<PaymentVO> paymentVOList) {
		List<PaymentDetailVO> paymentDetailDbObjectList = new ArrayList<PaymentDetailVO>();
		if(paymentVOList != null && paymentVOList.size() > 0){
			for(PaymentVO vo : paymentVOList){
				PaymentDetailVO paymentDetailVO = new PaymentDetailVO();
				paymentDetailVO.setDeleteInd(GeneralUtils.NOT_DELETED);
				paymentDetailVO.setPaymentAmt(vo.getDirectoramount());
				paymentDetailVO.setPaymentDate(vo.getPaymentDate());
				paymentDetailVO.setPaymentMode(3);
				paymentDetailDbObjectList.add(paymentDetailVO);
			}
		}
		return paymentDetailDbObjectList;
	}
	
	private List<PaymentDetailVO> convertGiroPaymentToPaymentDetailVOList(List<PaymentVO> paymentVOList) {
		List<PaymentDetailVO> paymentDetailDbObjectList = new ArrayList<PaymentDetailVO>();
		if(paymentVOList != null && paymentVOList.size() > 0){
			for(PaymentVO vo : paymentVOList){
				PaymentDetailVO paymentDetailVO = new PaymentDetailVO();
				paymentDetailVO.setDeleteInd(GeneralUtils.NOT_DELETED);
				paymentDetailVO.setPaymentAmt(vo.getGiroamount());
				paymentDetailVO.setPaymentDate(vo.getPaymentDate());
				paymentDetailVO.setPaymentMode(5);
				paymentDetailDbObjectList.add(paymentDetailVO);
			}
		}
		return paymentDetailDbObjectList;
	}
	
	private List<PaymentDetailVO> convertToPaymentDetailVOList(List<PaymentDetailDbObject> paymentDetailDbObjectList) {
		List<PaymentDetailVO> paymentDetailVOList = new ArrayList<PaymentDetailVO>();
		if(paymentDetailDbObjectList != null && !paymentDetailDbObjectList.isEmpty()) {
			for(PaymentDetailDbObject dbObj : paymentDetailDbObjectList) {
				PaymentDetailVO vo = new PaymentDetailVO();
				if(dbObj.getChequeId() != null){
					ChequeVO chequeVO = chequeManagementService.findById(Integer.valueOf(dbObj.getChequeId()));
					if(chequeVO != null){
						vo.setBounceChequeInd(chequeVO.getBounceChequeInd());
						vo.setBounceDate(chequeVO.getBounceDate());
						vo.setBounceDateString(chequeVO.getBounceDateString());
						vo.setChequeId(Integer.toString(chequeVO.getChequeId()));
						vo.setChequeNum(chequeVO.getChequeNum());
					}
					
				}
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setPaymentAmt(dbObj.getPaymentAmt());
				vo.setPaymentDate(dbObj.getPaymentDate());
				vo.setPaymentDateString(GeneralUtils.convertDateToString(dbObj.getPaymentDate(), GeneralUtils.STANDARD_DATE_FORMAT));
				vo.setPaymentDetailId(dbObj.getPaymentDetailId());
				vo.setPaymentMode(dbObj.getPaymentMode());
				vo.setPaymentModeString(paymentModeLookup.getPaymentModeById(dbObj.getPaymentMode()));
				vo.setVersion(dbObj.getVersion());
				paymentDetailVOList.add(vo);
			}
		}
		return paymentDetailVOList;
	}
	
	private List<PaymentDetailDbObject> convertToPaymentDetailDbObjectList(List<PaymentDetailVO> paymentDetailVOList) {
		List<PaymentDetailDbObject> paymentDetailDbObjectList = new ArrayList<PaymentDetailDbObject>();
		if(paymentDetailVOList != null && !paymentDetailVOList.isEmpty()){
			for(PaymentDetailVO vo : paymentDetailVOList){
				PaymentDetailDbObject dbObj = new PaymentDetailDbObject();
				dbObj.setChequeId(vo.getChequeId());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setPaymentAmt(vo.getPaymentAmt());
				dbObj.setPaymentDate(vo.getPaymentDate());
				dbObj.setPaymentMode(vo.getPaymentMode());
				dbObj.setVersion(vo.getVersion());
				paymentDetailDbObjectList.add(dbObj);
			}
		}
		return paymentDetailDbObjectList;
	}
	
}
