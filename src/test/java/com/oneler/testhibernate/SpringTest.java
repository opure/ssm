package com.oneler.testhibernate;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void testSessionFactory() throws Exception {
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
        sessionFactory.openSession().doWork(new Work() {
            
            @Override
            public void execute(Connection arg0) throws SQLException {
                // TODO Auto-generated method stub
                System.out.println("dd"+arg0);
            }
        });
        System.out.println(sessionFactory);
    }
    
    @Test
    public void testSession() {
        TestService testService = (TestService) ac.getBean("testService");
        testService.testSession();
    }

}
