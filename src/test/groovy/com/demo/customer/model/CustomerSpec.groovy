package com.demo.customer.model



import java.util.List

import spock.lang.Specification

class CustomerSpec extends Specification{

	def "constructor"() {
		given:"constructor"
		List<OrderResponse> lists=new ArrayList<>();
		lists.add(new OrderResponse());
		Customer customer=new Customer(1,"name", "extra_info", lists);
		expect:
		customer != null;
		customer.getCust_id()==1
	}
	def "without constructor"() {
		given:"without constructor"
		Customer customer=new Customer();
		expect:
		customer != null;
	}
	def "toString method"() {
		given:"toString"
		List<OrderResponse> lists=new ArrayList<>();
		lists.add(new OrderResponse());
		Customer customer=new Customer(1,"name", "extra_info", lists);
		when:
		String custto=customer.toString();
		then:
		custto != null;
	}
	

}
