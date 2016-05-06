package com.oneler.testhibernate;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

@Service("testService")
@Transactional
public class TestService {
    @Resource
    private SessionFactory sessionFactory;
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void testSession() {
        getSession().doWork(new Work() {
            
            @Override
            public void execute(Connection connection) throws SQLException {
                // TODO Auto-generated method stub
                System.out.println("1111111111111111"+connection);
                
            }
        });
    }

}
