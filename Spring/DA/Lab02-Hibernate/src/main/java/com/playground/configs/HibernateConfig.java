package com.playground.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db-config.properties")
public class HibernateConfig {


    @Autowired
    Environment environment;

    @Bean("mySqlDataSource")
    public DataSource dataSource(){
        System.out.println(">>> Data Source Created");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        return  dataSource;
    }

    @Bean("sessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.playground.domain");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    //HibernateTempalate is
    @Bean("hibernateTemplate")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public HibernateTemplate hibernateTemplate(){
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(localSessionFactoryBean().getObject());
        return hibernateTemplate;
    }

    //Transaction tempalte is thread safe because it doesnot hold any conversational  state so an insatnce may be shared
    // across multiple classes however it hold default conf. state, so if class needs to use it with diff. configs.
    //another instance shall be created
    @Bean("transactionTemplate")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TransactionTemplate transactionTemplate(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>transactionTemplate called");
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(hibernateTransactionManager());
        return transactionTemplate;
    }

    @Bean("transactionManager")
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public HibernateTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(localSessionFactoryBean().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties(){
        Properties props = new Properties();

        props.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        props.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
//        props.put("hibernate.connection.autocommit", "true");
//        props.put("org.hibernate.flushMode", "auto");
        return props;
    }

}
