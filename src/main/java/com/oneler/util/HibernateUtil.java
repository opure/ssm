package com.oneler.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
            try {
                Configuration cfg = new Configuration().configure();
                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties()).build();
                SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);  
                throw new ExceptionInInitializerError(ex);  
            }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void closeSessionFactory() {
        sessionFactory.close();
    }
    public static void main(String[] args) {
        System.out.println(getSessionFactory());
        
        getSessionFactory().openSession().doWork(new Work() {
            
            @Override
            public void execute(Connection connection) throws SQLException {
                // TODO Autso-generated method stub
                System.out.println(connection);
            }
        });
    }

}
