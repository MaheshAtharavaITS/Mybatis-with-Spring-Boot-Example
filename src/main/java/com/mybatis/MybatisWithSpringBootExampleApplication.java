package com.mybatis;

import com.mybatis.model.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(User.class)
@MapperScan("com.mybatis.mapper")
@SpringBootApplication
public class MybatisWithSpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisWithSpringBootExampleApplication.class, args);
		System.out.println("Application start successfully");
	}

}
