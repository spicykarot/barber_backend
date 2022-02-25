package com.man.barber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication
public class BarberApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarberApplication.class, args);
	}

}
