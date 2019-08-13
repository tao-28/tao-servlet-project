package com.tao.user.dao;

import java.util.List;
import java.util.Map;

import com.tao.user.entity.UserEntity;

public interface UserDao {
	/**
	 * add one user
	 * 
	 * @param userEntity
	 * @return
	 */
	public int addOneUser(UserEntity userEntity);

	/**
	 * query users by condition
	 * 
	 * @param conMap
	 * @return
	 */
	public List<UserEntity> queryUserByCon(Map<String, Object> conMap);

	/**
	 * query one user by condition
	 * 
	 * @param userAccontNo
	 * @param userPawd
	 * @return
	 */
	public UserEntity queryOneUser(String userAccontNo, String userPawd);
}
