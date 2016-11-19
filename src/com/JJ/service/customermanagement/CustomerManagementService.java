package com.JJ.service.customermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.CustomerMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.Customer;
import com.JJ.model.CustomerExample;

@Service
@Transactional
public class CustomerManagementService {
	
	private CustomerMapper customerMapper;
	
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
		List<Customer> customerList = customerMapper.selectByExample(customerExample);
		return customerList;
	}
	
	public void saveCustomer(Customer customer) {
		customerMapper.insert(customer);
	}
	
	public void deleteCustomer(Integer id) {
		Customer customer = findById(id);
		if(customer.getDeleteind().equals(GeneralUtils.NOT_DELETED)){
			customer.setDeleteind(GeneralUtils.DELETED);
			customerMapper.updateByPrimaryKey(customer);
		}
	}
	
	public void updateCustomer(Customer customer) {
		if(customer.getDeleteind().equals(GeneralUtils.NOT_DELETED))
			customerMapper.updateByPrimaryKeySelective(customer);
	}
	 
	
	
}
