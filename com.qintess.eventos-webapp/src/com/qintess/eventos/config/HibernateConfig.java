package com.qintess.eventos.config;


import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.qintess.eventos.model");
		sessionFactory.setHibernateProperties(hibernateProrperties());
		
		return sessionFactory;
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:56137/Eventos");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername("postegres");
		dataSource.setPassword("12345678");
		
		return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		
		return transactionManager;
	}
	
	private final Properties hibernateProrperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hdm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Dialect");
		hibernateProperties.setProperty("hibernate.show_sql","true");
		hibernateProperties.setProperty("hibernate.jdbc.time_zone","UTC");
		
		return hibernateProperties;	
	}
	
	
}
