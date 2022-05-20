package com.capgemini.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.model.MarketPlace;
import com.capgemini.service.MarketPlaceService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ExtendWith(MockitoExtension.class)
class MarketPlaceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private MarketPlaceService mps;
	private MarketPlace mp;
	private List<MarketPlace> mpList;

	@InjectMocks
	private MarketPlaceController pc;

	@BeforeEach
	public void init() {
		mp = new MarketPlace(52, "hair dryer", 999, "New"); // User input
		mockMvc = MockMvcBuilders.standaloneSetup(pc).build();
	}

	@Test
	public void testGetAllMarketPlaceDataControllerTest() throws Exception {
		when(mps.getAllMarketPlaceData()).thenReturn(mpList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api3/v1/allMarketPlaces").contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(mp))).andDo(MockMvcResultHandlers.print());
		verify(mps, times(1)).getAllMarketPlaceData();
	}

	@Test
	public void testCreateMarketPlaceDataControllerTest() throws Exception {
		when(mps.createMarketPlaceData(any())).thenReturn(mp);
		mockMvc.perform(
				post("/api3/v1/createMarketPlace").contentType(MediaType.APPLICATION_JSON).content(asJSONString(mp)))
				.andExpect(status().isCreated());
		verify(mps, times(1)).createMarketPlaceData(any());
	}

	public static String asJSONString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}