package com.example.demo.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.example.demo.common.constant.CommonConstant;

import ch.qos.logback.classic.gaffer.PropertyUtil;

/**
 * @author 46315
 *	配置文件加载类，启动时初始化
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(PropertyConfigurer.class);
	
	private static Properties props;
	// 消息配置的文件名
	private static final String RESPONSE_MESSAGE = "responseMessage.properties";
	
	/**
	 * 加载配置文件
	 */
	synchronized public static void initProps(){
        logger.info("【开始加载responseMessage.properties文件内容】.......");
		props = new Properties();
		InputStream in = null;
		
		try {
			in = PropertyUtil.class.getClassLoader().getResourceAsStream(RESPONSE_MESSAGE);
			props.load(new InputStreamReader(in, CommonConstant.UTF_8));
			logger.info("【properties文件加载完毕】");
			} catch (FileNotFoundException e) {
				logger.error("文件未找到");
			} catch (IOException e) {
				logger.error("IO异常");
			} finally {
				try {
					if (in != null) {
						in.close();
					}
				} catch (IOException e) {
					logger.error("关流失败！出现IO异常");
				}
				logger.info("关闭线程");
	            Thread.currentThread().interrupt();
			}
		
	}
	
	public static String getPropery(String key){
		if (props == null) {
			initProps();
		}
		return props.getProperty(key);
	}
	
	public static String getPropery(String key,String defaultValue ){
		if (props == null) {
			initProps();
		}
		return props.getProperty(key, defaultValue);
	}
}
