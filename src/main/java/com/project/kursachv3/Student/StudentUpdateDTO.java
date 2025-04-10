package com.project.kursachv3.Student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.kursachv3.Practice.Practice;
import com.project.kursachv3.Practice.PracticePostDTO;
import org.modelmapper.ModelMapper;

public class StudentUpdateDTO {
    private String address;
    private String contacts;
    private String comment;
    private String commentFromStudent;
    @JsonProperty("practice")
    private PracticePostDTO practicePostDTO;
    private String organizationName;

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

    public PracticePostDTO getPracticePostDTO() {
        return practicePostDTO;
    }

    public void setPracticePostDTO(PracticePostDTO practicePostDTO) {
        this.practicePostDTO = practicePostDTO;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public static Student convertFromDTO(StudentUpdateDTO studentUpdateDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(studentUpdateDTO, Student.class);
        student.setPractice(PracticePostDTO.convertFromDTO(studentUpdateDTO.practicePostDTO));
        return student;
    }
}
