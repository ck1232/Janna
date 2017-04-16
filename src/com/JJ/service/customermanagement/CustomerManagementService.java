package com.JJ.service.customermanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.customermanagement.VO.CustomerVO;
import com.JJ.dao.CustomerDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.CustomerDbObject;
import com.JJ.model.CustomerDbObjectExample;;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class CustomerManagementService {
	
	private CustomerDbObjectMapper customerDbObjectMapper;
	
	@Autowired
	public CustomerManagementService(CustomerDbObjectMapper customerDbObjectMapper) {
		this.customerDbObjectMapper = customerDbObjectMapper;
	}
	
	public CustomerVO findById(Integer id) {
		CustomerDbObject customerDbObject = customerDbObjectMapper.selectByPrimaryKey(id);
		if(customerDbObject != null && customerDbObject.getCustomerId() != null){
			return convertToCustomerVOList(Arrays.asList(customerDbObject)).get(0);
		}else{
			return new CustomerVO();
		}
	}

	public List<CustomerVO> getAllCustomers() {
		CustomerDbObjectExample customerDbObjectExample = new CustomerDbObjectExample();
		customerDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToCustomerVOList(customerDbObjectMapper.selectByExample(customerDbObjectExample));
	}
	
	public List<CustomerVO> getAllCustomers(List<Integer> customerIdList) {
		CustomerDbObjectExample customerDbObjectExample = new CustomerDbObjectExample();
		customerDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andCustomerIdIn(customerIdList);
		return convertToCustomerVOList(customerDbObjectMapper.selectByExample(customerDbObjectExample));
	}
	
	public int saveCustomer(CustomerVO customerVO) {
		if(customerVO != null) {
			CustomerDbObject dbObj = convertToCustomerDbObjectList(Arrays.asList(customerVO)).get(0);
			return customerDbObjectMapper.insert(dbObj);
		}
		return 0;
	}
	
	public void deleteCustomer(Integer id) {
		deleteCustomer(Arrays.asList(id));
	}
	
	public void deleteCustomer(List<Integer> idList) {
		CustomerDbObjectExample customerDbObjectExample = new CustomerDbObjectExample();
		customerDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andCustomerIdIn(idList);
		CustomerDbObject dbObj = new CustomerDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		customerDbObjectMapper.updateByExampleSelective(dbObj, customerDbObjectExample);
	}
	
	public void updateCustomer(CustomerVO customerVO) {
		if(customerVO != null && customerVO.getDeleteInd() != null &&
				customerVO.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			CustomerDbObject dbObj = convertToCustomerDbObjectList(Arrays.asList(customerVO)).get(0);
			customerDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	 
	private List<CustomerVO> convertToCustomerVOList(List<CustomerDbObject> customerDbObjectList) {
		List<CustomerVO> customerVOList = new ArrayList<CustomerVO>();
		if(customerDbObjectList != null && customerDbObjectList.size() > 0) {
			for(CustomerDbObject dbObj : customerDbObjectList) {
				CustomerVO customerVO = new CustomerVO();
				customerVO.setCustomerId(dbObj.getCustomerId());
				customerVO.setDeleteInd(dbObj.getDeleteInd());
				customerVO.setDob(dbObj.getDob());
				customerVO.setEmailAddress(dbObj.getEmailAddress());
				customerVO.setGender(dbObj.getGender());
				customerVO.setIsActive(dbObj.getIsActive());
				customerVO.setName(dbObj.getName());
				customerVO.setPassword(dbObj.getPassword());
				customerVO.setUserId(dbObj.getUserId());
				customerVO.setVersion(dbObj.getVersion());
				customerVOList.add(customerVO);
			}
		}
		return customerVOList;
	}
	
	private List<CustomerDbObject> convertToCustomerDbObjectList(List<CustomerVO> customerVOList) {
		List<CustomerDbObject> customerDbObjectList = new ArrayList<CustomerDbObject>();
		if(customerVOList != null && customerVOList.size() > 0){
			for(CustomerVO vo : customerVOList){
				CustomerDbObject dbObj = new CustomerDbObject();
				dbObj.setCustomerId(vo.getCustomerId());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setDob(vo.getDob());
				dbObj.setEmailAddress(vo.getEmailAddress());
				dbObj.setGender(vo.getGender());
				dbObj.setIsActive(vo.getIsActive());
				dbObj.setName(vo.getName());
				dbObj.setPassword(vo.getPassword());
				dbObj.setUserId(vo.getUserId());
				dbObj.setVersion(vo.getVersion());
				customerDbObjectList.add(dbObj);
			}
		}
		return customerDbObjectList;
	}
}
