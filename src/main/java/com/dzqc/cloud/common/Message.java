package com.dzqc.cloud.common;

public interface Message {

	String SERVER_ERROR = "服务器错误";

	/**
	 * 默认状态登陆凭证的过期时间
	 */
	int DEFAULT_EXPIRED_SECONDS = 3600 * 12; //12小时


	/**
	 * "记住我"状态登陆凭证的过期时间
	 */
	int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100; //100天
}
