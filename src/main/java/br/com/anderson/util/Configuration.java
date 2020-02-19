package br.com.anderson.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	private Properties props;
	
	private Configuration(String archive) {
		load(null, archive);
	}
	
	private Configuration(String serverProperty, String archive) {
		load(serverProperty, archive);
	}
	
	private void loadLocalFile(String archive) {
		props = new Properties();
		try {
			props.load(getClass().getClassLoader().getResourceAsStream(archive));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} 
	}
	
	private void loadServerFile(String propertiesPath) {
		props = new Properties();
		try {
			File f = new File(propertiesPath);
			props.load(new FileInputStream(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void load(String serverProperty, String archive) {
		if (serverProperty == null) {
			loadLocalFile(archive);
			return;
		}
		
		String propertiesPath = System.getProperty(serverProperty);
		if (propertiesPath != null && !propertiesPath.trim().equals("")) {
			loadServerFile(propertiesPath);
		} else {
			loadLocalFile(archive);
		}
	}
	
	public String get(String key) {
		return props.getProperty(key);
	}
	
	public static Configuration getInstance(String serverProperty, String archive) {
		return new Configuration(serverProperty, archive);
	}
	
	public static Configuration getInstance(String archive) {
		return new Configuration(archive);
	}
}
