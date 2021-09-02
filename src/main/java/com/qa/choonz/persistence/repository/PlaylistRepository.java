package com.qa.choonz.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Playlist;
import com.qa.choonz.persistence.domain.Users;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

		Playlist findByUsers(Long id);

}
