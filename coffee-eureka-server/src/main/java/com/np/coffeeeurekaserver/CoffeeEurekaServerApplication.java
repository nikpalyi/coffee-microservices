package com.np.coffeeeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CoffeeEurekaServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CoffeeEurekaServerApplication.class, args);
	}

}
