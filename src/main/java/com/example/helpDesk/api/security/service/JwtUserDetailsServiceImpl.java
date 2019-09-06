package com.example.helpDesk.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.helpDesk.api.entity.User;
import com.example.helpDesk.api.security.jwt.JwtUserFactory;
import com.example.helpDesk.api.service.UserService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userService.finfByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%'.", email));
		} else {
			return JwtUserFactory.create(user);
		}
		
	}
}
