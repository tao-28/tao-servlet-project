package com.tao.load;

import java.io.FileInputStream;
import java.util.Properties;

import com.tao.entity.DbEntity;

public class DbPropertiesLoad {
	public static DbEntity dbEntity = null;

	public static DbEntity getInstance() {
		if (dbEntity == null) {
			dbEntity = createDBEntity();
		}
		return dbEntity;
	}

	private static DbEntity createDBEntity() {
		DbPropertiesLoad dbPropertiesLoad = new DbPropertiesLoad();
		String dataProPath = dbPropertiesLoad.getClass().getClassLoader().getResource("").getPath() + "/dataSource.properties";
		DbEntity dbEntity = new DbEntity();
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(dataProPath);
			properties.load(fis);
			dbEntity.setDriver(properties.getProperty("driver"));
			dbEntity.setUrl(properties.getProperty("url"));
			dbEntity.setName(properties.getProperty("name"));
			dbEntity.setPassword(properties.getProperty("password"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dbEntity;
	}

	public static void main(String[] args) {
		DbPropertiesLoad.getInstance();

	}
}
