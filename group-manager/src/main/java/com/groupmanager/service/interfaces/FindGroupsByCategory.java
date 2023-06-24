package com.groupmanager.service.interfaces;

import com.groupmanager.dto.GroupDto;
import com.groupmanager.enumeration.Categories;

import java.util.List;

public interface FindGroupsByCategory {
    List<GroupDto> execute(Categories category);
}
