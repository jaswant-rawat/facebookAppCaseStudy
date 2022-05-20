package com.capgemini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MarketPlace")
public class MarketPlace {

	@Id
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemCondition;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}

	@Override
	public String toString() {
		return "MarketPlace [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemCondition=" + itemCondition + "]";
	}

	public MarketPlace(int itemId, String itemName, int itemPrice, String itemCondition) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemCondition = itemCondition;
	}

	public MarketPlace() {
		super();
		// TODO Auto-generated constructor stub
	}

}
