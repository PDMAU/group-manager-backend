package com.groupmanager.infrastructure.database.mongo.repository;

import com.groupmanager.infrastructure.database.mongo.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMongoRepository extends MongoRepository<Course, String> {
    @Query(value = "{}", fields = "{ 'institute' : 1}")
    List<Course> findAllInstitutes();

    @Query(value = "{'institute': ?0}")
    List<Course> findByInstitute(String institute);
}
