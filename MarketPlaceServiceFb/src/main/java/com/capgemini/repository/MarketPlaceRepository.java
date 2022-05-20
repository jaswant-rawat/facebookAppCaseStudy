package com.capgemini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.model.MarketPlace;

public interface MarketPlaceRepository extends MongoRepository<MarketPlace, Integer> {

}
