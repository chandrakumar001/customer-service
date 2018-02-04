package com.demo.customer.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.customer.model.Customer;
import com.demo.customer.service.CustomerService;
import com.demo.customer.validation.CustomerValidation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="customerservice", description="Operations pertaining for customer service")
@RestController
public class CustomerController {

	private static Logger LOGGER=LoggerFactory.getLogger(CustomerController.class);

	private CustomerService custService;
	@SuppressWarnings("unused")
	private CustomerValidation customerValidation=null;

	@Autowired
	public CustomerController(CustomerService custService,CustomerValidation customerValidation){
		this.custService=custService;
		this.customerValidation=customerValidation;
	}
	
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	
	@GetMapping("/customers")
	public ResponseEntity<?>  getCustomers() {
		LOGGER.info("calling getCustomers() method...");

		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("calling getCustomers() method..."+custService.toString());
		}

		return new ResponseEntity<>(custService, HttpStatus.OK);
	}

	
	@ApiOperation(value = "available products", response = Customer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})

	@GetMapping("/customers/{id}")
	public Customer  getCustomer( @PathVariable("id") int id) {//@RequestHeader String jwt,
		LOGGER.info("calling getCustomer() method..."+id);
		Customer cs=custService.getCustomer(id);
		if(null==cs) {
			new Customer();
		}
		return cs;
	}

	@PostMapping("/customers")
	public ResponseEntity<?>  createCustomer(@RequestBody Customer customer) {
		LOGGER.info("calling getCustomer() method..."+customer);
		Customer customerResp = custService.getCustomer(customer);
		return new ResponseEntity<>(customerResp, HttpStatus.CREATED);
	}

}
