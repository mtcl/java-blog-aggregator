package com.mtcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtcl.entity.Blog;
import com.mtcl.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	/*
	 * the user is an attribute in the Blog entity the spring data JPA will
	 * create a implementation of this method
	 */
	public List<Blog> findByUser(User user);

}
