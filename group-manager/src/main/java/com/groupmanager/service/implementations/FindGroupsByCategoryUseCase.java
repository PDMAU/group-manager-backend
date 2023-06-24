package com.groupmanager.service.implementations;

import com.groupmanager.dto.GroupDto;
import com.groupmanager.enumeration.Categories;
import com.groupmanager.infrastructure.database.mongo.entities.Group;
import com.groupmanager.infrastructure.database.mongo.repository.GroupMongoRepository;
import com.groupmanager.service.interfaces.FindGroupsByCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindGroupsByCategoryUseCase implements FindGroupsByCategory {
    private final GroupMongoRepository groupMongoRepository;

    public List<GroupDto> execute(Categories category) {
        List<Group> groups = groupMongoRepository.findByCategory(category);
        return groups.stream().map(this::toDto).toList();
    }

    private GroupDto toDto(Group group) {
        return GroupDto.builder()
                .id(group.getId())
                .name(group.getName())
                .category(group.getCategory())
                .desc(group.getDesc())
                .link(group.getLink())
                .courseCode(group.getCourseCode())
                .classRoom(group.getClassRoom())
                .semester(group.getSemester())
                .build();
    }



}
