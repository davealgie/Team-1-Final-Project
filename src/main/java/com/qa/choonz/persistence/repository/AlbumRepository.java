package com.qa.choonz.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.choonz.persistence.domain.Album;
import com.qa.choonz.persistence.domain.Track;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	
	Album findByName(String name);

}
