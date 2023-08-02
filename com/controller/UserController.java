package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/loadallusers")
	private List<User> getAllUsers(){
		return userService.loadAllUsers();
	}
	
	@GetMapping("/finduser/{id}")
	private Optional<User> findUserById(@RequestBody String id){
		return userService.findUserById(id);
	}
	
}
