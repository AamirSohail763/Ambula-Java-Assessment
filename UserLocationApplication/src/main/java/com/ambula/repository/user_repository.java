package com.ambula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambula.model.User;

@Repository
public interface user_repository extends JpaRepository<User, Integer>{

}
