package com.example.sessionfactory.config;

import jakarta.annotation.PostConstruct;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;


import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;
@Component
public class Db1DatabaseConfig {
    private static SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    @Primary
    private void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
