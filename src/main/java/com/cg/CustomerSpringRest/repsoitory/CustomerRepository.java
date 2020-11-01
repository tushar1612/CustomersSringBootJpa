package com.cg.CustomerSpringRest.repsoitory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.CustomerSpringRest.entites.Customer;
@Repository
public class CustomerRepository implements ICustomerRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Customer add(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}



	@Override
	public Customer delete(Customer customer) {
		entityManager.remove(customer);
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		customer=entityManager.merge(customer);
		return customer;
	}
	@Override
	public Customer findById(Long Id)
	{
		Customer customer=entityManager.find(Customer.class, Id);
		return customer;
	}



	@Override
	public Customer showCustomer(Customer customer) {
		customer=entityManager.find(Customer.class, customer.getId());
		return customer;
	}
	@Override
	public List<Customer> findAll()
	{
		String query="from Customer";
		TypedQuery<Customer> customer=entityManager.createQuery(query, Customer.class);
		List<Customer> cus=customer.getResultList();
		return cus;
	}

}
