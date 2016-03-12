package com.oneler.testhibernate;

import org.hibernate.Session;

import com.oneler.hibernate.utils.HibernateUtil;

import entity.News;

public class Test {
    Session session;
    @org.junit.Test
    public void testAdd() {
        session = HibernateUtil.openSession();
        session.beginTransaction();
    }

}
