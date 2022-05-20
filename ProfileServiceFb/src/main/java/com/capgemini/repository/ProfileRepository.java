package com.capgemini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile, Integer> {

}
