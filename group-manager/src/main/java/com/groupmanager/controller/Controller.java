package com.groupmanager.controller;

import com.groupmanager.dto.CourseDto;
import com.groupmanager.service.FindCoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final FindCoursesService findCoursesService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        List<CourseDto> courseDtos = findCoursesService.listAll();
        return ResponseEntity.ok().body(courseDtos);
    }

}
