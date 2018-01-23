package com.demo.customer.service;

import java.util.List;

import com.demo.customer.model.Customer;

public interface CustomerService {
	public 	List<Customer> getCustomers();
	public 	Customer getCustomer(int id);
	public 	Customer getCustomer(Customer customer);

}
