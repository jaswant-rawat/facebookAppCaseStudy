package com.capgemini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.model.Users;

public interface UserRepository extends MongoRepository<Users, String> {
	Users findByuserName(String userName);

}
