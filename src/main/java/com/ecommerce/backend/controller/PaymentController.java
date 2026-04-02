package com.ecommerce.backend.controller;



	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.ecommerce.backend.entity.Order;
	import com.ecommerce.backend.repository.OrderRepository;

	import java.util.UUID;

	@RestController
	@RequestMapping("/payment")
	public class PaymentController {

	    @Autowired
	    private OrderRepository orderRepository;

	    @PostMapping("/{orderId}")
	    public Order processPayment(@PathVariable("orderId")Long orderId) {

	        Order order = orderRepository.findById(orderId)
	                .orElseThrow(() -> new RuntimeException("Order not found"));

	        // Simulate payment
	        order.setPaymentStatus("SUCCESS");
	        order.setPaymentId(UUID.randomUUID().toString());

	        return orderRepository.save(order);
	    }
	}


