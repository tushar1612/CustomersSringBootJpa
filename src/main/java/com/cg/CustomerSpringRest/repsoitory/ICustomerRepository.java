package com.cg.CustomerSpringRest.repsoitory;

import java.util.List;

import com.cg.CustomerSpringRest.entites.Customer;

public interface ICustomerRepository  {
	Customer add(Customer customer);
	Customer update(Customer customer);
	Customer delete(Customer customer);
	Customer findById(Long Id);
	Customer showCustomer(Customer customer);
	List<Customer> findAll();

}
