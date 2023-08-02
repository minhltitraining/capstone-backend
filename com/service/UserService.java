package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> loadAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> findUserById(String id){
		return userRepository.findUserById(id);
	}
}
