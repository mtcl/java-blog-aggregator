package com.mtcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtcl.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	public Role findOneByName(String name);

}
