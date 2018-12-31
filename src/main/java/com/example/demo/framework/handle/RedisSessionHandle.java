package com.example.demo.framework.handle;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.StringUtils;

import com.example.demo.common.constant.CommonConstant;
import com.example.demo.common.constant.ResponseCodes;
import com.example.demo.framework.exception.DefineRuntimeException;
import com.example.demo.usermanager.vo.UserVO;

import redis.clients.jedis.Jedis;

/**
 * @author 46315
 *	初始化redis
 */
public class RedisSessionHandle {
	private final static Logger logger = LoggerFactory.getLogger(RedisSessionHandle.class);
	// redis对象
	private static Jedis jedis;
	/**
	 * 连接redis服务器
	 */
	public static void initRedis() {
		try {
			jedis = new Jedis(CommonConstant.CURRENT_IP);
		} catch (Exception e) {
			logger.error("Redis服务器连接失败！");
			
		}
	}
	
	/**
	 * 登入，保存登陆信息
	 */
	public static void loginIn(UserVO user){
	     if(jedis == null){
	    	 initRedis();
	      }
	     // 根据sessionId来存储登陆账号和名称
	     jedis.hset(user.getSessionId(), CommonConstant.LOGIN_CODE,user.getLoginCode());
	     jedis.hset(user.getSessionId(), CommonConstant.LOGIN_NAME,user.getLoginName());
	     // 登陆信息保存时间为3分钟
	     jedis.expire(user.getSessionId(), 180);
	}
	
	/**
	 * 登出注销
	 * @param request
	 */
	public static void loginOut(HttpServletRequest request){
		  if(jedis == null){
		    	 initRedis();
		  }
		  String sessionId = request.getSession().getId();
		  Set<String> set = jedis.hkeys(sessionId);
		  Iterator<String> it = set.iterator();
		  while(it.hasNext()){
			  String str = it.next();
			  jedis.hdel(sessionId, str);
		  }
	}
	
	/**
	 * 根据当前ip获取登陆信息？是ip吗，还是sessionId？
	 * @param request
	 * @return UserVO
	 * 
	 */
	public static UserVO getLoginUserInfo(HttpServletRequest request){
	     if(jedis == null){
	    	 initRedis();
	      }
		String sessionId = request.getSession().getId();
        //若当前有登陆，则返回登陆信息，若无登陆信息则返回空
        String loginCode = jedis.hget(sessionId, CommonConstant.LOGIN_CODE);
        String loginName = jedis.hget(sessionId, CommonConstant.LOGIN_NAME);
        if(StringUtils.isEmpty(loginCode) || StringUtils.isEmpty(loginName)){
        	throw new DefineRuntimeException(ResponseCodes.WARN_NOTYET_LOGIN);
        }
        UserVO user = new UserVO();
        user.setLoginCode(loginCode);
        user.setLoginName(loginName);
        user.setSessionId(sessionId);
		return user;
	}
	
    public static String getPort() {
        return CommonConstant.REDIS_PORT;
    }
    public static Jedis getJedis() {
        return jedis;
    }
}
