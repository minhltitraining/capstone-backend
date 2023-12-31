package com.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Food;

@Repository
public interface FoodRepository extends MongoRepository<Food, ObjectId>{

}
