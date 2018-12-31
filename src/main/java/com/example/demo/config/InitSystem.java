package com.example.demo.config;

import com.example.demo.framework.handle.RedisSessionHandle;

public class InitSystem {

	public static void init() {
		// 初始化redis服务
		RedisSessionHandle.initRedis();
		// 初始化配置文件properties信息
		Thread t = new Thread(){
			public void run(){
				PropertyConfigurer.initProps();
			}
		};
		t.setName("PropertyConfigurer");
		t.start();
	}

}
