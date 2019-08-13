package com.tao.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tao.entity.PromptEntity;

public interface LoginApi {
	/**
	 * �ж��û��Ƿ��Ѿ���¼
	 * 
	 * @param req
	 * @param resp
	 * @param cruUserId
	 * @return
	 */
	public boolean isLoggedIn(HttpServletRequest req, HttpServletResponse resp, String cruUserId);

	/**
	 * ��¼
	 * 
	 * @param userAccontNo
	 * @param userPawd
	 * @return
	 */
	public PromptEntity doLogin(String userAccontNo, String userPawd);
}
