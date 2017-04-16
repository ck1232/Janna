package com.JJ.service.customeraddressmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.customeraddressmanagement.VO.CustomerAddressVO;
import com.JJ.dao.CustomerAddressDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.CustomerAddressDbObject;
import com.JJ.model.CustomerAddressDbObjectExample;

@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class CustomerAddressManagementService {
	
	private CustomerAddressDbObjectMapper customerAddressDbObjectMapper;
	
	@Autowired
	public CustomerAddressManagementService(CustomerAddressDbObjectMapper customerAddressDbObjectMapper) {
		this.customerAddressDbObjectMapper = customerAddressDbObjectMapper;
	}
	
	public CustomerAddressVO findById(Integer id) {
		CustomerAddressDbObject customerAddressDbObject = customerAddressDbObjectMapper.selectByPrimaryKey(id);
		if(customerAddressDbObject != null && customerAddressDbObject.getCustomerId() != null){
			return convertToCustomerAddressVOList(Arrays.asList(customerAddressDbObject)).get(0);
		}else{
			return new CustomerAddressVO();
		}
	}

	public List<CustomerAddressVO> getAllCustomerAddress() {
		CustomerAddressDbObjectExample customeraddressExample = new CustomerAddressDbObjectExample();
		customeraddressExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
		return convertToCustomerAddressVOList(customerAddressDbObjectMapper.selectByExample(customeraddressExample));
	}
	
	public List<CustomerAddressVO> getAllCustomerAddressByCustomerId(Integer customerId) {
		CustomerAddressDbObjectExample customeraddressExample = new CustomerAddressDbObjectExample();
		customeraddressExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andCustomerIdEqualTo(customerId);
		return convertToCustomerAddressVOList(customerAddressDbObjectMapper.selectByExample(customeraddressExample));
	}
	
	public void saveCustomerAddress(CustomerAddressVO customerAddressVO) {
		if(customerAddressVO != null) {
			CustomerAddressDbObject dbObj = convertToCustomerAddressDbObjectList(Arrays.asList(customerAddressVO)).get(0);
			customerAddressDbObjectMapper.insert(dbObj);
		}
	}
	
	public void deleteCustomerAddress(Integer id) {
		deleteCustomerAddress(Arrays.asList(id));
	}
	
	public void deleteCustomerAddress(List<Integer> idList) {
		CustomerAddressDbObjectExample customerAddressDbObjectExample = new CustomerAddressDbObjectExample();
		customerAddressDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andAddressIdIn(idList);
		CustomerAddressDbObject dbObj = new CustomerAddressDbObject();
		dbObj.setDeleteInd(GeneralUtils.DELETED);
		customerAddressDbObjectMapper.updateByExampleSelective(dbObj, customerAddressDbObjectExample);
	}
	
	public void updateCustomerAddress(CustomerAddressVO customerAddressVO) {
		if(customerAddressVO != null && customerAddressVO.getDeleteInd() != null &&
				customerAddressVO.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			CustomerAddressDbObject dbObj = convertToCustomerAddressDbObjectList(Arrays.asList(customerAddressVO)).get(0);
			customerAddressDbObjectMapper.updateByPrimaryKeySelective(dbObj);
		}
	}
	
	public void updateCustomerAddressToUndefault(Integer customerid) {
		CustomerAddressDbObjectExample customerAddressDbObjectExample = new CustomerAddressDbObjectExample();
		customerAddressDbObjectExample.createCriteria().andDeleteIndEqualTo(GeneralUtils.NOT_DELETED).andCustomerIdEqualTo(customerid).andDefaultIndEqualTo("Y");
		CustomerAddressDbObject dbObj = new CustomerAddressDbObject();
		dbObj.setDefaultInd("N");
		customerAddressDbObjectMapper.updateByExampleSelective(dbObj, customerAddressDbObjectExample);
	}
	 
	private List<CustomerAddressVO> convertToCustomerAddressVOList(List<CustomerAddressDbObject> customerAddressDbObjectList) {
		List<CustomerAddressVO> customerAddressVOList = new ArrayList<CustomerAddressVO>();
		if(customerAddressDbObjectList != null && customerAddressDbObjectList.size() > 0) {
			for(CustomerAddressDbObject dbObj : customerAddressDbObjectList) {
				CustomerAddressVO customerAddressVO = new CustomerAddressVO();
				customerAddressVO.setAddress(dbObj.getAddress());
				customerAddressVO.setAddressId(dbObj.getAddressId());
				customerAddressVO.setContactNumber(dbObj.getContactNumber());
				customerAddressVO.setCountry(dbObj.getCountry());
				customerAddressVO.setCustomerId(dbObj.getCustomerId());
				customerAddressVO.setDeleteInd(dbObj.getDeleteInd());
				customerAddressVO.setPostalCode(dbObj.getPostalCode());
				customerAddressVO.setRecipientName(dbObj.getRecipientName());
				customerAddressVO.setVersion(dbObj.getVersion());
				customerAddressVOList.add(customerAddressVO);
			}
		}
		return customerAddressVOList;
	}
	
	private List<CustomerAddressDbObject> convertToCustomerAddressDbObjectList(List<CustomerAddressVO> customerAddressVOList) {
		List<CustomerAddressDbObject> customerAddressDbObjectList = new ArrayList<CustomerAddressDbObject>();
		if(customerAddressVOList != null && customerAddressVOList.size() > 0){
			for(CustomerAddressVO vo : customerAddressVOList){
				CustomerAddressDbObject dbObj = new CustomerAddressDbObject();
				dbObj.setAddress(vo.getAddress());
				dbObj.setAddressId(vo.getAddressId());
				dbObj.setContactNumber(vo.getContactNumber());
				dbObj.setCountry(vo.getCountry());
				dbObj.setCustomerId(vo.getCustomerId());
				dbObj.setDeleteInd(vo.getDeleteInd());
				dbObj.setPostalCode(vo.getPostalCode());
				dbObj.setRecipientName(vo.getRecipientName());
				dbObj.setVersion(vo.getVersion());
				customerAddressDbObjectList.add(dbObj);
			}
		}
		return customerAddressDbObjectList;
	}
	
}
