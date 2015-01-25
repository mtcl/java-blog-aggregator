package com.mtcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtcl.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);

}
