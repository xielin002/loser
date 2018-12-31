package com.example.demo.usermanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.usermanager.dao.UserMapper;
import com.example.demo.usermanager.service.UserService;
import com.example.demo.usermanager.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userDao;

	@Override
	public List<UserVO> findUser() {
		System.out.println("wo q   a  ");
		
		return userDao.findUser();
	}

	@Override
	public boolean valideLoginUser(UserVO user) {
		int count = userDao.countUser(user);
		return count > 0 ? true : false;
	}

	@Override
	public UserVO queryUserInfo(UserVO user) {
		return userDao.queryUserInfo(user);
	}

	@Override
	public boolean registerUser(UserVO user) {
		int count = userDao.countUserByLoginCode(user.getLoginCode());
		boolean isRegister = true;
		if (count > 0) {
			isRegister = false;
		}
		if (isRegister) {
			userDao.insertUser(user);
		}
		return isRegister; 
	}
}
