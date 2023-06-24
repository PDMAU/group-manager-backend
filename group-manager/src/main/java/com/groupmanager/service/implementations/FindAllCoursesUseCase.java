package com.groupmanager.service.implementations;

import com.groupmanager.dto.CourseDto;
import com.groupmanager.dto.OfferingDto;
import com.groupmanager.infrastructure.database.mongo.entities.Course;
import com.groupmanager.infrastructure.database.mongo.repository.CourseMongoRepository;
import com.groupmanager.infrastructure.database.mongo.entities.Offering;
import com.groupmanager.service.interfaces.FindAllCourses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllCoursesUseCase implements FindAllCourses {
    private final CourseMongoRepository courseRepository;

    @Override
    public List<CourseDto> listAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::toCourseDto).collect(Collectors.toList());
    }

    private CourseDto toCourseDto(Course course) {
        List<OfferingDto> offeringDtos = course.getOfferings().stream()
                .map(this::toOfferingDto)
                .collect(Collectors.toList());

        return CourseDto.builder()
                .code(course.getCode())
                .institute(course.getInstitute())
                .level(course.getLevel())
                .name(course.getName())
                .offerings(offeringDtos)
                .build();
    }

    private OfferingDto toOfferingDto(Offering offering) {
        return OfferingDto.builder()
                .classRoom(offering.getClasss())
                .teacher(offering.getProfessor())
                .build();
    }
}
