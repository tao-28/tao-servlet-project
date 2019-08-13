package com.tao.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.tao.user.dao.UserDao;
import com.tao.user.entity.UserEntity;
import com.tao.util.DbConUtil;
import com.tao.util.DbTableUtil;

public class UserDaoImpl implements UserDao {
	private String tbl_user_base = DbTableUtil.tblUserBase;

	@Override
	public int addOneUser(UserEntity userEntity) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO " + tbl_user_base + " (USERACCOUNTNO,USERPAWD) VALUES (?,?)");
		@SuppressWarnings("static-access")
		Connection con = DbConUtil.getInstance().getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, userEntity.getUserAccountNo());
			ps.setString(2, userEntity.getUserPawd());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.toString());
			return -1;
		} finally {
			DbConUtil.closePs(ps);
			DbConUtil.closeCon(con);
		}

	}

	@Override
	public UserEntity queryOneUser(String userAccontNo, String userPawd) {
		StringBuffer sql = new StringBuffer();
		UserEntity userEntity = new UserEntity();
		sql.append("SELECT * FROM " + tbl_user_base + " WHERE  USERACCOUNTNO = ? AND USERPAWD = ?");
		PreparedStatement ps = null;
		@SuppressWarnings("static-access")
		Connection con = DbConUtil.getInstance().getCon();
		try {
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, userAccontNo);
			ps.setString(2, userPawd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userEntity.setUserAccountNo(rs.getString("USERACCOUNTNO"));
				userEntity.setUserPawd(rs.getString("USERPAWD"));
			}
			return userEntity;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		} finally {
			DbConUtil.closePs(ps);
			DbConUtil.closeCon(con);
		}
	}

	@Override
	public List<UserEntity> queryUserByCon(Map<String, Object> conMap) {

		// TODO
		return null;
	}

}
