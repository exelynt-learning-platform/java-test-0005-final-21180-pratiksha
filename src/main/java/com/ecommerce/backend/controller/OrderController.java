package com.ecommerce.backend.controller;

    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

	import com.ecommerce.backend.entity.Order;
	import com.ecommerce.backend.service.OrderService;

	@RestController
	@RequestMapping("/orders")
	public class OrderController {

	    @Autowired
	    private OrderService orderService;

	    @PostMapping("/{userId}")
	    public Order createOrder(@PathVariable ("userId") Long userId) {
	        return orderService.createOrder(userId);
	    }
	}

