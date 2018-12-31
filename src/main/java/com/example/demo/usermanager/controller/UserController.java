package com.example.demo.usermanager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.constant.ResponseCodes;
import com.example.demo.framework.ResponseModel;
import com.example.demo.framework.exception.DefineRuntimeException;
import com.example.demo.framework.handle.RedisSessionHandle;
import com.example.demo.usermanager.service.UserService;
import com.example.demo.usermanager.vo.UserVO;

@RestController
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	public ResponseModel getUser(HttpServletRequest request){
		ResponseModel model = new ResponseModel();
		
		List<UserVO> userList = userService.findUser();
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).toString());
		}
		model.setResult(userList);
		return model;
	}
	
    @RequestMapping("/demo")
    public String demo(){
        return "demo";//地址指向demo.html?
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel login(UserVO user, HttpServletRequest request){
    	ResponseModel model = new ResponseModel();
    	String sessionId = request.getSession().getId();
    	if (user != null) {
    		// 少了把密码加密成MD5的转化
    		// 查询用户信息是否在数据库中存在
    		if (userService.valideLoginUser(user)) {
				UserVO userVO = userService.queryUserInfo(user);
				user.setLoginName(userVO.getLoginName());
				user.setSessionId(sessionId);
				// 登入时进redis
				RedisSessionHandle.loginIn(user);
				model.setResult(userVO);
                logger.info("【当前登陆用户】");
                logger.info("【账号】" + user.getLoginCode());
                logger.info("【昵称】" + user.getLoginName());
			} else {
				// 报错，数据库中不存在该信息
				logger.info("【数据库中不存在该信息】");
				throw new DefineRuntimeException(ResponseCodes.WARN_WRONG_LOGIN);
			}
		} else {
			// 报错，未登陆
			logger.info("【未登陆】");
			throw new DefineRuntimeException(ResponseCodes.WARN_NOTYET_LOGIN);
		}
		return model;
    }
    
    /**
     * 注销登陆操作
     * @return
     */
    @RequestMapping(value="/loginOut", method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel loginOut(HttpServletRequest request) {
    		ResponseModel model = new ResponseModel();
    		RedisSessionHandle.loginOut(request);
    		return model;
    }
    
    /**
     * 获取登陆信息
     * @param request
     * @return
     */
    @RequestMapping(value="/currentLoginInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel getCurrentLoginInfo(HttpServletRequest request){
    	ResponseModel model = new ResponseModel();
    	model.setResult(RedisSessionHandle.getLoginUserInfo(request));
		return model;
    }
    
    /**
     * 注册账号
     * @param user
     * @return
     */
    @RequestMapping(value="/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel register(UserVO user) {
    		ResponseModel model = new ResponseModel();
    		boolean isSuccess = userService.registerUser(user);
    		if (isSuccess) {
    			model.setResponseMsg("注册成功！");
			} else {
				model.setResponseCode("10000");
				model.setResponseMsg("注册失败！");
			}
    		return model;
    }

}
