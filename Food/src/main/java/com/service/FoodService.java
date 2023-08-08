package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Food;
import com.repo.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	FoodRepository foodRepo;
	
	public List<Food> getAllFood(){
		List<Food> food = foodRepo.findAll();
		if(food.size()>0) {
			return food;
		}
		return null;
	}
	
	public Food createFood(Food food) {
		return foodRepo.save(food);
	}
	
	public Optional<Food> getFoodById(Long id){
		Optional<Food> food = foodRepo.findById(id);
		if(food.isPresent()) {
			return foodRepo.findById(id);
		}
		return null;
	}

	public Food updateFood(Long id, Food food) {
		Optional<Food> old_food = foodRepo.findById(id);
		if(old_food.isPresent()) {
			return foodRepo.save(food);
		}
		return null;
	}
	
	public String deleteFood(Long id) {
		if(getFoodById(id).isPresent()) {
			foodRepo.deleteById(id);
			return "Food Deleted";
		}else {
			return "Food Not Found";
		}
	}
}
