package com.rig.ReadingIsGoodApp;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rig.ReadingIsGoodApp.models.Customer;
import com.rig.ReadingIsGoodApp.repositories.*;

@SpringBootApplication
public class ReadingIsGoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingIsGoodAppApplication.class, args);
		
			
	}
	
	@Bean
	CommandLineRunner runner(CustomerRepository repository) {
		return args -> {
			Customer customer = new Customer(
	                "Test",
	                "Tester",
	                "123456789",
	                "testermail@gmail.com",
	                "testadres",
	                "501111111"
	        );
			
			//repository.insert(customer);
		};
			
	}

}
