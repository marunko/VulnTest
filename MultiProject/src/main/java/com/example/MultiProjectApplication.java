package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MultiProjectApplication {

	@Autowired 
	private DataSource datasource;
	
	public static void main(String[] args) {
		SpringApplication.run(MultiProjectApplication.class, args);
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(datasource);
	}
	@Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(datasource);
    }


}
