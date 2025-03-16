package com.ya.SpringDevOpsIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringDevOpsIntegrationApplication {
	
	@GetMapping("/get")
	public String getMessage() {
		return "Hello Yousif";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDevOpsIntegrationApplication.class, args);
	}

}
