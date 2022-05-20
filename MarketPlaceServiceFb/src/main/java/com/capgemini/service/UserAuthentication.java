package com.capgemini.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capgemini.model.Users;
import com.capgemini.repository.UserRepository;

@Service
public class UserAuthentication implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByuserName(username);
		if(user==null)
			throw new UsernameNotFoundException(username,null);
		String usern=user.getUserName();
		String passwrd=user.getPassWord();
		return new User(usern,passwrd,new ArrayList<>());
		}

}
