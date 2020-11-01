package com.cg.CustomerSpringRest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.CustomerSpringRest.entites.Customer;
import com.cg.CustomerSpringRest.repsoitory.ICustomerRepository;
@Transactional
@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private ICustomerRepository repo;
	@Override
	public Customer add(Customer customer) {
		return repo.add(customer);
	}

	@Override
	public Customer update(Customer customer) {
		
		return repo.update(customer);
	}

	

	@Override
	public Customer delete(Long id) {
		Customer customer=repo.findById(id);
		return repo.delete(customer);
	}
	@Override
	public Customer byId(Long id)
	{
		Customer customer=repo.findById(id);
		return repo.showCustomer(customer);
	}
	@Override
	public List<Customer> findAll()
	{
		List<Customer> customer=repo.findAll();
		return customer;
	}
	

}
