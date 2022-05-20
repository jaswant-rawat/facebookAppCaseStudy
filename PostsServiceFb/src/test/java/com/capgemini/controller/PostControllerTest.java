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

import com.capgemini.model.Post;
import com.capgemini.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ExtendWith(MockitoExtension.class)
class PostControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private PostService ps;
	private Post p;
	private List<Post> postList;

	@InjectMocks
	private PostController pc;

	@BeforeEach
	public void init() {
		p = new Post(112, "jaswant", "last post", "BYE"); // User input
		mockMvc = MockMvcBuilders.standaloneSetup(pc).build();
	}

	@Test
	public void testGetAllPostDataControllerTest() throws Exception {
		when(ps.getAllPostData()).thenReturn(postList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api2/v1/allPosts").contentType(MediaType.APPLICATION_JSON)
				.content(asJSONString(p))).andDo(MockMvcResultHandlers.print());
		verify(ps, times(1)).getAllPostData();
	}

	@Test
	public void testCreatePostDataControllerTest() throws Exception {
		when(ps.createPostData(any())).thenReturn(p);
		mockMvc.perform(post("/api2/v1/createPost").contentType(MediaType.APPLICATION_JSON).content(asJSONString(p)))
				.andExpect(status().isCreated());
		verify(ps, times(1)).createPostData(any());
	}

	public static String asJSONString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
