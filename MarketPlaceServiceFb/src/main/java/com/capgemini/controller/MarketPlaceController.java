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

import com.capgemini.exception.MarketPlaceDataAlreadyExistsException;
import com.capgemini.exception.MarketPlaceIdNotFound;
import com.capgemini.model.MarketPlace;
import com.capgemini.service.MarketPlaceService;

@RestController
@RequestMapping("/api3/v1")
public class MarketPlaceController {

	@Autowired
	private MarketPlaceService mpService;

	// get all items
	@GetMapping("/allMarketPlaces")
	public ResponseEntity<List<MarketPlace>> getAllMarketPlaceData() {
		return ResponseEntity.ok().body(mpService.getAllMarketPlaceData());
	}

	// get items by id
	@GetMapping("/getMarketPlace/{itemId}")
	public ResponseEntity<MarketPlace> getMarketPlaceDataById(@PathVariable int itemId) throws MarketPlaceIdNotFound {
		return ResponseEntity.ok().body(mpService.getMarketPlaceDataById(itemId));
	}

	// add items
	@PostMapping("/createMarketPlace")
	public ResponseEntity<MarketPlace> createMarketPlaceData(@RequestBody MarketPlace mp)
			throws MarketPlaceDataAlreadyExistsException {
		return ResponseEntity.created(null).body(this.mpService.createMarketPlaceData(mp));
	}

	// update item by id
	@PutMapping("/updateMarketPlace/{id}")
	public ResponseEntity<MarketPlace> updateMarketPlaceData(@PathVariable int id, @RequestBody MarketPlace mp)
			throws MarketPlaceIdNotFound {
		mp.setItemId(id);
		return ResponseEntity.ok().body(this.mpService.updateMarketPlaceData(mp));
	}

	// delete item by id
	@DeleteMapping("/deleteMarketPlace/{id}")
	public HttpStatus deleteMarketPlaceDataById(@PathVariable int id) throws MarketPlaceIdNotFound {
		this.mpService.deleteMarketPlaceDataById(id);
		return HttpStatus.OK;
	}

}
