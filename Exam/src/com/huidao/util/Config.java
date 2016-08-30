package com.huidao.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**Config读取系统配置文件
 * @author Administrator
 *
 */
public class Config {
	private Properties  table = new Properties();
	public Config(String fileName){
		//读取配置文件
		try {
			table.load(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public int getInt(String key){
		return Integer.valueOf(table.getProperty(key));
	}
	public String getString(String key){
		return table.getProperty(key);
	}
	public double getDouble(String key){
		return Double.valueOf(table.getProperty(key));
	}
	
}
