package com.capgemini.service;

import java.util.List;

import com.capgemini.exception.MarketPlaceDataAlreadyExistsException;
import com.capgemini.exception.MarketPlaceIdNotFound;
import com.capgemini.model.MarketPlace;

public interface MarketPlaceService {

	public MarketPlace createMarketPlaceData(MarketPlace mp) throws MarketPlaceDataAlreadyExistsException;

	public MarketPlace updateMarketPlaceData(MarketPlace mp) throws MarketPlaceIdNotFound;

	public List<MarketPlace> getAllMarketPlaceData();

	public MarketPlace getMarketPlaceDataById(int id) throws MarketPlaceIdNotFound;

	public void deleteMarketPlaceDataById(int id) throws MarketPlaceIdNotFound;
}
