package com.qa.choonz.dtotests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.qa.choonz.persistence.domain.Users;
import com.qa.choonz.rest.dto.PlaylistDTO;

public class PlaylistDTOTest {
	private Users users = new Users(0L, "full_name", "user_name", "password", new ArrayList<>());;
	private PlaylistDTO playlistDTO = new PlaylistDTO(0L, "name", "description", "artwork", new ArrayList<>(), users);

	@Test
	public void PlaylistTest() {
	
		assertThat("PlaylistDTO [id=0, name=name, description=description, artwork=artwork, tracks=[], users="+users.toString()+"]").isEqualTo(playlistDTO.toString());

}
}