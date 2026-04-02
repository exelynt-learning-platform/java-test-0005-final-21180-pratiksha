package com.ecommerce.backend.service;

    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.ecommerce.backend.entity.*;
	import com.ecommerce.backend.repository.OrderRepository;

	@Service
	public class OrderService {

	    @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private CartService cartService;

	    public Order createOrder(Long userId) {
	        Cart cart = cartService.viewCart(userId);

	        if (cart.getItems() == null || cart.getItems().isEmpty()) {
	            throw new RuntimeException("Cart is empty for user: " + userId);
	        }

	        Order order = new Order();
	        order.setUser(cart.getUser());
	        order.setProducts(cart.getProducts()); // now works via the fixed getProducts()

	        double total = cart.getItems().stream()
	            .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
	            .sum();

	        order.setTotalPrice(total);
	        return orderRepository.save(order);
	    }
	}