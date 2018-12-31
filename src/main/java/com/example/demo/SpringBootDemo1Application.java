package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.config.InitSystem;

@SpringBootApplication
public class SpringBootDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo1Application.class, args);
		// 初始化系统参数信息
		InitSystem.init();
	}
}
