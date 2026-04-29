package com.javaa.employee.reg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaa.employee.reg.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	    Optional<Role> findByName(String name);
	}


