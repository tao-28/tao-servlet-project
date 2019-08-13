package com.tao.music.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import com.tao.music.dao.MusicDao;
import com.tao.music.entity.MusicEntity;
import com.tao.util.DbConUtil;
import com.tao.util.DbDataTypeChangeUtil;
import com.tao.util.DbTableUtil;

public class MusicDaoImpl implements MusicDao {
	private String tbl_music = DbTableUtil.tblMusic;

	@Override
	public boolean addOne(MusicEntity musicEntity) {
		DbConUtil.getCon();
		return false;
	}

	@Override
	public boolean delete(HashMap<String, Object> conMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MusicEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MusicEntity getOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("static-access")
	@Override
	public MusicEntity getOneByMameSingerUnique(String name, String singer) {
		MusicEntity musicEntity = new MusicEntity();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ID,MUSIC_NAME,MUSIC_SINGER,MUSIC_TYPE,MUSIC_PIC,MUSIC_FILE FROM " + tbl_music);
		if (name != null && singer != null) {
			sql.append(" WHERE MUSIC_NAME = ? AND MUSIC_SINGER = ?");
		} else {
			return null;
		}
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = DbConUtil.getInstance().getCon();
			ps = connection.prepareStatement(sql.toString());
			ps.setString(1, name);
			ps.setString(2, singer);
			ResultSet rs = ps.executeQuery();
			if (rs == null) {
				return null;
			}
			// ResultSetMetaData meta = rs.getMetaData();
			// TODO
			rs.last();
			int rowCount = rs.getRow();
			if (rowCount == 0 || rowCount > 1) {
				return null;
			}
			rs.beforeFirst();
			while (rs.next()) {
				musicEntity.setId(rs.getInt("ID"));
				musicEntity.setMusicName(rs.getString("MUSIC_NAME"));
				musicEntity.setMusicSinger(rs.getString("MUSIC_SINGER"));
				musicEntity.setMusicType(rs.getString("MUSIC_TYPE"));
				musicEntity.setMusicPic(DbDataTypeChangeUtil.blonToByteArray(rs.getBlob("MUSIC_PIC")));
				musicEntity.setMusicFile(DbDataTypeChangeUtil.blonToByteArray(rs.getBlob("MUSIC_FILE")));
			}
			return musicEntity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DbConUtil.closePs(ps);
			DbConUtil.closeCon(connection);
		}
	}

}
