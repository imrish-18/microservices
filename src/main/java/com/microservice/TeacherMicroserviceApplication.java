package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.microservice.EmployeeRepository")
public class TeacherMicroserviceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(TeacherMicroserviceApplication.class, args);
		System.out.println("hello");
	}
}
