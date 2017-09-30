package com.carrinho.carrinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CarrinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrinhoApplication.class, args);
	}
}