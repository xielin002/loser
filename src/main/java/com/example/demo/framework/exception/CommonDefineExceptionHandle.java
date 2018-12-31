package com.example.demo.framework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义返回异常，用于参数校验等的固定模板
 */
@ControllerAdvice
@ResponseBody
public class CommonDefineExceptionHandle {
	private final static String RESPONSE_MSG = "responseMsg";
	private final static String RESPONSE_CODE = "responseCode";
	
    @ExceptionHandler(CommonDefineException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerMyRuntimeException(CommonDefineException ex) {
        Map<String,Object> result = new HashMap<>();
        result.put(RESPONSE_MSG, ex.getMessage());
        result.put(RESPONSE_CODE, ex.getExceptionCode());
        return result;
    }
}
