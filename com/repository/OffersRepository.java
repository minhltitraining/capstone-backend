package com.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Offers;

@Repository
public interface OffersRepository extends MongoRepository<Offers, ObjectId> {

}
