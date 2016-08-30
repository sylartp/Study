package com.huidao.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**Config��ȡϵͳ�����ļ�
 * @author Administrator
 *
 */
public class Config {
	private Properties  table = new Properties();
	public Config(String fileName){
		//��ȡ�����ļ�
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
