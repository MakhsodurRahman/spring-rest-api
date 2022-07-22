package com.makhsodur.springdemo.rest;

import java.util.List;

import com.makhsodur.springdemo.entity.Customer;
import com.makhsodur.springdemo.exceptions.CustomersNotFoundException;
import com.makhsodur.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}
	
	// add mapping for GET /customers/{customerId}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new CustomersNotFoundException("Customer id not found - " + customerId);
		}
		
		return theCustomer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		theCustomer.setId(0);
		 customerService.saveCustomer(theCustomer);
		 return theCustomer;
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId){
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null){
			throw new CustomersNotFoundException("cutomer not found "+customer);
		}

		customerService.deleteCustomer(customerId);
		return "deleted customer id " +customerId;

	}
}


















