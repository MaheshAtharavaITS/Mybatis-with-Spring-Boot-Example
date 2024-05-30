package com.example.sessionfactory.config;

import jakarta.annotation.PostConstruct;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
@Component
public class DatabaseConfig {

    private static SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    private void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Bean
    public static SqlSessionFactory getSqlSessionFactory()
    {
       return sqlSessionFactory;

    }
}
