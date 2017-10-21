package com.hackerxiehao.hnrmgmt.entities;

import java.util.Map;

public class ApiResult {
	private String status;
	private String messages;
	private Map<String, String> fieldErrors;
	private Object data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public Map<String, String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(Map<String, String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ApiResult(String status, String messages, Map<String, String> fieldErrors, Object data) {
		super();
		this.status = status;
		this.messages = messages;
		this.fieldErrors = fieldErrors;
		this.data = data;
	}

	public ApiResult() {
		super();
	}

}
