package com.example.demo.usermanager.vo;


public class UserVO {
	// 表主键id
	private Integer id;
	// 登陆账号
	private String loginCode;
	private String loginName;
	private String loginIp;
	// 登陆密码
	private String loginPsd;
	
	private String adress;
	// 男1女2
	private Integer sex;
	private Integer age;
	private String sessionId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginPsd() {
		return loginPsd;
	}
	public void setLoginPsd(String loginPsd) {
		this.loginPsd = loginPsd;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", loginCode=" + loginCode + ", loginName=" + loginName + ", loginIp=" + loginIp
				+ ", loginPsd=" + loginPsd + ", adress=" + adress + ", sex=" + sex + ", age=" + age + ", sessionId="
				+ sessionId + "]";
	}



}
