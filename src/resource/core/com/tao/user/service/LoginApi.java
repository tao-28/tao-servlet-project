package com.tao.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tao.entity.PromptEntity;

public interface LoginApi {
	/**
	 * 判断用户是否已经登录
	 * 
	 * @param req
	 * @param resp
	 * @param cruUserId
	 * @return
	 */
	public boolean isLoggedIn(HttpServletRequest req, HttpServletResponse resp, String cruUserId);

	/**
	 * 登录
	 * 
	 * @param userAccontNo
	 * @param userPawd
	 * @return
	 */
	public PromptEntity doLogin(String userAccontNo, String userPawd);
}
