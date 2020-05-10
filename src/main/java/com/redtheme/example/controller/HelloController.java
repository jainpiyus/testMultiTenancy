package com.redtheme.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redtheme.example.entity.User;
import com.redtheme.example.service.UserService;


@RequestMapping(value="test")
@RestController
public class HelloController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
    public void createAddOn(){
		List<User> userList = this.userService.getUsers();
	}

}
