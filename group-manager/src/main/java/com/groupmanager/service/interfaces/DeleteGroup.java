package com.groupmanager.service.interfaces;

import org.bson.types.ObjectId;

public interface DeleteGroup {
    void execute(ObjectId id);
}
