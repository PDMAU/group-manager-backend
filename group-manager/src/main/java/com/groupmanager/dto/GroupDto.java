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

    private Categories category;

    private String desc;

    private String link;

    private String courseCode;

    private String classRoom;

    private String semester;
}
