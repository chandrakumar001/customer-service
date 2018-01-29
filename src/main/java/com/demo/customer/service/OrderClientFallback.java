package com.demo.customer.service;

import java.util.List;

import com.demo.customer.model.OrderResponse;

public class OrderClientFallback implements OrderClient{

	@Override
	public List<OrderResponse> getCustomers() {
		return null;
	}

}
