package com.project.kursachv3.Organization;

import org.modelmapper.ModelMapper;

public class OrganizationShowDTO {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static OrganizationShowDTO convertToDTO(Organization organization) {
        ModelMapper modelMapper = new ModelMapper();
        OrganizationShowDTO organizationShowDTO = modelMapper.map(organization, OrganizationShowDTO.class);
        return organizationShowDTO;
    }
}
