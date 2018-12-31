package com.example.demo.framework;

public class ResponseModel {

	private String responseCode;
	private String responseMsg;
	private Object result;

	public ResponseModel() {
		this.responseCode = "0";
		this.responseMsg = "操作成功！";
	}

	public ResponseModel(String responseCode, String responseMsg) {
		this.responseMsg = responseMsg;
		this.responseCode = responseCode;
	}

	public static ResponseModel success() {
		return new ResponseModel();
	}

	public static ResponseModel fail() {
		ResponseModel fail = new ResponseModel();
		fail.setResponseCode("40000");
		fail.setResponseMsg("请求失败！");
		return fail;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResponseModel{" + "responseCode='" + responseCode + '\'' + ", responseMsg='" + responseMsg + '\'' + '}';
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

}
