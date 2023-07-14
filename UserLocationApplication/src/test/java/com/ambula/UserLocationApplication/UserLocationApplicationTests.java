package com.ambula.UserLocationApplication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ambula.controller.user_controller;

@SpringBootTest
class UserLocationApplicationTests {
	
	
	@Autowired
	private user_controller controller;
	

	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
