package com.demo.customer.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.customer.model.Customer;
import com.demo.customer.service.CustomerService;


@Component
public class CustomerValidation {

	@Autowired
	private CustomerService custService;


	public String getCustomer(String jwt,int id) {
		if(StringUtils.isBlank(jwt)) {
			return "should not empty JWT";
		}/*
		if(id<=0) {
			return new ResponseEntity<>("should not empty id", HttpStatus.BAD_REQUEST);
		}*/
		Customer customer = custService.getCustomer(id);
		return null;
	}

}
