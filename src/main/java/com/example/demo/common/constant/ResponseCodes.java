package com.example.demo.common.constant;

public class ResponseCodes {
    //系统错误
    public static final String ERR_SYS_ERROR = "100000";
    //空的账号或密码
    public static final String WARN_EMPTY_LOGIN = "900000";
    //账号或密码错误
    public static final String WARN_WRONG_LOGIN = "900001";
    //还未登陆系统
    public static final String WARN_NOTYET_LOGIN = "900002";
    //Redis服务连接异常！
    public static final String ERR_REDIS_SEVER_ERROR = "900003";
    
    public static final String OVER_CONNECT = "900005";
    //excel_io_error
    public static final String EXCEL_IO_ERROR = "800001";
}
