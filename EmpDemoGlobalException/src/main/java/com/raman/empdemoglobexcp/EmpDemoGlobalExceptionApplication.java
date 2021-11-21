package com.raman.empdemoglobexcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmpDemoGlobalExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDemoGlobalExceptionApplication.class, args);
	}

}
