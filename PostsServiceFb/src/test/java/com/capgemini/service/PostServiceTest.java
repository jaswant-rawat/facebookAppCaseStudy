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

import com.capgemini.exception.PostDataAlreadyExistsException;
import com.capgemini.model.Post;
import com.capgemini.repository.PostRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

	@Mock
	private PostRepository pr;

	@InjectMocks
	private PostServiceImpl psl;

	@Test
	public void testCreatePostData() throws PostDataAlreadyExistsException {
		Post p1 = new Post(101, "jaswant", "first post", "HELLO"); // User input
		when(pr.save(any())).thenReturn(p1);
		psl.createPostData(p1);
		verify(pr, times(1)).save(any());
	}

	@Test
	public void testGetAllPostData() {
		Post p2 = new Post(112, "abhishek", "second post", "HOLA"); // User input
		Post p3 = new Post(133, "rajat", "third post", "HALO"); // User input
		List<Post> postList = new ArrayList<>();
		postList.add(p2);
		postList.add(p3);

		when(pr.findAll()).thenReturn(postList);
		List<Post> postList1 = psl.getAllPostData();
		assertEquals(postList, postList1);

	}

}