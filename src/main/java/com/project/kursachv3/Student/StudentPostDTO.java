package com.project.kursachv3.Student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.kursachv3.Practice.PracticePostDTO;
import org.modelmapper.ModelMapper;

public class StudentPostDTO {
    private String fullName;
    @JsonIgnore
    private String address = "-";
    @JsonIgnore
    private String contacts = "-";
    @JsonIgnore
    private String comment = "-";
    @JsonIgnore
    private String commentFromStudent = "-";
    @JsonIgnore
    private PracticePostDTO practicePostDTO = new PracticePostDTO();
    private String groupName;

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getContacts() {
        return contacts;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentFromStudent() {
        return commentFromStudent;
    }

    public PracticePostDTO getPracticePostDTO() {
        return practicePostDTO;
    }

    public String getGroupName() {
        return groupName;
    }
    public static Student convertFromDTO(StudentPostDTO studentPostDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Student student = modelMapper.map(studentPostDTO, Student.class);
        return student;
    }
}
