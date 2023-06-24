package com.groupmanager.repository;

import com.groupmanager.infrastructure.database.mongo.entities.Course;

import java.util.List;

public interface CouserRepository {

    List<Course> findAll();
}
