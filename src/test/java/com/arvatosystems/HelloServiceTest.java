package com.arvatosystems;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arvatosystems.services.HelloWorldService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class HelloServiceTest {
	@Autowired
	private HelloWorldService helloService;
	
	@Test
	public void testBean(){
		assertThat(helloService.helloWorld(), equalTo("hello world"));
	}
}
