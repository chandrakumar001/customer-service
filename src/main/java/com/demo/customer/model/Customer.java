package com.demo.customer.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class Customer {
	
	@ApiModelProperty(notes = "The auto-generated version of the product")
	private int cust_id;
	private String name=null;
	private String extra_info=null;
	private List<OrderResponse> orderResp;
	
	public Customer() {
	}
	
	public Customer(int cust_id, String name, String extra_info, List<OrderResponse> orderResp) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.extra_info = extra_info;
		this.orderResp = orderResp;
	}

	public List<OrderResponse> getOrderResp() {
		return orderResp;
	}

	public void setOrderResp(List<OrderResponse> orderResp) {
		this.orderResp = orderResp;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExtra_info() {
		return extra_info;
	}
	public void setExtra_info(String extra_info) {
		this.extra_info = extra_info;
	}


	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", name=" + name + ", extra_info=" + extra_info + ", orderResp="
				+ orderResp + "]";
	}

}
