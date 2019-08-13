package com.tao.music.entity;

public class MusicEntity {
	private Integer id;

	private String musicName;

	private String musicSinger;

	private String musicType;

	private byte[] musicPic;

	private byte[] musicFile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicSinger() {
		return musicSinger;
	}

	public void setMusicSinger(String musicSinger) {
		this.musicSinger = musicSinger;
	}

	public String getMusicType() {
		return musicType;
	}

	public void setMusicType(String musicType) {
		this.musicType = musicType;
	}

	public byte[] getMusicPic() {
		return musicPic;
	}

	public void setMusicPic(byte[] musicPic) {
		this.musicPic = musicPic;
	}

	public byte[] getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(byte[] musicFile) {
		this.musicFile = musicFile;
	}

	@Override
	public String toString() {
		return "MusicEntity [id=" + id + ", musicName=" + musicName + ", musicSinger=" + musicSinger + ", musicType=" + musicType + ", musicPic=" + musicPic == null ? "null"
				: "not null" + ", musicFile=" + musicFile == null ? "null" : "not null" + "]";
	}

}
