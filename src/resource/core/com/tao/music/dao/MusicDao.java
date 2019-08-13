package com.tao.music.dao;

import java.util.HashMap;
import java.util.List;

import com.tao.music.entity.MusicEntity;

public interface MusicDao {

	public boolean addOne(MusicEntity musicEntity);

	public boolean delete(HashMap<String, Object> conMap);

	public MusicEntity getOneById(int id);

	public MusicEntity getOneByMameSingerUnique(String name, String singer);

	public List<MusicEntity> getAll();
}
