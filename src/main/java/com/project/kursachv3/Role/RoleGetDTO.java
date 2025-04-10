package com.project.kursachv3.Role;

import org.modelmapper.ModelMapper;

public class RoleGetDTO {
    private long id;
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static RoleGetDTO convertToDTO(Role role) {
        ModelMapper modelMapper = new ModelMapper();
        RoleGetDTO roleGetDTO = modelMapper.map(role, RoleGetDTO.class);
        return roleGetDTO;
    }
}
