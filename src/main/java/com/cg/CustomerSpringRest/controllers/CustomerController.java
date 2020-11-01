package com.cg.CustomerSpringRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.CustomerSpringRest.dto.AddCustomer;
import com.cg.CustomerSpringRest.dto.ShowDetails;
import com.cg.CustomerSpringRest.entites.Customer;
import com.cg.CustomerSpringRest.service.ICustomerService;
// https://localhost:8100/customer
@RequestMapping("/customer")
@RestController
public class CustomerController {
	@Autowired
	private ICustomerService service;
	
	@PostMapping("/add")
	public ShowDetails add(@RequestBody AddCustomer addcustomer)
	{
		Customer customer=new Customer(addcustomer.getName());
		customer=service.add(customer);
		ShowDetails showing=todetails(customer);
		return showing;
	}
	public ShowDetails todetails(Customer customer)
	{
		ShowDetails showing=new ShowDetails(customer.getId(),customer.getName());
		return showing;
	}
	@PutMapping("/update")
	public ShowDetails update(@RequestBody Customer addcustomer)
	{
		Customer customer=new Customer(addcustomer.getName());
		customer.setId(addcustomer.getId());
		customer=service.update(customer);
		ShowDetails showing=todetails(customer);
		return showing;
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id)
	{
		service.delete(id);
		return "deleted successfully";	
	}
	@GetMapping("/show/{id}")
	public Customer showCustomer(@PathVariable Long id)
	{
		Customer customer=service.byId(id);
		return customer;
	}
	@GetMapping("/showcustomers")
	public List<Customer> allCustomer()
	{
		List<Customer> customer=service.findAll();
		return customer;
	}
}
