package com.model.child;

import java.util.List;

import com.model.Food;
import com.model.User;

public class Vendor extends User{

	private Boolean enabled;
	private double avgRating;
	private int numRaters;
	private List<Food> menu;
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(Long userId, String userName, String email, String password, Long phone, String userType) {
		super(userId, userName, email, password, phone, userType);
		// TODO Auto-generated constructor stub
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public int getNumRaters() {
		return numRaters;
	}
	public void setNumRaters(int numRaters) {
		this.numRaters = numRaters;
	}
	public List<Food> getMenu() {
		return menu;
	}
	public void setMenu(List<Food> menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "Vendor [enabled=" + enabled + ", avgRating=" + avgRating + ", numRaters=" + numRaters + ", menu=" + menu
				+ "]";
	}
	
}
