package com.project.kursachv3.Student;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.kursachv3.Organization.OrganizationGetDTO;
import com.project.kursachv3.Organization.OrganizationPostDTO;
import com.project.kursachv3.Practice.PracticeGetDTO;
import org.modelmapper.ModelMapper;

public class StudentGetDTO {
    private long id;
    private String fullName;
    private String address;
    private String contacts;
    private String comment;
    private String commentFromStudent;
    @JsonProperty("practice")
    private PracticeGetDTO practiceGetDTO;
    @JsonProperty("organization")
    private OrganizationGetDTO organizationGetDTO = new OrganizationGetDTO();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentFromStudent() {
        return commentFromStudent;
    }

    public void setCommentFromStudent(String commentFromStudent) {
        this.commentFromStudent = commentFromStudent;
    }

    public PracticeGetDTO getPracticeGetDTO() {
        return practiceGetDTO;
    }

    public void setPracticeGetDTO(PracticeGetDTO practiceGetDTO) {
        this.practiceGetDTO = practiceGetDTO;
    }

    public OrganizationGetDTO getOrganizationGetDTO() {
        return organizationGetDTO;
    }

    public void setOrganizationGetDTO(OrganizationGetDTO organizationGetDTO) {
        this.organizationGetDTO = organizationGetDTO;
    }

    public static StudentGetDTO convertToDTO(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        StudentGetDTO studentDTO = modelMapper.map(student, StudentGetDTO.class);
        studentDTO.practiceGetDTO = PracticeGetDTO.convertToDTO(student.getPractice());
        studentDTO.organizationGetDTO = OrganizationGetDTO.convertToDTO(student.getOrganization());
        return studentDTO;
    }
}
