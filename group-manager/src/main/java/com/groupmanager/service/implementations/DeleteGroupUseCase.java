package com.groupmanager.service.implementations;

import com.groupmanager.infrastructure.database.mongo.repository.GroupMongoRepository;
import com.groupmanager.service.interfaces.DeleteGroup;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteGroupUseCase implements DeleteGroup {
    private final GroupMongoRepository groupMongoRepository;

    public void execute(ObjectId id) {
        groupMongoRepository.deleteById(id.toString());
    }




}
