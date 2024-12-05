package com.sportsExercise.sportsApi;

import com.sportsExercise.sportsApi.controller.SportsController;
import com.sportsExercise.sportsApi.service.SportsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsApiApplication.class, args);
	}

}
