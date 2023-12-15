package com.devhcm.customerservice;

import com.devhcm.customerservice.entities.Customer;
import com.devhcm.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.saveAll(
					List.of(
						Customer.builder().name("said").email("said@gmail.com").build(),
						Customer.builder().name("fahd").email("fahd@gmail.com").build(),
						Customer.builder().name("omar").email("omar@gmail.com").build()
					)
			);
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
