package com.groupmanager.infrastructure.database.mongo.repository;

import com.groupmanager.infrastructure.database.mongo.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMongoRepository extends MongoRepository<Course, String> {
}
