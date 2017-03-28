package com.JJ.service.paymentmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.expensemanagement.ExpenseStatusEnum;
import com.JJ.controller.expensemanagement.VO.ExpenseVO;
import com.JJ.controller.invoicemanagement.InvoiceStatusEnum;
import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.controller.paymentmanagement.vo.ChequeVO;
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
import com.JJ.service.expensemanagement.ExpenseManagementService;
import com.JJ.service.invoicemanagement.InvoiceManagementService;
import com.JJ.service.salarybonusmanagement.SalaryBonusManagementService;

@Service
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class PaymentManagementService {
	
	private PaymentDetailDbObjectMapper paymentDetailDbObjectMapper;
	private ChequeDbObjectMapper chequeDbObjectMapper;
	private ExpenseTypeLookup expenseTypeLookup;
	private ExpenseManagementService expenseManagementService;
	private InvoiceManagementService invoiceManagementService;
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
			SalaryBonusManagementService salaryBonusManagementService,
			ChequeManagementService chequeManagementService,
			PaymentRSManagementService paymentRSManagementService,
			PaymentModeLookup paymentModeLookup) {
		this.paymentDetailDbObjectMapper = paymentDetailMapper;
		this.chequeDbObjectMapper = chequeDbObjectMapper;
		this.expenseTypeLookup = expenseTypeLookup;
		this.expenseManagementService = expenseManagementService;
		this.invoiceManagementService = invoiceManagementService;
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
				paymentRsVO.setReferenceType("expense");
				paymentRsVO.setReferenceId(expense.getExpenseId());
				paymentRsVO.setPaymentDetailId(paymentdetail.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				if(expense.getexpensetype().toLowerCase().contains("china"))
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
				paymentRsVO.setReferenceType("invoice");
				paymentRsVO.setReferenceId(invoice.getInvoiceId());
				paymentRsVO.setPaymentDetailId(paymentdetail.getPaymentDetailId());
				paymentRSManagementService.savePaymentRs(paymentRsVO);
				
				invoice.setStatus(InvoiceStatusEnum.PAID.toString());
				invoiceManagementService.updateInvoice(invoice);
			}
		}
	}
	
	public void saveSalaryPayment(PaymentVO paymentVo, List<Integer> salaryidList) {
		List<SalaryBonusVO> salaryBonusVoList = salaryBonusManagementService.getAllSalaryByIdList(salaryidList);
		List<PaymentDetailVO> paymentDetailVOList = genPaymentDetail(paymentVo);
		
		for(PaymentDetailVO paymentdetail : paymentDetailVOList) {
			for(SalaryBonusVO salary : salaryBonusVoList) {
				PaymentRsVO paymentRsVO = new PaymentRsVO();
				paymentRsVO.setReferenceType("salary");
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
				paymentRsVO.setReferenceType("bonus");
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
	
	private List<PaymentDetailVO> convertToPaymentDetailVOList(List<PaymentDetailDbObject> paymentDetailDbObjectList) {
		List<PaymentDetailVO> paymentDetailVOList = new ArrayList<PaymentDetailVO>();
		if(paymentDetailDbObjectList != null && !paymentDetailDbObjectList.isEmpty()) {
			for(PaymentDetailDbObject dbObj : paymentDetailDbObjectList) {
				PaymentDetailVO vo = new PaymentDetailVO();
				if(dbObj.getChequeId() != null){
					ChequeVO chequeVO = chequeManagementService.findById(Integer.valueOf(dbObj.getChequeId()));
					vo.setBounceChequeInd(chequeVO.getBounceChequeInd());
					vo.setChequeId(Integer.toString(chequeVO.getChequeId()));
					vo.setChequeNum(chequeVO.getChequeNum());
				}
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setPaymentAmt(dbObj.getPaymentAmt());
				vo.setPaymentDate(dbObj.getPaymentDate());
				vo.setPaymentDateString(GeneralUtils.convertDateToString(dbObj.getPaymentDate(), "dd/MM/yyyy"));
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
