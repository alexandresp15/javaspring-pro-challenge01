package com.alexandresp15.challenge01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandresp15.challenge01.entities.Order;
import com.alexandresp15.challenge01.services.OrderService;

@SpringBootApplication
public class Challenge01Application implements CommandLineRunner {
	
	private OrderService orderService;
	
	public Challenge01Application(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		
		SpringApplication.run(Challenge01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Olá equipe Devsuperior");
		
		Order order1 = new Order(1034, 150.00, 20.0);
		Order order2 = new Order(2282, 800.00, 10.0);
		Order order3 = new Order(1309, 95.90, 0.0);
		
		System.out.println("Pedido código " + order1.getCode());
		System.out.printf("Valor total: R$ %.2f%n%n", orderService.total(order1));
		
		System.out.println("Pedido código " + order2.getCode());
		System.out.printf("Valor total: R$ %.2f%n%n", orderService.total(order2));	
		
		System.out.println("Pedido código " + order3.getCode());
		System.out.printf("Valor total: R$ %.2f%n%n", orderService.total(order3));	
		
	}

}
