package com.raman.empdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDemoApplication.class, args);
	}

}
