package com.cg.CustomerSpringRest.service;

import java.util.List;

import com.cg.CustomerSpringRest.entites.Customer;

public interface ICustomerService {
	Customer add(Customer customer);
	
	Customer delete(Long id);
	Customer byId(Long id);
	Customer update(Customer customer);

	List<Customer> findAll();

}
