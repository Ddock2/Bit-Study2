package com.bit.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	private Map<String, Controller> mappings = null;
	
	public HandlerMapping() {
		this("D:/git/bit2/java-workspace/jboard/bean.properties");
	}
	
	public HandlerMapping(String configName) {
		mappings = new HashMap<String, Controller>();
		
		Properties prop = new Properties();
		
		try {
			InputStream inputStream = new FileInputStream(configName);
			prop.load(inputStream);
			
			Set<Object> keys = prop.keySet();	// 반환 타입 : Set<Object>
			
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());	// Object로 받은 key를 문자열로 받도록
				
				/*
					패키지를 import하지 않고, 직접입력으로도 객체 접근이 가능
						import java.util.Scanner
						...
						Scanner sc = new Scanner(System.in);
						를 일반적으로 사용하지만,
						
						java.util.Scanner sc = new java.util.Scanner(System.in);
						도 가능하다
				*/
				
				// className -> com.bit.controller.LoginFormController
				Class<?> classes = Class.forName(className);
				
				mappings.put(key.toString(), (Controller) classes.newInstance());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 요청 들어온 uri에 대한 Controller 객체를 반환
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
	
}
