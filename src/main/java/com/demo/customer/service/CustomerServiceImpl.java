package com.demo.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.customer.model.Customer;
import com.demo.customer.model.OrderResponse;
import com.demo.customer.utill.SampleData;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerServiceImpl implements CustomerService {

	private  List<Customer> customers=null;
	@Autowired
	private OrderClient orderClient;

	public CustomerServiceImpl(){
		customers = SampleData.getCustomerList();
	}

	@Override
	public List<Customer> getCustomers() {
		return customers;
	}


	@Override
	@HystrixCommand(fallbackMethod = "callGetOrderResp_Fallback")
	public Customer getCustomer(int idNumber) {
		List<OrderResponse>  orderss=demo(idNumber);
		Customer cac=null;
		if(!orderss.isEmpty() && null!=orderss) {
			cac = customers.stream().filter(id->idNumber==id.getCust_id()).findFirst().orElse(null);
		}
		if(null!=cac) {
			cac.setOrderResp(orderss);
		}
		return cac;
		//return customers.stream().filter(id->idNumber==id.getCust_id()).findFirst().orElse(null);
	}

	@Override
	public Customer getCustomer(Customer customer) {
		customers.add(customer);
		return customer;
	}

	public List<OrderResponse> demo(int idNumber){
		List<OrderResponse> orderss=new ArrayList<>();

		try {
			List<OrderResponse> orders=orderClient.getCustomers();
			System.out.println("Hy...................");
			if(null!=orders && !orders.isEmpty() ) {
				/*List<OrderResponse> orderss=orders.stream()
					.map(id->{
						if(id.getCustom_Id()==idNumber) {
							return id;
						}
					}).collect(Collectors.toList());*/
				for(OrderResponse mat :orders) {
					if(mat.getCustom_Id()==idNumber) {
						orderss.add(mat);
					}
				}
			}
		}catch (Exception e) {
			System.out.println("Exception");
		}
		return orderss;
	}

	public Customer callGetOrderResp_Fallback(int idNumber) {
		System.out.println("Hy......dscv............."+idNumber);
		return null;
	}

}
