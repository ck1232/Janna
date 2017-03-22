package com.JJ.service.customermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.CustomerDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.CustomerDbObject;;

@Service
@Transactional
public class CustomerManagementService {
	
	private CustomerDbObject customerMapper;
	
	@Autowired
	public CustomerManagementService(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
	
	public Customer findById(Integer id) {
		return customerMapper.selectByPrimaryKey(id);
	}

	public List<Customer> getAllCustomers() {
		CustomerExample customerExample = new CustomerExample();
		customerExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED);
		return customerMapper.selectByExample(customerExample);
	}
	
	public List<Customer> getAllCustomers(List<Integer> customerIdList) {
		CustomerExample customerExample = new CustomerExample();
		customerExample.createCriteria().andDeleteindEqualTo(GeneralUtils.NOT_DELETED).andCustomeridIn(customerIdList);
		return customerMapper.selectByExample(customerExample);
	}
	
	public int saveCustomer(Customer customer) {
		return customerMapper.insert(customer);
	}
	
	public void deleteCustomer(Integer id) {
		Customer customer = findById(id);
		if(customer.getDeleteInd().equals(GeneralUtils.NOT_DELETED)){
			customer.setDeleteInd(GeneralUtils.DELETED);
			customerMapper.updateByPrimaryKey(customer);
		}
	}
	
	public void deleteCustomer(List<Integer> customerIdList) {
		List<Customer> customerList = getAllCustomers(customerIdList);
		for(Customer customer: customerList){
			customer.setDeleteInd(GeneralUtils.DELETED);
			customerMapper.updateByPrimaryKey(customer);
		}
	}
	
	public void updateCustomer(Customer customer) {
		if(customer.getDeleteInd().equals(GeneralUtils.NOT_DELETED))
			customerMapper.updateByPrimaryKeySelective(customer);
	}
	 
	
	
}
