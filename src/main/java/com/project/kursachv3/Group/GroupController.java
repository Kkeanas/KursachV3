package com.project.kursachv3.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @GetMapping()
    public List<GroupShowDTO> showGroup() {
        List<Group> rawResult = groupService.getAllGroup();
        List<GroupShowDTO> result = rawResult.stream()
                .map(GroupShowDTO::convertToDTO)
                .collect(Collectors.toList());
        return result;
    }
    @PostMapping()
    public GroupShowDTO postGroup(@RequestBody GroupPostDTO groupPostDTO) {
        Group rawResult = groupService.postGroup(groupPostDTO);
        GroupShowDTO result = GroupShowDTO.convertToDTO(rawResult);
        return result;
    }
    @PutMapping("/{id}")
    public GroupShowDTO updateGroupById(@PathVariable long id, @RequestBody GroupPostDTO groupPostDTO) {
        Group rawResult = groupService.updateGroupById(groupPostDTO,id);
        GroupShowDTO result = GroupShowDTO.convertToDTO(rawResult);
        return result;
    }
    @DeleteMapping("/{id}")
    public String deleteGroupById(@PathVariable long id) {
        String name = groupService.deleteGroupById(id);
        return String.format("Группа %s удалена", name);
    }
}
