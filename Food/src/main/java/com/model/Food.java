package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="food")
public class Food {

	@Id
	private Long foodId;
	private String foodName;
	private String vendorName;
	private Long price;
	private long discount=0;

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Food(Long foodId, String foodName, String vendorName, Long price, Long discount) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.vendorName = vendorName;
		this.price = price;
		this.discount = discount;
	}

	public Food() {
		super();
	}

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "Food{" +
				"foodId=" + foodId +
				", foodName='" + foodName + '\'' +
				", vendorName='" + vendorName + '\'' +
				", price=" + price +
				", discount=" + discount +
				'}';
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
}
