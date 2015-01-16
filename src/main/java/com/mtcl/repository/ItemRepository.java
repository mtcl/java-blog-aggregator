package com.mtcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtcl.entity.Blog;
import com.mtcl.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByBlog(Blog blog);

}
