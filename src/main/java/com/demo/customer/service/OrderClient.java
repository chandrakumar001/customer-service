package com.demo.customer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.customer.constants.CustomerConstansts;
import com.demo.customer.model.OrderResponse;

//@FeignClient(name="orderService", url="http://localhost:2222/order",fallback = CustomerServiceFeignClientFallback.class)
//@FeignClient(name=CustomerConstansts.ORDER_SERVICE+CustomerConstansts.ORDER_SERVICE_CONTEXT_PATH,fallback = OrderClientFallback.class)
@FeignClient(name=CustomerConstansts.ORDER_SERVICE+CustomerConstansts.ORDER_SERVICE_CONTEXT_PATH)
public interface OrderClient {
	@GetMapping(value="/orders")
	public List<OrderResponse>  getCustomers();

}
