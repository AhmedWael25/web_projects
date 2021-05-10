package com.playground.configs;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
//@ImportResource("WEB-INF/spring/jdbc-config.xml")
@EnableTransactionManagement
public class JDBCConfig {

    //Instead of using XML, we do it here
    @Bean("mySqlDataSource")
    public DataSource dataSource(){
        System.out.println(">>> Data Source Created");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_da");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return  dataSource;
    }

    @Bean("jdbcTemplate")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        System.out.println(">>> JDBC Template Created: hashcode = "+jdbcTemplate.hashCode());
        return  jdbcTemplate;
    }

    @Bean("namedJdbcTemplate")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public NamedParameterJdbcTemplate namedJdbcTemplate(){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        System.out.println(">>> Named Param JDBC Template Created: hashcode = "+namedParameterJdbcTemplate.hashCode());
        return namedParameterJdbcTemplate;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(){
        return  new DataSourceTransactionManager(dataSource());
    }

}

