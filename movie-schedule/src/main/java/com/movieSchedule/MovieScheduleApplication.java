package com.movieSchedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.*")
@EnableJpaRepositories("com.*")
@EntityScan("com.*")
public class MovieScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieScheduleApplication.class, args);
	}

}
