package com.oneler.annotation.orm;

import org.junit.Test;

public class TestOrm {
    @Test
    public void testApp() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("caohao");
        UserDao userDao = new UserDao();
        userDao.save(user);
    }
}
