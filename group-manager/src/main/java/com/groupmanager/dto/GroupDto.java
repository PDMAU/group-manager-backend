package com.groupmanager.dto;

import com.groupmanager.enumeration.Categories;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@Builder
public class GroupDto {

    private ObjectId id;

    private String name;

    private String category;

    private String desc;

    private String link;

    private String professor;

    private String groupType;

    private String code;

    private String classRoom;

    private String semester;
}


