package com.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Feedback;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, ObjectId> {

}
