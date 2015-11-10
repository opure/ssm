package com.oneler.mybatis.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oneler.mybatis.dao.UserMapper;
import com.oneler.mybatis.models.User;
import com.oneler.mybatis.services.UserService;
@Service("userService")
public class UserMapperImpl implements UserService{
	@Resource
	 private UserMapper userMapper;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		 userMapper.insert(user);
		
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

    
}
