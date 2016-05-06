package com.oneler.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

public class SpringHibernateUtil {
    @Resource
    private static SessionFactory sessionFactory;
    
    
    protected static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public static void closeSessionFactory() {
        sessionFactory.close();
    }
    public static void main(String[] args) {
        
        sessionFactory.getCurrentSession().doWork(new Work() {
            
            @Override
            public void execute(Connection connection) throws SQLException {
                // TODO Autso-generated method stub
                System.out.println(connection);
            }
        });
    }
}
