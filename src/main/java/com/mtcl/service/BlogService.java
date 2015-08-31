package com.mtcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtcl.entity.Blog;
import com.mtcl.entity.User;
import com.mtcl.repository.BlogRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	public void save(Blog blog, User user) {
		blog.setUser(user);
		blogRepository.save(blog);
	}

}
