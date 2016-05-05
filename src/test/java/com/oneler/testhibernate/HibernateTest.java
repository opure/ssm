package com.oneler.testhibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oneler.entity.entity.News;
import com.oneler.util.HibernateUtil;

public class HibernateTest {

    private Session session;
    private Transaction transaction;
    
    @Before
    public void init(){
        session =HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    @Test
    public void Test() {
        News news = new News();
        news.setAuthor("caohao");
        news.setTitle("1");
        session.save(news);
    }
    
    @After
    public void destroy(){
        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
    

}