package com.example.Discovery_Rewards;

import com.example.Discovery_Rewards.Student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController // Allows you to serve Restful endpoints
public class DiscoveryRewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryRewardsApplication.class, args);
	}

	@GetMapping // Default endpoint
	public List<Student> hello() {
		return List.of(
			new Student(1L,"Llewellyn","llewellynant@hotmail.com", LocalDate.of(1998,01,12),23)
		);
	}
}
