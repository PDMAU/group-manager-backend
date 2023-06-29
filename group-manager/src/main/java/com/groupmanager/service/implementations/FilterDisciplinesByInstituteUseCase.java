package com.groupmanager.service.implementations;

import com.groupmanager.dto.CourseDto;
import com.groupmanager.dto.OfferingDto;
import com.groupmanager.infrastructure.database.mongo.entities.Course;
import com.groupmanager.infrastructure.database.mongo.entities.Offering;
import com.groupmanager.infrastructure.database.mongo.repository.CourseMongoRepository;
import com.groupmanager.service.interfaces.FilterDisciplinesByInstitute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterDisciplinesByInstituteUseCase implements FilterDisciplinesByInstitute {
    private final CourseMongoRepository courseRepository;

    public List<CourseDto> filterDisciplinesByInstitute(String intitute) {
        List<Course> courses = courseRepository.findByInstitute(intitute);
        return courses.stream().map(this::toCourseDto).collect(Collectors.toList());
    }

    private CourseDto toCourseDto(Course course) {
        if(Objects.nonNull(course)){
            List<OfferingDto> offeringDtos = new ArrayList<>(); // Inicialização

            if(Objects.nonNull(course.getOfferings())){
                offeringDtos = course.getOfferings().stream()
                        .map(this::toOfferingDto)
                        .collect(Collectors.toList());
            }

            return CourseDto.builder()
                    .code(course.getCode())
                    .institute(course.getInstitute())
                    .level(course.getLevel())
                    .name(course.getName())
                    .offerings(offeringDtos)
                    .build();
        }
        return CourseDto.builder().build();
    }

    private OfferingDto toOfferingDto(Offering offering) {
        if(Objects.nonNull(offering)){
            String classRoom = Objects.nonNull(offering.getClasss()) ? offering.getClasss() : "";
            String teacher = Objects.nonNull(offering.getProfessor()) ? offering.getProfessor() : "";

            return OfferingDto.builder()
                    .classRoom(classRoom)
                    .teacher(teacher)
                    .build();
        }
        return OfferingDto.builder().build();
    }
}

