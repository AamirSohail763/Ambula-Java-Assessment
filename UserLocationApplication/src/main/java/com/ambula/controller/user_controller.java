package com.ambula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambula.model.User;
import com.ambula.service.user_service;

@RestController
@RequestMapping("/userLocation")
public class user_controller {
	
	@Autowired
	private user_service userService;
	
	
	@PostMapping("/create_data")
	public ResponseEntity<User> createDataHandler(@RequestBody User details){
		
		User newUser = userService.createData(details);
		
		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping("/update_data")
	public ResponseEntity<User> updateDataHandler(@RequestBody User newDetails){
		
		User updatedUser = userService.updateData(newDetails);
		
		return new ResponseEntity<User>(updatedUser, HttpStatus.ACCEPTED);
	}
	
	
	
	
	@GetMapping("/get_users/{N}")
	public ResponseEntity<List<User>> getDataHandler(@PathVariable("N") Integer N){
		
		List<User> users = userService.getUsers(N);
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
