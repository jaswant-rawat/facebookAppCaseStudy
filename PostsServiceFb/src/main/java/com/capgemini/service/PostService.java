package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.PostDataAlreadyExistsException;
import com.capgemini.exception.PostIdNotFound;
import com.capgemini.model.Post;

public interface PostService {

	public Post createPostData(Post pos) throws PostDataAlreadyExistsException;

	public Post updatePostData(Post pos) throws PostIdNotFound;

	public List<Post> getAllPostData();

	public Post getPostDataById(int id) throws PostIdNotFound;

	public void deletePostDataById(int id) throws PostIdNotFound;

}
