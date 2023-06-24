package com.groupmanager.infrastructure.database.mongo.entities;

import com.groupmanager.dto.GroupDto;
import com.groupmanager.enumeration.Categories;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "groups")
@Data
@Builder
public class Group {
    @Id
    private ObjectId id;
    private String name;
    private Categories category;
    private String desc;
    private String link;
    private String courseCode;
    private String classRoom;
    private String semester;

    public static Group from(GroupDto dto) {
        return Group.builder()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getCategory())
                .desc(dto.getDesc())
                .link(dto.getLink())
                .courseCode(dto.getCourseCode())
                .classRoom(dto.getClassRoom())
                .semester(dto.getSemester())
                .build();
    }

}
