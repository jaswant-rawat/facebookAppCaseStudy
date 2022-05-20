package com.capgemini.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.model.Profile;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProfileRepositoryTest {

	@Autowired
	private ProfileRepository proRepo;

	@Test
	public void givenProfileShouldReturnProfileObject() {

		Profile p1 = new Profile(101, "jaswant", 90393929, "pune"); // User input
		proRepo.save(p1);
		Profile p2 = proRepo.findById(p1.getId()).get(); // Fetching data from Database
		assertNotNull(p2); // to check if it is returning the profile object
		assertEquals(p1.getName(), p2.getName());
	}

	@Test
	public void getAllProfilesMustReturnAllProfiles() {

		List<Profile> profList = (List<Profile>) proRepo.findAll();
		assertEquals("pune", profList.get(0).getLoc());
	}

	@Test
	public void updateProfileDataShouldUpdate() {

		Profile p5 = proRepo.findById(101).get();
		p5.setName("jaswant@rawat");
		Profile p5Updated = proRepo.save(p5);
		assertEquals("jaswant@rawat", p5Updated.getName());

	}

	@Test

	public void deleteProfileShouldDelete() {

		Profile p6 = proRepo.findById(101).get();

		proRepo.deleteById(101);

		Profile p7 = null;

		Optional<Profile> optionalProfile = proRepo.findById(101);

		if (optionalProfile.isPresent()) {
			p7 = optionalProfile.get();
		}

		assertEquals(p7, null);
	}
}
