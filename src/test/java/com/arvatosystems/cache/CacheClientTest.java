package com.arvatosystems.cache;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arvatosystems.dto.UserDTO;
import com.arvatosystems.services.UsersService;
import com.gemstone.gemfire.cache.query.SelectResults;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CacheClientTest {

	@Autowired
	private UsersService cacheClient;
	
	
	@Test
	public void shouldGetAll(){		
		SelectResults users = cacheClient.getAll();
		
		System.out.println(users);
		cacheClient.putInCache("testFlo", "{\"firstname\":\"flo\",\"lastname\":\"bar\"}");
		
		
	}
	
	@Test
	public void shouldInsertAndRetreiveUser(){
		UserDTO user1 = new UserDTO("Florent", "Bariod", "florent.bariod@arvatosystems.com");
		cacheClient.putInCache("user1", user1);
		
		UserDTO cachedUser1 = cacheClient.getFromCache("user1");
		assertThat(cachedUser1.getFirstName(), equalTo("Florent"));
		assertThat(cachedUser1.getLastName(), equalTo("Bariod"));
		assertThat(cachedUser1.getEmail(), equalTo("florent.bariod@arvatosystems.com"));

		
	}
}
