package com.example.demolibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemolibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemolibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
				System.out.println("Application is started");
		};
	}


}
