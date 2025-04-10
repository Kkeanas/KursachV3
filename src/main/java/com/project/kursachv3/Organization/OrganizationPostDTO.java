package com.project.kursachv3.Organization;

import org.modelmapper.ModelMapper;

public class OrganizationPostDTO {
    private String name;
    private String address;
    private String contacts;
    private String contactName;
    private String requirements;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContacts() {
        return contacts;
    }

    public String getContactName() {
        return contactName;
    }

    public String getRequirements() {
        return requirements;
    }

    public static Organization convertFromDTO(OrganizationPostDTO organizationPostDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Organization organization = modelMapper.map(organizationPostDTO, Organization.class);
        return organization;
    }
}
