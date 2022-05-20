package com.capgemini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.model.Post;

public interface PostRepository extends MongoRepository<Post, Integer> {

}
