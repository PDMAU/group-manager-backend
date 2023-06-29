package com.groupmanager.service.implementations;

import com.groupmanager.dto.GroupDto;
import com.groupmanager.infrastructure.database.mongo.entities.Group;
import com.groupmanager.infrastructure.database.mongo.repository.GroupMongoRepository;
import com.groupmanager.service.interfaces.FindAllGroups;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllGroupsUseCase implements FindAllGroups {
    private final GroupMongoRepository groupMongoRepository;

    public List<GroupDto> execute() {
        List<Group> groups = groupMongoRepository.findAll();
        return groups.stream().map(this::toDto).toList();
    }

    private GroupDto toDto(Group group) {
        return GroupDto.builder()
                .id(group.getId())
                .name(group.getName())
                .category(group.getCategory())
                .desc(group.getDesc())
                .link(group.getLink())
                .code(group.getCode())
                .classRoom(group.getClassRoom())
                .semester(group.getSemester())
                .professor(group.getProfessor())
                .groupType(group.getGroupType())
                .build();
    }



}
