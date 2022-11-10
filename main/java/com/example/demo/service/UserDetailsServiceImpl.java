package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.*;
import com.example.demo.repository.*;
import com.example.demo.entity.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user = userRepository.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		userDetails customUserDetails=new userDetails(user);
		return customUserDetails;
	}
}