package com.qa.choonz.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);

	
}
