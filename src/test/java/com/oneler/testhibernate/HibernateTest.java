package com.oneler.testhibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oneler.entity.News;
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
    public void testPropertyUpdate(){
        News news = (News) session.get(News.class, 1);
        news.setTitle("aaaa"); 
        System.out.println(news);
    }
    
    
    @Test
    public void Test() {
        News news = new News();
        news.setAuthor("caohao");
        news.setTitle("1");
        session.save(news);
        System.out.println(news);
    }
    
    @After
    public void destroy(){
        transaction.commit();
        session.close();
        HibernateUtil.closeSessionFactory();
    }
    

}
