package com.groupmanager.infrastructure.database.mongo.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "2023s1")
@Data
public class Course {
    @Id
    private ObjectId id;
    private String code;
    private String name;
    private String level;
    private String institute;
    private String syllabus;
    private List<Offering> offerings;
}
