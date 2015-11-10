package com.oneler.mybatis.services;

import com.oneler.mybatis.models.User;

public interface UserService{
	    /**
	     * 添加用户
	     * @param user
	     */
	    void addUser(User user);
	    
	    /**
	     * 根据用户id获取用户
	     * @param userId
	     * @return
	     */
	     User getUserById(Integer userId);
}
