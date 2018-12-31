package com.example.demo.framework.exception;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.config.PropertyConfigurer;

public class DefineRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -237260648276760302L;
	
	public DefineRuntimeException(String code){
		String msg = PropertyConfigurer.getPropery(code);
		if (StringUtils.isEmpty(msg)) {
			msg = "";
		}
		throw new CommonDefineException(code, msg);
	}
	
    public DefineRuntimeException(String code, String msg){
        throw new CommonDefineException(code, msg);
    }

}
