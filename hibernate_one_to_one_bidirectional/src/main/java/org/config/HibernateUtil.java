package org.config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil
{
   public static SessionFactory getSessionFactory()
   {
	   Properties prop = new Properties();
		   prop.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
		   prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/world");
		   prop.setProperty("hibernate.connection.username", "root");
		   prop.setProperty("hibernate.connection.password", "root");
		   prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		   prop.setProperty("hibernate.use_sql_comments", "true");
		   prop.setProperty("hibernate.show_sql", "true");
		   prop.setProperty("hibernate.format_sql", "true");
		   prop.setProperty("hibernate.hbm2ddl.auto", "update");
	   
	   Configuration cfg = new Configuration();
		   cfg.addAnnotatedClass(org.entity.StudentDetails.class);
		   cfg.addAnnotatedClass(org.entity.Student.class);
		   cfg.setProperties(prop);
	   
	   ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			   								.applySettings(cfg.getProperties()).build();
	   
	   return cfg.buildSessionFactory(serviceRegistry);
   }
}

