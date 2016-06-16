package test1.repository;

import org.springframework.data.repository.Repository;

import test1.model.Customer;

public interface CustomerRepository extends Repository<Customer, String>{
	
	Customer findOne(String id);
	Customer save(Customer object);
	boolean exists(String id);
	void delete(String id);
}
