package com.oneler.testhibernate;


import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

public class dfsa {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    
    @Before
    public void init(){
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = 
                new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                                            .buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }
    
    @Test
    public void testaa() {
        session.doWork(new Work() {
            
            @Override
            public void execute(Connection connection) throws SQLException {
                // TODO Auto-generated method stub
                System.out.println(connection);
            }
        });
    }
    

}
