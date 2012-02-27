package com.arvatosystems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arvatosystems.beans.SimpleBean;

@Component
public class HelloWorldService {
	
	@Autowired
	private SimpleBean simpleBean;
	
	public String helloWorld(){
		return simpleBean.helloWorld();
	}
	
	
	public static void main(String[] args) {
		HelloWorldService test = new HelloWorldService();
	}
}
