package com.example.helpDesk.api.service;

import org.springframework.data.domain.Page;

import com.example.helpDesk.api.entity.User;

public interface UserService {
	
	User finfByEmail(String email);
	
	User createOrUpdate(User user);
	
	User findById(String id);
	
	void delete(String id);
	
	Page<User> findAll(int page, int count);
}
