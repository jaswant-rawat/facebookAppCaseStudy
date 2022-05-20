package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exception.ProfileDataAlreadyExistsException;
import com.capgemini.exception.ProfileIdNotFound;
import com.capgemini.model.Profile;
import com.capgemini.service.ProfileService;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

	@Autowired
	private ProfileService profService;

	// get all profiles
	@GetMapping("/allProfiles")
	public ResponseEntity<List<Profile>> getAllProfileData() {
		return ResponseEntity.ok().body(profService.getAllProfileData());
	}

	// get profile by id
	@GetMapping("/getProfile/{id}")
	public ResponseEntity<Profile> getProfileDataById(@PathVariable int id) throws ProfileIdNotFound {
		return ResponseEntity.ok().body(profService.getProfileDataById(id));
	}

	// create profile
	@PostMapping("/createProfile")
	public ResponseEntity<Profile> createProfileData(@RequestBody Profile prof)
			throws ProfileDataAlreadyExistsException {
		return ResponseEntity.created(null).body(this.profService.createProfileData(prof));
	}

	// update profile by id
	@PutMapping("/updateProfile/{id}")
	public ResponseEntity<Profile> updateProfileData(@PathVariable int id, @RequestBody Profile prof)
			throws ProfileIdNotFound {
		prof.setId(id);
		return ResponseEntity.ok().body(this.profService.updateProfileData(prof));
	}

	// delete profile by id
	@DeleteMapping("/deleteProfile/{id}")
	public HttpStatus deleteProfileDataById(@PathVariable int id) throws ProfileIdNotFound {
		this.profService.deleteProfileDataById(id);
		return HttpStatus.OK;
	}

}
