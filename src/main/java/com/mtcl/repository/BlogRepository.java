package com.mtcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtcl.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

}
