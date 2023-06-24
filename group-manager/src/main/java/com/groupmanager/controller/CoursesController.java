package com.groupmanager.controller;

import com.groupmanager.dto.CourseDto;
import com.groupmanager.service.interfaces.FindAllCourses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CoursesController {

    private final FindAllCourses findAllCourses;

    @GetMapping
    public ResponseEntity<List<CourseDto>> list(){

        return ResponseEntity.ok().body(findAllCourses.listAll());
    }

}
