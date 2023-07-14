package com.ambula.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.exceptions.AccessDeniedException;
import com.ambula.exceptions.UserException;
import com.ambula.model.User;
import com.ambula.model.user_type;
import com.ambula.repository.user_repository;


@Service
public class user_service_impl implements user_service{
	
	@Autowired
	private user_repository userRepo;

	
	
	@Override
	public User createData(User details) {
		
		if(details.getType() != user_type.ADMIN) {			//checking if the given user is Admin or not
			throw new AccessDeniedException("Access denied for READER..");
		}
		
		else {
			
			Optional<User> opt = userRepo.findById(details.getUserId());   //finding if given user already exists, returns optional object
			if(opt.isPresent()) {
				throw new UserException("User already exists with given userId..");	//throwing exception if duplicate user found
			}
			
			return userRepo.saveAndFlush(details);							//new user details gets saved in the database
			
		}
	}

	
	
	
	
	@Override
	public User updateData(User newDetails) {
		
		if(newDetails.getType() != user_type.ADMIN) {			//checking if the given user is Admin or not
			throw new AccessDeniedException("Access denied for READER..");
		}
		
		else {
			
			Optional<User> opt = userRepo.findById(newDetails.getUserId());   //finding if given user exists to update, returns optional object
			if(opt.isPresent()) {
				return userRepo.saveAndFlush(newDetails);		//updating the old details with new one
			}
			else {
				throw new UserException("User doesn't exists with Id: "+ newDetails.getUserId());	//exception if user not found to be updated
			}	
			
		}
		
	}




	@Override
	public List<User> getUsers(Integer N) {
		
		List<User> N_users = new ArrayList<>();			//creating a new empty result list
		
		List<User> all_users = userRepo.findAll();
		if(all_users.size() > 0 || all_users.size() >= N) {

			for(int count=0; count<N; count++) {
				N_users.add(all_users.get(count));		//add N results to the result list
			}
			
			return N_users;								//returning list of size N
		}
		else {
			throw new UserException("No User found..");		//exception if the list is empty
		}
		
		
	}
	
	

}
