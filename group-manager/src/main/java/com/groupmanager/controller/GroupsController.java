package com.groupmanager.controller;

import com.groupmanager.dto.GroupDto;
import com.groupmanager.enumeration.Categories;
import com.groupmanager.service.interfaces.CreateGroup;
import com.groupmanager.service.interfaces.DeleteGroup;
import com.groupmanager.service.interfaces.FindAllGroups;
import com.groupmanager.service.interfaces.FindGroupsByCategory;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
@CrossOrigin(origins = "*")
public class GroupsController {

    private final CreateGroup createGroup;
    private final FindAllGroups findAllGroups;
    private final FindGroupsByCategory findGroupsByCategory;
    private final DeleteGroup deleteGroup;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@RequestBody GroupDto body) {
        createGroup.execute(body);
    }

    @GetMapping()
    public ResponseEntity<List<GroupDto>>  listAll() {
        return ResponseEntity.ok().body(findAllGroups.execute());
    }

    @GetMapping("/category/{category}")
    public List<GroupDto> getGroupsByCategory(@PathVariable Categories category) {
        return findGroupsByCategory.execute(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroup(@PathVariable ObjectId id) {
         deleteGroup.execute(id);
    }
}
