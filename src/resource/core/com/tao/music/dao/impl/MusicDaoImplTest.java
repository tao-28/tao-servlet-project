package com.tao.music.dao.impl;

import org.junit.Test;

import com.tao.music.dao.MusicDao;
import com.tao.music.entity.MusicEntity;

public class MusicDaoImplTest {

	@Test
	public void testGetOneByMameSingerUnique() {
		MusicDao musicDao = new MusicDaoImpl();
		MusicEntity musicEntity = musicDao.getOneByMameSingerUnique("�й�", "tao");
		System.out.println(musicEntity.getMusicName());
	}

}
