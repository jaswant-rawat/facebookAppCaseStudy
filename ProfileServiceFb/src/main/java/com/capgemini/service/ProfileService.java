package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.ProfileDataAlreadyExistsException;
import com.capgemini.exception.ProfileIdNotFound;
import com.capgemini.model.Profile;

public interface ProfileService {

	public Profile createProfileData(Profile pop) throws ProfileDataAlreadyExistsException;

	public Profile updateProfileData(Profile pop) throws ProfileIdNotFound;

	public List<Profile> getAllProfileData();

	public Profile getProfileDataById(int id) throws ProfileIdNotFound;

	public void deleteProfileDataById(int id) throws ProfileIdNotFound;

}
