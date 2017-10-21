package com.hackerxiehao.hnrmgmt.util;

import java.util.Map;

import com.hackerxiehao.hnrmgmt.entities.ApiResult;

public class ApiResultUtils {

	private static ApiResult apiResult;

	public ApiResultUtils() {

	}

	/**
	 * 发生错误，返回错误信息
	 * 
	 * @param message
	 * @return
	 */
	public static ApiResult error(String messages) {
		apiResult = new ApiResult();
		apiResult.setStatus("error");
		apiResult.setMessages(messages);
		return apiResult;
	}

	/**
	 * 返回错误信息及错误字段
	 * 
	 * @param message
	 * @param fieldErrors
	 * @return
	 */
	public static ApiResult error(String messages, Map<String, String> fieldErrors) {
		apiResult = new ApiResult();
		apiResult.setStatus("error");
		apiResult.setMessages(messages);
		apiResult.setFieldErrors(fieldErrors);
		return apiResult;
	}

	/**
	 * 验证成功 返回信息
	 * 
	 * @param message
	 * @return
	 */
	public static ApiResult success(String messages) {
		apiResult = new ApiResult();
		apiResult.setStatus("success");
		apiResult.setMessages(messages);
		return apiResult;
	}
	
	/**
	 * 操作成功，返回信息及数据
	 * @param message
	 * @param data
	 * @return
	 */
	public static ApiResult success(String messages, Object data) {
		apiResult = new ApiResult();
		apiResult.setStatus("success");
		apiResult.setMessages(messages);
		apiResult.setData(data);
		return apiResult;
	}

}
