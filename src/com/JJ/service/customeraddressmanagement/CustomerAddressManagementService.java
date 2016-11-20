package com.JJ.service.customeraddressmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.CustomeraddressMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Customeraddress;
import com.JJ.model.CustomeraddressExample;

@Service
@Transactional
public class CustomerAddressManagementService {
	
	private CustomeraddressMapper customerAddressMapper;
	
	@Autowired
	public CustomerAddressManagementService(CustomeraddressMapper customerAddressMapper) {
		this.customerAddressMapper = customerAddressMapper;
	}
	
	public Customeraddress findById(Integer id) {
		return customerAddressMapper.selectByPrimaryKey(id);
	}

	public List<Customeraddress> getAllCustomerAddress() {
		CustomeraddressExample customeraddressExample = new CustomeraddressExample();
		customeraddressExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		return customerAddressMapper.selectByExample(customeraddressExample);
	}
	
	public List<Customeraddress> getAllCustomerAddressByCustomerId(Integer customerId) {
		CustomeraddressExample customeraddressExample = new CustomeraddressExample();
		customeraddressExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andCustomeridEqualTo(customerId);
		return customerAddressMapper.selectByExample(customeraddressExample);
	}
	
	public void saveCustomerAddress(Customeraddress customerAddress) {
		customerAddressMapper.insert(customerAddress);
	}
	
	public void deleteCustomerAddress(Integer id) {
		Customeraddress customerAddress = findById(id);
		if(customerAddress.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			customerAddress.setDeleteind(GeneralUtils.DELETED);
			customerAddressMapper.updateByPrimaryKey(customerAddress);
		}
	}
	
	public void updateCustomerAddress(Customeraddress customerAddress) {
		if(customerAddress.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			customerAddressMapper.updateByPrimaryKeySelective(customerAddress);
	}
	
	public void updateCustomerAddressToUndefault(Integer customerid) {
		CustomeraddressExample customeraddressExample = new CustomeraddressExample();
		customeraddressExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andCustomeridEqualTo(customerid).andDefaultindEqualTo("Y");
		List<Customeraddress> customeraddressList = customerAddressMapper.selectByExample(customeraddressExample);
		for(Customeraddress address: customeraddressList){
			address.setDefaultind("N");
			customerAddressMapper.updateByPrimaryKey(address);
		}
	}
	 
	
	
}
