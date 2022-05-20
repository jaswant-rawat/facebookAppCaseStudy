package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.MarketPlaceDataAlreadyExistsException;
import com.capgemini.exception.MarketPlaceIdNotFound;
import com.capgemini.model.MarketPlace;
import com.capgemini.repository.MarketPlaceRepository;

@Service
public class MarketPlaceServiceImpl implements MarketPlaceService {

	@Autowired
	private MarketPlaceRepository mpRepo;

	@Override
	public MarketPlace createMarketPlaceData(MarketPlace mp) throws MarketPlaceDataAlreadyExistsException {
		// TODO Auto-generated method stub
		if (mpRepo.existsById(mp.getItemId())) {
			throw new MarketPlaceDataAlreadyExistsException();
		}
		return mpRepo.save(mp);

	}

	@Override
	public MarketPlace updateMarketPlaceData(MarketPlace mp) throws MarketPlaceIdNotFound {
		// TODO Auto-generated method stub
		Optional<MarketPlace> mpDb = this.mpRepo.findById(mp.getItemId());

		if (mpDb.isPresent()) {
			MarketPlace mpUpdate = mpDb.get();
			mpUpdate.setItemId(mp.getItemId());
			mpUpdate.setItemName(mp.getItemName());
			mpUpdate.setItemPrice(mp.getItemPrice());
			mpUpdate.setItemCondition(mp.getItemCondition());
			mpRepo.save(mpUpdate);
			return mpUpdate;
		} else {
			throw new MarketPlaceIdNotFound();
		}
	}

	@Override
	public List<MarketPlace> getAllMarketPlaceData() {
		// TODO Auto-generated method stub
		return this.mpRepo.findAll();
	}

	@Override
	public MarketPlace getMarketPlaceDataById(int id) throws MarketPlaceIdNotFound {
		// TODO Auto-generated method stub
		Optional<MarketPlace> profDb = this.mpRepo.findById(id);

		if (profDb.isPresent()) {

			return profDb.get();
		} else {
			throw new MarketPlaceIdNotFound();
		}
	}

	@Override
	public void deleteMarketPlaceDataById(int id) throws MarketPlaceIdNotFound {
		// TODO Auto-generated method stub
		Optional<MarketPlace> mpDb = this.mpRepo.findById(id);

		if (mpDb.isPresent()) {

			this.mpRepo.delete(mpDb.get());
		} else {
			throw new MarketPlaceIdNotFound();
		}
	}
}
