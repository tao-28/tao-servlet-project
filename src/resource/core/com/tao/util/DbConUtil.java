package com.tao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tao.entity.DbEntity;
import com.tao.load.DbPropertiesLoad;

public class DbConUtil {
	private static DbEntity dbEntity = null;
	private static DbConUtil dbConUtil = null;

	public static DbConUtil getInstance() {
		if (dbConUtil == null) {
			dbConUtil = new DbConUtil();
			dbEntity = DbPropertiesLoad.getInstance();
		}
		return dbConUtil;
	}

	public static Connection getCon() {
		try {
			Class.forName(dbEntity.getDriver());
			Connection con = DriverManager.getConnection(dbEntity.getUrl(), dbEntity.getName(), dbEntity.getPassword());
			return con;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	public static void closeCon(Connection con) {

		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}

	}

	public static void closePs(PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
}
