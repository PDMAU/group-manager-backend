package com.groupmanager.service.interfaces;

import com.groupmanager.dto.GroupDto;

import java.util.List;

public interface FindAllGroups {
    List<GroupDto> execute();
}
