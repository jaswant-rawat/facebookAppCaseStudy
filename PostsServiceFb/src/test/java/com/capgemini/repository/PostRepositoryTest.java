package com.capgemini.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.model.Post;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PostRepositoryTest {

	@Autowired
	private PostRepository proRepo;

	@Test
	public void givenPostShouldReturnPostObject() {

		Post p1 = new Post(101, "jaswant", "last post", "BYE"); // User input
		proRepo.save(p1);
		Post p2 = proRepo.findById(p1.getId()).get(); // Fetching data from Database
		assertNotNull(p2); // to check if it is returning the Post object
		assertEquals(p1.getName(), p2.getName());
	}

	@Test
	public void getAllPostsMustReturnAllPosts() {

		List<Post> postList = (List<Post>) proRepo.findAll();
		assertEquals("jaswant", postList.get(0).getName());
	}
	
	
	

}