package com.capgemini.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.model.MarketPlace;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MarketPlaceRepositoryTest {

	@Autowired
	private MarketPlaceRepository mpRepo;

	@Test
	public void givenMarketPlaceShouldReturnMarketPlaceObject() {

		MarketPlace mp1 = new MarketPlace(152, "washing machine", 59999, "Used"); // User input
		mpRepo.save(mp1);
		MarketPlace mp2 = mpRepo.findById(mp1.getItemId()).get(); // Fetching data from Database
		assertNotNull(mp2); // to check if it is returning the MarketPlace object
		assertEquals(mp1.getItemName(), mp2.getItemName());
	}

	@Test
	public void getAllMarketPlacesMustReturnAllMarketPlaces() {

		List<MarketPlace> mpList = (List<MarketPlace>) mpRepo.findAll();
		assertEquals("New", mpList.get(0).getItemCondition());
	}

}
