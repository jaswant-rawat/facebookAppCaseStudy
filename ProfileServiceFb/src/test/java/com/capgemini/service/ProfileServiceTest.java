package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.exception.ProfileDataAlreadyExistsException;
import com.capgemini.model.Profile;
import com.capgemini.repository.ProfileRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

	@Mock
	private ProfileRepository pr;

	@InjectMocks
	private ProfileServiceImpl psl;

	// test case for creating profile data

	@Test
	public void testCreateProfileData() throws ProfileDataAlreadyExistsException {
		Profile p1 = new Profile(101, "jaswant", 90393929, "pune"); // User input
		when(pr.save(any())).thenReturn(p1);
		psl.createProfileData(p1);
		verify(pr, times(1)).save(any());
	}

	// test case for getting all profile data

	@Test
	public void testGetAllProfileData() {
		Profile p2 = new Profile(121, "amit", 52423232, "punjab"); // User input
		Profile p3 = new Profile(122, "charlie", 62486412, "bangalore"); // User input
		List<Profile> profList = new ArrayList<>();
		profList.add(p2);
		profList.add(p3);

		when(pr.findAll()).thenReturn(profList);
		List<Profile> profList1 = psl.getAllProfileData();
		assertEquals(profList, profList1);

	}
}
