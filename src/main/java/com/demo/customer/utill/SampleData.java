package com.demo.customer.utill;

import java.util.ArrayList;
import java.util.List;

import com.demo.customer.model.Customer;

public class SampleData {
	
	public static List<Customer> getCustomerList(){
		List<Customer> customers=new ArrayList<Customer>();
		customers.add(new Customer(1,"Chandra","street",null));
		customers.add(new Customer(2,"Chandra","street",null));
		customers.add(new Customer(3,"Chandra","street",null));
		customers.add(new Customer(4,"Chandra","street",null));
		customers.add(new Customer(5,"Chandra","street",null));	
		return customers;
	}

}
