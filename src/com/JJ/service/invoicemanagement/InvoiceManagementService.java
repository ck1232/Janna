package com.JJ.service.invoicemanagement;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.FileMetaVO;
import com.JJ.controller.invoicemanagement.InvoiceSearchCriteria;
import com.JJ.controller.invoicemanagement.vo.InvoiceUploadVO;
import com.JJ.controller.invoicemanagement.vo.InvoiceVO;
import com.JJ.dao.InvoiceDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.InvoiceDbObject;
import com.JJ.model.InvoiceDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class InvoiceManagementService {
	private static final Logger logger = Logger.getLogger(InvoiceManagementService.class);
	private InvoiceDbObjectMapper invoiceDbObjectMapper;
	private ExcelFileHelper excelFileHelper;
	@Autowired
	public InvoiceManagementService(InvoiceDbObjectMapper invoiceDbObjectMapper) {
		this.invoiceDbObjectMapper = invoiceDbObjectMapper;
	}

	public List<InvoiceVO> getAllInvoice() {
		InvoiceDbObjectExample invoiceDbObjectExample = new InvoiceDbObjectExample();
		invoiceDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToInvoiceVOList(invoiceDbObjectMapper.selectByExample(invoiceDbObjectExample));
	}
	
	public List<InvoiceVO> getAllInvoice(Date startDate, Date endDate) {
		InvoiceDbObjectExample invoiceDbObjectExample = new InvoiceDbObjectExample();
		invoiceDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED)
		.andInvoiceDateGreaterThanOrEqualTo(startDate).andInvoiceDateLessThanOrEqualTo(endDate);
		invoiceDbObjectExample.setOrderByClause("invoice_date");
		return convertToInvoiceVOList(invoiceDbObjectMapper.selectByExample(invoiceDbObjectExample));
	}
	
	public List<InvoiceVO> getAllInvoiceByIdList(List<Integer> idList) {
		InvoiceDbObjectExample invoiceDbObjectExample = new InvoiceDbObjectExample();
		invoiceDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andInvoiceIdIn(idList);
		invoiceDbObjectExample.setOrderByClause("invoice_date desc");
		return convertToInvoiceVOList(invoiceDbObjectMapper.selectByExample(invoiceDbObjectExample));
	}
	
	public List<String> getAllMessenger() {
		InvoiceDbObjectExample invoiceDbObjectExample = new InvoiceDbObjectExample();
		invoiceDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		List<InvoiceDbObject> invoiceList = invoiceDbObjectMapper.selectByExample(invoiceDbObjectExample);
		Set<String> s = new HashSet<String>();
		for(InvoiceDbObject dbObj : invoiceList) {
			if(dbObj.getMessenger() != null && !dbObj.getMessenger().isEmpty())
				s.add(dbObj.getMessenger());
		}
		return new ArrayList<String>(s);
	}
	
	public InvoiceVO getInvoiceById(Integer id) {
		InvoiceDbObject invoiceDbObject = invoiceDbObjectMapper.selectByPrimaryKey(id);
		if(invoiceDbObject != null && invoiceDbObject.getInvoiceId() != null){
			return convertToInvoiceVOList(Arrays.asList(invoiceDbObject)).get(0);
		}else{
			return null;
		}
	}
	
	public List<InvoiceVO> searchInvoice(InvoiceSearchCriteria searchCriteria) {
		List<InvoiceVO> invoiceList = getAllInvoice();
		List<InvoiceVO> filteredList = new ArrayList<InvoiceVO>();
		
		for(InvoiceVO invoice : invoiceList) {
			if(!searchCriteria.getMessenger().trim().equalsIgnoreCase(invoice.getMessenger())) continue;
			if(!searchCriteria.getStatus().equalsIgnoreCase("ALL")&& !searchCriteria.getStatus().trim().equalsIgnoreCase(invoice.getStatus())) continue;
			if(!searchCriteria.getInvoicedatefrom().isEmpty()){
				try {
					if(null == invoice.getInvoiceDate()) continue;
					Date datefrom = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getInvoicedatefrom());
					if(invoice.getInvoiceDate().compareTo(datefrom) < 0) continue; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(!searchCriteria.getInvoicedateto().isEmpty()){
				try {
					if(null == invoice.getInvoiceDate()) continue;
					Date dateto = new SimpleDateFormat("MM/dd/yyyy").parse(searchCriteria.getInvoicedateto());
					Calendar c = Calendar.getInstance();
					c.setTime(dateto);
					c.add(Calendar.DATE, 1);
					if(invoice.getInvoiceDate().compareTo(c.getTime()) > 0) continue; 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			filteredList.add(invoice);
		}
		return filteredList;
	}
	
	
	public void saveInvoice(InvoiceVO invoiceVO) {
		if(invoiceVO != null){
			InvoiceDbObject dbObj = convertToInvoiceDbObjectList(Arrays.asList(invoiceVO)).get(0);
			invoiceDbObjectMapper.insert(dbObj);
		}
	}
	
	public void updateInvoice(InvoiceVO invoiceVO) {
		if(invoiceVO != null && invoiceVO.getDeleteInd() != null &&
				invoiceVO.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			InvoiceDbObject dbObj = convertToInvoiceDbObjectList(Arrays.asList(invoiceVO)).get(0);
			dbObj.setMessenger(invoiceVO.getMessenger());
			dbObj.setInvoiceDate(invoiceVO.getInvoiceDate());
			dbObj.setTotalAmt(invoiceVO.getTotalAmt());
			dbObj.setStatus(invoiceVO.getStatus());
			invoiceDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	public void saveInvoiceList(List<InvoiceVO> invoiceVOList) {
		for(InvoiceVO invoiceVO : invoiceVOList)
			saveInvoice(invoiceVO);
	}
	
	public void deleteInvoice(Integer id) {
		deleteInvoice(Arrays.asList(id));
	}
	
	public void deleteInvoice(List<Integer> idList) {
		InvoiceDbObjectExample invoiceDbObjectExample = new InvoiceDbObjectExample();
		invoiceDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andInvoiceIdIn(idList);
		InvoiceDbObject dbObj = new InvoiceDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		invoiceDbObjectMapper.updateByExampleSelective(dbObj, invoiceDbObjectExample);
	}
	
	public int saveInvoiceFromUploadFile(InvoiceUploadVO invoice) {
		excelFileHelper = new ExcelFileHelper();
		InvoiceVO invoicedata;
		int fileUploadCount = 0;
		for(FileMetaVO file : invoice.getInvoiceList()) {
			logger.debug("extract start");
			invoicedata = excelFileHelper.readFromFile(file.getBytes());
			logger.debug("extract end");
			logger.debug("save start");
			if(invoicedata != null){
				invoicedata.setStatus(GeneralUtils.STATUS_PENDING);
				InvoiceVO savedInvoice = getInvoiceById(invoicedata.getInvoiceId());
				if(invoicedata.getInvoiceId() != null && savedInvoice == null) {
					saveInvoice(invoicedata);
					fileUploadCount++;
				}else if(invoicedata.getInvoiceId() != null && savedInvoice != null){
					updateInvoice(invoicedata);
					fileUploadCount++;
				}
			}
		}
		logger.debug("save end");
		return fileUploadCount;
	}
	
	public HSSFWorkbook writeToFile(File inputfile, List<InvoiceVO> invoiceList, String statementPeriod) {
		excelFileHelper = new ExcelFileHelper();
		HSSFWorkbook wb = excelFileHelper.writeToFile(inputfile, invoiceList, statementPeriod);
		return wb;
	}
	
	private List<InvoiceVO> convertToInvoiceVOList(List<InvoiceDbObject> invoiceDbObjectList) {
		List<InvoiceVO> invoiceVOList = new ArrayList<InvoiceVO>();
		if(invoiceDbObjectList != null && invoiceDbObjectList.size() > 0) {
			for(InvoiceDbObject dbObj : invoiceDbObjectList) {
				InvoiceVO vo = new InvoiceVO();
				vo.setDeleteInd(dbObj.getDeleteInd());
				vo.setInvoiceDate(dbObj.getInvoiceDate());
				vo.setInvoicedateString(GeneralUtils.convertDateToString(dbObj.getInvoiceDate(), "dd/MM/yyyy"));
				vo.setInvoiceId(dbObj.getInvoiceId());
				vo.setMessenger(dbObj.getMessenger());
				vo.setStatus(dbObj.getStatus());
				vo.setTotalAmt(dbObj.getTotalAmt());
				vo.setType("invoice");
				vo.setVersion(dbObj.getVersion());
				invoiceVOList.add(vo);
			}
		}
		return invoiceVOList;
	}
	
	private List<InvoiceDbObject> convertToInvoiceDbObjectList(List<InvoiceVO> invoiceVOList) {
		List<InvoiceDbObject> invoiceDbObjectList = new ArrayList<InvoiceDbObject>();
		if(invoiceVOList != null && invoiceVOList.size() > 0){
			for(InvoiceVO vo : invoiceVOList){
				InvoiceDbObject dbObj = new InvoiceDbObject();
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setInvoiceDate(vo.getInvoiceDate());
				dbObj.setInvoiceId(vo.getInvoiceId());
				dbObj.setMessenger(vo.getMessenger());
				dbObj.setStatus(vo.getStatus());
				dbObj.setTotalAmt(vo.getTotalAmt());
				dbObj.setVersion(vo.getVersion());
				invoiceDbObjectList.add(dbObj);
			}
		}
		return invoiceDbObjectList;
	}
	
}
