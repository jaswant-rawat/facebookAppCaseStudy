package com.capgemini.controller;

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

import com.capgemini.model.Profile;
import com.capgemini.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ExtendWith(MockitoExtension.class)
class ProfileControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ProfileService ps;
	private Profile p;
	private List<Profile> profList;

	@InjectMocks
	private ProfileController pc;

	@BeforeEach
	public void init() {
		p = new Profile(101, "jaswant", 90393929, "pune"); // User input
		mockMvc = MockMvcBuilders.standaloneSetup(pc).build();
	}

	// test for getting all profile data
	@Test
	public void testGetAllProfileDataControllerTest() throws Exception {
		when(ps.getAllProfileData()).thenReturn(profList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/allProfiles").contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(p))).andDo(MockMvcResultHandlers.print());
		verify(ps, times(1)).getAllProfileData();
	}

	// test for creating profile data

	@Test
	public void testCreateProfileDataControllerTest() throws Exception {
		when(ps.createProfileData(any())).thenReturn(p);
		mockMvc.perform(post("/api/v1/createProfile").contentType(MediaType.APPLICATION_JSON).content(asJSONString(p)))
				.andExpect(status().isCreated());
		verify(ps, times(1)).createProfileData(any());
	}

	public static String asJSONString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
