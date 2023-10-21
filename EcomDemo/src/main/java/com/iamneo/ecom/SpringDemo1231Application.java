package com.iamneo.ecom;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.iamneo.ecom.model"})
public class SpringDemo1231Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo1231Application.class, args);
	}

}
