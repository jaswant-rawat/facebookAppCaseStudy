package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.Invalid_CredentialsException;
import com.capgemini.model.JWTResponse;
import com.capgemini.model.Users;
import com.capgemini.repository.UserRepository;
import com.capgemini.service.UserAuthentication;
import com.capgemini.utility.JWTUtility;

@RequestMapping("/api/jwt")
@RestController
public class MainController {

	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserAuthentication userService;
	
	@PostMapping("/reg")
	public ResponseEntity<?> addUser(@RequestBody Users user) {
		String usrName=user.getUserName();
		String pswrd=user.getPassWord();
		Users usr=new Users();
		usr.setUserName(usrName);
		usr.setPassWord(pswrd);
		userRepository.save(usr);
		return new ResponseEntity<>("Succesfull Registration"+usr, HttpStatus.OK);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Users>> getallApartmentComplex(){
		return new ResponseEntity<List<Users>>((List<Users>)userRepository.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/auth")
	public JWTResponse authenticate(@RequestBody Users jwtRequest) throws Invalid_CredentialsException{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						jwtRequest.getUserName(), jwtRequest.getPassWord()));
		}
		catch(BadCredentialsException e) {
			throw new Invalid_CredentialsException();
		}
		final UserDetails userDetails
			= userService.loadUserByUsername(jwtRequest.getUserName());
		
		final String token=
				jwtUtility.generateToken(userDetails);
		
		return new JWTResponse(token);
	}
}

