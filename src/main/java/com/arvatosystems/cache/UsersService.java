package com.arvatosystems.cache;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.stereotype.Component;

import com.arvatosystems.dto.UserDTO;

@Component
public class UsersService {

	@Resource
	private GemfireTemplate usersStorageClient;
	
	public void insertUser(){
		
	}
	

	public UserDTO putInCache(String key, UserDTO value){
		return usersStorageClient.put(key, value);
	}
	
	public UserDTO getFromCache(String key){
		return usersStorageClient.get(key);
	}
}
