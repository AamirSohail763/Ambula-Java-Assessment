package com.ambula.service;

import java.util.List;

import com.ambula.model.User;

public interface user_service {
	
	
	public User createData(User details);
	
	public User updateData(User newDetails);
	
	public List<User> getUsers(Integer N);

}
