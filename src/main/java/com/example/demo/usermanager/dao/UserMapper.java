package com.example.demo.usermanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.usermanager.vo.UserVO;

@Mapper
@Repository
public interface UserMapper {
	List<UserVO> findUser();

	int countUser(UserVO user);

	UserVO queryUserInfo(UserVO user);

	int countUserByLoginCode(String loginCode);

	void insertUser(UserVO user);
}
