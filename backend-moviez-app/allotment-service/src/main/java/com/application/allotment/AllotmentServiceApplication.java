package com.application.allotment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.application.allotment.feignproxy")
public class AllotmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllotmentServiceApplication.class, args);
	}

}
