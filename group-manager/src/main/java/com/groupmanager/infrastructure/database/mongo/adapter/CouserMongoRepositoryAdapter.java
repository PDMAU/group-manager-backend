package com.groupmanager.infrastructure.database.mongo.adapter;

import com.groupmanager.infrastructure.database.mongo.repository.CourseMongoRepository;
import com.groupmanager.infrastructure.database.mongo.entities.Course;
import com.groupmanager.repository.CouserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CouserMongoRepositoryAdapter implements CouserRepository {
    private final CourseMongoRepository repo;

    @Override
    public List<Course> findAll() {
        return repo.findAll();
    }


}
