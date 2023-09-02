package com.example.demo.config;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.demo.entity.Student;

@Configuration
public class DbConfig {
	
	@Value(value = "${db.driverClass}")
	private String driverClass;
	
	@Value(value = "${db.url}")
	private String url;
	
	@Value(value = "${db.username}")
	private String username;
	
	@Value(value = "${db.password}")
	private String password;
	
	@Value(value = "${hibernate.dialect}")
	private String dialect;
	
	@Value(value = "${hibernate.show_sql}")
	private String show_sql;
	
	@Value(value = "${hibernate.hbm2ddl}")
	private String hbm2ddl;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(Environment.DIALECT, dialect);
		hibernateProperties.setProperty(Environment.SHOW_SQL, show_sql);
		hibernateProperties.setProperty(Environment.HBM2DDL_AUTO, hbm2ddl);
		
		
		sf.setHibernateProperties(hibernateProperties);
		
		sf.setAnnotatedClasses(Student.class);
		
		return sf;
	}

}
