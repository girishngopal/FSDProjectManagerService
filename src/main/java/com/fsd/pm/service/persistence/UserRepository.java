package com.fsd.pm.service.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.pm.service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
