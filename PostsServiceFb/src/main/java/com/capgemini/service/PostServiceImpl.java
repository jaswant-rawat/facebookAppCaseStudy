package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.PostDataAlreadyExistsException;
import com.capgemini.exception.PostIdNotFound;
import com.capgemini.model.Post;
import com.capgemini.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository posRepo;

	@Override
	public Post createPostData(Post pos) throws PostDataAlreadyExistsException {
		// TODO Auto-generated method stub
		if (posRepo.existsById(pos.getId())) {
			throw new PostDataAlreadyExistsException();
		}
		return posRepo.save(pos);

	}

	@Override
	public Post updatePostData(Post pos) throws PostIdNotFound {
		// TODO Auto-generated method stub
		Optional<Post> posDb = this.posRepo.findById(pos.getId());

		if (posDb.isPresent()) {
			Post posUpdate = posDb.get();
			posUpdate.setId(pos.getId());
			posUpdate.setName(pos.getName());
			posUpdate.setTitle(pos.getTitle());
			posUpdate.setDesc(pos.getDesc());
			posRepo.save(posUpdate);
			return posUpdate;
		} else {
			throw new PostIdNotFound();
		}
	}

	@Override
	public List<Post> getAllPostData() {
		// TODO Auto-generated method stub
		return this.posRepo.findAll();
	}

	@Override
	public Post getPostDataById(int id) throws PostIdNotFound {
		// TODO Auto-generated method stub
		Optional<Post> posDb = this.posRepo.findById(id);

		if (posDb.isPresent()) {

			return posDb.get();
		} else {
			throw new PostIdNotFound();
		}
	}

	@Override
	public void deletePostDataById(int id) throws PostIdNotFound {
		// TODO Auto-generated method stub
		Optional<Post> posDb = this.posRepo.findById(id);

		if (posDb.isPresent()) {

			this.posRepo.delete(posDb.get());
		} else {
			throw new PostIdNotFound();
		}
	}
}
