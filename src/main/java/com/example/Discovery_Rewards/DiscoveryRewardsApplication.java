package com.example.Discovery_Rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Allows you to serve Restful endpoints
public class DiscoveryRewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryRewardsApplication.class, args);
	}

	@GetMapping // Default endpoint
	public String hello() {
		return "HELLO WORLD!";
	}
}
