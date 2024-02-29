package org.Aruiz.controller;

import org.Aruiz.exception.RecordNotFoundException;
import org.Aruiz.model.Group;
import org.Aruiz.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable int id) {
        try {
            Group group = groupService.getGroupById(id);
            return ResponseEntity.ok(group);
        } catch (RecordNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Group> createOrUpdateGroup(@RequestBody Group group) {
        Group savedGroup = groupService.createOrUpdateGroup(group);
        return ResponseEntity.ok(savedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupById(@PathVariable int id) {
        try {
            groupService.deleteGroupById(id);
            return ResponseEntity.noContent().build();
        } catch (RecordNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

