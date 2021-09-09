package com.javatechie.aws.lambda.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {

    @Primary
    @Bean
    public DataSource mysqlDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://database-master.cqnvgpqoyyuu.us-east-2.rds.amazonaws.com:3306/db_sunafil_dev");
        dataSource.setUsername("admin");
        dataSource.setPassword("51st3ma$2021.");
        return dataSource;
    }

}
