package com.project.kursachv3.Group;

import org.modelmapper.ModelMapper;

public class GroupPostDTO {
    private String name;

    public String getName() {
        return name;
    }
    public static Group convertFromDTO(GroupPostDTO groupPostDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Group group = modelMapper.map(groupPostDTO, Group.class);
        return group;
    }
}
