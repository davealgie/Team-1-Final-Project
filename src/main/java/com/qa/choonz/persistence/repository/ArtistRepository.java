package com.qa.choonz.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Artist;
import com.qa.choonz.persistence.domain.Track;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
	Artist findByName(String name);
}
