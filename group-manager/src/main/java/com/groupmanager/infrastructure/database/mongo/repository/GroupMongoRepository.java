package com.groupmanager.infrastructure.database.mongo.repository;

import com.groupmanager.enumeration.Categories;
import com.groupmanager.infrastructure.database.mongo.entities.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMongoRepository extends MongoRepository<Group, String> {

    List<Group> findByCategory (Categories category);
}
