package com.courierservice.courierservicebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


@SpringBootApplication
@EnableEncryptableProperties
public class CourierServiceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourierServiceBackendApplication.class, args);
	}

}
