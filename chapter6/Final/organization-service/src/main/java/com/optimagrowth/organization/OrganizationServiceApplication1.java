package com.optimagrowth.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class OrganizationServiceApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication1.class, args);
	}

}
