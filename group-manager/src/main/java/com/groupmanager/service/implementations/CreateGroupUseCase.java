package com.groupmanager.service.implementations;

import com.groupmanager.dto.GroupDto;
import com.groupmanager.infrastructure.database.mongo.entities.Group;
import com.groupmanager.infrastructure.database.mongo.repository.GroupMongoRepository;
import com.groupmanager.service.interfaces.CreateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateGroupUseCase implements CreateGroup {
    private final GroupMongoRepository groupMongoRepository;

    public void execute(GroupDto groupDto) {
        groupMongoRepository.save(Group.from(groupDto));
    }




}
