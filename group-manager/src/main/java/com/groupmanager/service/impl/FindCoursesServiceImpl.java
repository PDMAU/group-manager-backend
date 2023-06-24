package com.groupmanager.service.impl;

import com.groupmanager.dto.CourseDto;
import com.groupmanager.model.Course;
import com.groupmanager.repository.CourseRepository;
import com.groupmanager.service.FindCoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindCoursesServiceImpl implements FindCoursesService {
    private final CourseRepository courseRepository;

    @Override
    public List<CourseDto> listAll() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> dtos = new ArrayList<>();
        for (Course course : courses) {
            CourseDto courseDto = CourseDto.builder()
                    .code(course.getCode())
                    .institute(course.getInstitute())
                    .level(course.getLevel())
                    .name(course.getName())
                    //.offerings() faltando converter
                    .build();
            dtos.add(courseDto);
        }
        return dtos;
    }
}
