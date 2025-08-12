package com.estudos_1.aula;

import com.estudos_1.aula.entity.Order;
import com.estudos_1.aula.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	private OrderService orderService;

	public AulaApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		Integer cod = sc.nextInt();
		Double basic = sc.nextDouble();
		Double discount = sc.nextDouble();

		var order = new Order(cod, basic, discount);

		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: R$ " + orderService.total(order));
	}
}
