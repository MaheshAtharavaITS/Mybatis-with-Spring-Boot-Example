package com.mybatis.xmlbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MappedTypes(Common_Movie_Actor_Mapper.class)
@MapperScan("com.mybatis.xmlbase.mappers")
@SpringBootApplication
public class XmlbaseMyBatisWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlbaseMyBatisWithSpringBootApplication.class, args);
		System.out.println("Welcome in xml base MyBatis Project");
	}

}
