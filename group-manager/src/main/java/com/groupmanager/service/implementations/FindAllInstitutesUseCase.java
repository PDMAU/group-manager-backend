package com.groupmanager.service.implementations;

import com.groupmanager.infrastructure.database.mongo.entities.Course;
import com.groupmanager.infrastructure.database.mongo.repository.CourseMongoRepository;
import com.groupmanager.service.interfaces.FindAllInstitutes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllInstitutesUseCase implements FindAllInstitutes {
    private final CourseMongoRepository courseRepository;

    public List<String> listAllInstitutes() {
        List<Course> courses = courseRepository.findAllInstitutes();
        return courses.stream().map(Course::getInstitute).collect(Collectors.toList());
    }
}
