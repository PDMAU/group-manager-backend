package com.groupmanager.service.interfaces;

import com.groupmanager.dto.CourseDto;

import java.util.List;

public interface FilterDisciplinesByInstitute {
    List<CourseDto> filterDisciplinesByInstitute(String intitute);
}
