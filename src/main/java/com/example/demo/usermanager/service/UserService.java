package com.example.demo.usermanager.service;

import java.util.List;

import com.example.demo.usermanager.vo.UserVO;

public interface UserService {
	List<UserVO> findUser();

	boolean valideLoginUser(UserVO user);
	// 根据用户编号查询用户信息
	UserVO queryUserInfo(UserVO user);
	// 注册账号
	boolean registerUser(UserVO user);
}
