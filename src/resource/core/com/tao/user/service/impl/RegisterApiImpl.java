package com.tao.user.service.impl;

import com.tao.entity.PromptEntity;
import com.tao.user.dao.UserDao;
import com.tao.user.dao.impl.UserDaoImpl;
import com.tao.user.entity.UserEntity;
import com.tao.user.service.RegisterApi;

public class RegisterApiImpl implements RegisterApi {
	private UserDao UserDao = new UserDaoImpl();

	@Override
	public PromptEntity doLogin(UserEntity userEntity) {
		PromptEntity promptEntity = new PromptEntity();
		int resNo = UserDao.addOneUser(userEntity);
		promptEntity.setId(resNo);
		if (resNo < 0) {
			promptEntity.setMsg("×¢²áÊ§°Ü");
		} else {
			promptEntity.setMsg("successful");
		}
		return promptEntity;
	}

}
