package com.arvatosystems.services;

import javax.annotation.Resource;

import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.stereotype.Component;

import com.arvatosystems.dto.UserDTO;
import com.gemstone.gemfire.cache.query.SelectResults;

@Component
public class UsersService {

	@Resource(name="usersCacheClient")
	private GemfireTemplate usersCacheClient;

	public UserDTO putInCache(String key, UserDTO value){
		return usersCacheClient.put(key, value);
	}
	
	public String putInCache(String key, String value){
		return usersCacheClient.put(key, value);
	}
	
	public UserDTO getFromCache(String key){
		return usersCacheClient.get(key);
	}
	
	public SelectResults getAll(){
		return usersCacheClient.query("true");
	}
}
