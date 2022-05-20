package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.PostDataAlreadyExistsException;
import com.capgemini.exception.PostIdNotFound;
import com.capgemini.model.Post;
import com.capgemini.service.PostService;

@RestController
@RequestMapping("/api2/v1")
public class PostController {

	@Autowired
	private PostService posService;

	// get all posts
	@GetMapping("/allPosts")
	public ResponseEntity<List<Post>> getAllPostData() {
		return ResponseEntity.ok().body(posService.getAllPostData());
	}

	// get posts by id
	@GetMapping("/getPost/{id}")
	public ResponseEntity<Post> getPostDataById(@PathVariable int id) throws PostIdNotFound {
		return ResponseEntity.ok().body(posService.getPostDataById(id));
	}

	// create post
	@PostMapping("/createPost")
	public ResponseEntity<Post> createPostData(@RequestBody Post pos) throws PostDataAlreadyExistsException {
		return ResponseEntity.created(null).body(this.posService.createPostData(pos));
	}

	// update post by id
	@PutMapping("/updatePost/{id}")
	public ResponseEntity<Post> updatePostData(@PathVariable int id, @RequestBody Post pos) throws PostIdNotFound {
		pos.setId(id);
		return ResponseEntity.ok().body(this.posService.updatePostData(pos));
	}

	// delete post by id
	@DeleteMapping("/deletePost/{id}")
	public HttpStatus deletePostDataById(@PathVariable int id) throws PostIdNotFound {
		this.posService.deletePostDataById(id);
		return HttpStatus.OK;
	}

}
