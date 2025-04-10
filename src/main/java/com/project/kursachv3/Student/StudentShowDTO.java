package com.project.kursachv3.Student;

import org.modelmapper.ModelMapper;

public class StudentShowDTO {
    private long id;
    private String fullName;

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
    public static StudentShowDTO convertToDTO(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        StudentShowDTO studentDTO = modelMapper.map(student, StudentShowDTO.class);
        return studentDTO;

    }
}
