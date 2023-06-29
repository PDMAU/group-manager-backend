package com.groupmanager.controller;

import com.groupmanager.dto.CourseDto;
import com.groupmanager.dto.InstituteDto;
import com.groupmanager.service.interfaces.FilterDisciplinesByInstitute;
import com.groupmanager.service.interfaces.FindAllCourses;
import com.groupmanager.service.interfaces.FindAllInstitutes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CoursesController {

    private final FindAllCourses findAllCourses;
    private final FindAllInstitutes findAllInstitutes;
    private final FilterDisciplinesByInstitute filterDisciplinesByInstitute;

    @GetMapping
    public ResponseEntity<List<CourseDto>> list(){

        return ResponseEntity.ok().body(findAllCourses.listAll());
    }


    @GetMapping("/institutes")
    public ResponseEntity<List<String>> listAllInstitutes(){

        return ResponseEntity.ok().body(findAllInstitutes.listAllInstitutes());
    }

    @PostMapping("/filterByInstitute")
    public ResponseEntity<List<CourseDto>> filterByInstitute(@RequestBody InstituteDto instituteDto){
        return ResponseEntity.ok().body(filterDisciplinesByInstitute.filterDisciplinesByInstitute(instituteDto.getInstitute()));
    }
}
