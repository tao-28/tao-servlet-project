package com.tao.user.entity;

import java.sql.Date;

/**
 * 
 * @author tao
 *
 */
public class UserEntity {
	private Integer id;

	private String userAccountNo;

	private String userPawd;

	private String userName;

	private Date updateTime;

	private byte[] photo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAccountNo() {
		return userAccountNo;
	}

	public void setUserAccountNo(String userAccountNo) {
		this.userAccountNo = userAccountNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPawd() {
		return userPawd;
	}

	public void setUserPawd(String userPawd) {
		this.userPawd = userPawd;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
