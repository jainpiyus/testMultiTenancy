package com.redtheme.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redtheme.example.entity.User;
import com.redtheme.example.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	IUserRepository userRepository;
	
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}
}
