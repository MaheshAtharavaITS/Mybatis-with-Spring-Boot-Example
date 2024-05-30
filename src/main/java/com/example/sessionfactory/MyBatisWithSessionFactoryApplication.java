package com.example.sessionfactory;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyBatisWithSessionFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisWithSessionFactoryApplication.class, args);
		System.out.println("App started----------------------");
	}



}
