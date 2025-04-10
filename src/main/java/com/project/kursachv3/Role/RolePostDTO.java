package com.project.kursachv3.Role;

import org.modelmapper.ModelMapper;

public class RolePostDTO {
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static Role convertFromDTO(RolePostDTO rolePostDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Role role = modelMapper.map(rolePostDTO, Role.class);
        return role;
    }
}
