package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.ProfileDataAlreadyExistsException;
import com.capgemini.exception.ProfileIdNotFound;
import com.capgemini.model.Profile;
import com.capgemini.repository.ProfileRepository;

@Service

public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository proRepo;

	// create profile data

	@Override
	public Profile createProfileData(Profile prof) throws ProfileDataAlreadyExistsException {
		// TODO Auto-generated method stub
		if (proRepo.existsById(prof.getId())) {
			throw new ProfileDataAlreadyExistsException();
		}
		return proRepo.save(prof);

	}

	// update profile data

	@Override
	public Profile updateProfileData(Profile prof) throws ProfileIdNotFound {
		// TODO Auto-generated method stub
		Optional<Profile> profDb = this.proRepo.findById(prof.getId());

		if (profDb.isPresent()) {
			Profile profUpdate = profDb.get();
			profUpdate.setId(prof.getId());
			profUpdate.setName(prof.getName());
			profUpdate.setMobile(prof.getMobile());
			profUpdate.setLoc(prof.getLoc());
			proRepo.save(profUpdate);
			return profUpdate;
		} else {
			throw new ProfileIdNotFound();
		}
	}
	// get all profile data

	@Override
	public List<Profile> getAllProfileData() {
		// TODO Auto-generated method stub
		return this.proRepo.findAll();
	}

	// get profile data by id

	@Override
	public Profile getProfileDataById(int id) throws ProfileIdNotFound {
		// TODO Auto-generated method stub
		Optional<Profile> profDb = this.proRepo.findById(id);

		if (profDb.isPresent()) {

			return profDb.get();
		} else {
			throw new ProfileIdNotFound();
		}
	}

	// delete profile data by id

	@Override
	public void deleteProfileDataById(int id) throws ProfileIdNotFound {
		// TODO Auto-generated method stub
		Optional<Profile> profDb = this.proRepo.findById(id);

		if (profDb.isPresent()) {

			this.proRepo.delete(profDb.get());
		} else {
			throw new ProfileIdNotFound();
		}
	}

}
