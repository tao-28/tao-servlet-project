package com.tao.user.service.impl;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tao.entity.PromptEntity;
import com.tao.user.dao.UserDao;
import com.tao.user.dao.impl.UserDaoImpl;
import com.tao.user.entity.UserEntity;
import com.tao.user.service.LoginApi;

public class LoginApiImpl implements LoginApi {
	private UserDao userDao = new UserDaoImpl();

	@SuppressWarnings("unchecked")
	@Override
	public boolean isLoggedIn(HttpServletRequest req, HttpServletResponse resp, String cruUserId) {
		try {
			if (cruUserId == null || "".equals(cruUserId)) {
				return false;
			}
			Set<String> userIdSet = (Set<String>) req.getSession().getAttribute("userIdSet");
			if (userIdSet == null || userIdSet.isEmpty()) {
				return false;
			}
			for (String string : userIdSet) {
				if (cruUserId.equals(string)) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}

	}

	@Override
	public PromptEntity doLogin(String userAccontNo, String userPawd) {
		PromptEntity promptEntity = new PromptEntity();
		if (userAccontNo == null || "".equals(userAccontNo)) {
			promptEntity.setId(-1);
			promptEntity.setMsg("用户名不能为空");
			return promptEntity;
		}
		if (userPawd == null || "".equals(userPawd)) {
			promptEntity.setId(-2);
			promptEntity.setMsg("密码不能为空");
			return promptEntity;
		}
		UserEntity userEntity = userDao.queryOneUser(userAccontNo, userPawd);
		if (userEntity == null) {
			promptEntity.setId(-3);
			promptEntity.setMsg("用户不存在或者密码错误");
			return promptEntity;
		}
		if (userAccontNo.equals(userEntity.getUserAccountNo()) && userPawd.equals(userEntity.getUserPawd())) {
			promptEntity.setId(1);
			promptEntity.setMsg("successful");
			return promptEntity;
		}
		promptEntity.setId(0);
		promptEntity.setMsg("fail");
		return promptEntity;
	}

}
