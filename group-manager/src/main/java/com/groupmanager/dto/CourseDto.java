package com.groupmanager.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseDto {
    private String code;
    private String name;
    private String level;
    private String institute;
    private String syllabus;
    private List<OfferingDto> offerings;
}
