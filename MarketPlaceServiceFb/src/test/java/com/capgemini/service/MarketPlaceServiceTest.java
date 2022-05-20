package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.exception.MarketPlaceDataAlreadyExistsException;
import com.capgemini.model.MarketPlace;
import com.capgemini.repository.MarketPlaceRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MarketPlaceServiceTest {

	@Mock
	private MarketPlaceRepository mpr;

	@InjectMocks
	private MarketPlaceServiceImpl mpsl;

	@Test
	public void testCreateMarketPlaceData() throws MarketPlaceDataAlreadyExistsException {
		MarketPlace mp1 = new MarketPlace(232, "laptop", 59999, "NEW"); // User input
		when(mpr.save(any())).thenReturn(mp1);
		mpsl.createMarketPlaceData(mp1);
		verify(mpr, times(1)).save(any());
	}

	@Test
	public void testGetAllMarketPlaceData() {
		MarketPlace mp2 = new MarketPlace(212, "car", 569999, "USED"); // User input
		MarketPlace mp3 = new MarketPlace(142, "guitar", 500, "USED"); // User input
		List<MarketPlace> mpList = new ArrayList<>();
		mpList.add(mp2);
		mpList.add(mp3);

		when(mpr.findAll()).thenReturn(mpList);
		List<MarketPlace> mpList1 = mpsl.getAllMarketPlaceData();
		assertEquals(mpList, mpList1);

	}
}