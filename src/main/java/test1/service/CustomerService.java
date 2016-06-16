package test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test1.model.Customer;
import test1.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public boolean checkCustomer(String id)
	{
		return customerRepository.exists(id);
	}
	
	public void addCustomer(Customer object)
	{
		customerRepository.save(object);
	}
	
	public void updateCustomer(Customer object)
	{
		customerRepository.save(object);
	}
	
	public void deleteCustomer(String id)
	{
		customerRepository.delete(id);
	}
	
	public Customer getCustomer(String id)
	{
		return customerRepository.findOne(id);
	}

}
