package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Nominee;
import com.example.demo.model.User;
import com.example.demo.service.NomineeService;
import com.example.demo.service.UserService;

@RestController
public class UserNomineeController 
{
	@Autowired
	private UserService userService;
	@Autowired
	private NomineeService nomineeService;
	@PostMapping("/saveUserNominee")
	ResponseEntity<User> saveUserNominee(@RequestBody User user) {
	User user1 = userService.saveUser(user);
	List<Nominee> nominees = user.getNomineeList();
	for (Nominee nominee : nominees) {
	nominee.setUserId(user.getId());
	nomineeService.saveNominee(nominee);
	}
	return ResponseEntity.ok().body(user1);

	}
}


