package com.alexandresp15.challenge01.services;

import org.springframework.stereotype.Service;

import com.alexandresp15.challenge01.entities.Order;

@Service
public class OrderService {
	
	private ShippingService shippingService;
	
	public OrderService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	public double total(Order order) {
		return order.getBasic() - (order.getDiscont() / 100 * order.getBasic())  + shippingService.shipment(order); 
	}

}
