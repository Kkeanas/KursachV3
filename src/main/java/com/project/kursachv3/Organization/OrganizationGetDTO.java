package com.project.kursachv3.Organization;

import org.modelmapper.ModelMapper;

public class OrganizationGetDTO {
    private String name = "-";
    private String address = "-";
    private String contacts = "-";
    private String contactName = "-";
    private String requirements = "-";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    public static OrganizationGetDTO convertToDTO(Organization organization) {
        ModelMapper modelMapper = new ModelMapper();
        if (organization == null) {
            return null;
        }
        OrganizationGetDTO organizationGetDTO = modelMapper.map(organization, OrganizationGetDTO.class);
        return organizationGetDTO;
    }
}
