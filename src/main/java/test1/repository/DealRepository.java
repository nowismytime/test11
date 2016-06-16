package test1.repository;

import org.springframework.data.repository.Repository;

import test1.model.Deal;

public interface DealRepository extends Repository<Deal, String>{
	Deal findOne(String primarykey);           //finds deal of that given id
	Deal save(Deal entity);					   //adds deal to database
	boolean exists(String primarykey);		   //checks if deal of that id exists or not
	void delete(String primarykey);			   //deletes the deal of the given id
}


















/*
import org.springframework.data.repository.Repository;

import com.nearbuy.firstproject.db.model.Deal;

public interface DealRepository extends Repository<Deal,String> {
	Deal findOne(String primarykey);
	Deal save(Deal entity);
}*/
