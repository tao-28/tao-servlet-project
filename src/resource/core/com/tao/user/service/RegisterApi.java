package com.tao.user.service;

import com.tao.entity.PromptEntity;
import com.tao.user.entity.UserEntity;

public interface RegisterApi {
	/**
	 * ע�����
	 * 
	 * @param userEntity
	 * @return
	 */
	public PromptEntity doLogin(UserEntity userEntity);
}
