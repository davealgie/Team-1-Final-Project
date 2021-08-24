package com.qa.choonz.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query(value = "SELECT * FROM users WHERE user_name = ?1", nativeQuery = true)
	public Optional<Users> findByName(String user_name);
}
