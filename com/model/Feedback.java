package com.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Feedback {

	private String userName;
	private String vendorName;
	private String foodName;
	private String reviews;
	private double rating;
	
}
