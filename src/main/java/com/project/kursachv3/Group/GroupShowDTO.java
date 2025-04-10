package com.project.kursachv3.Group;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.kursachv3.Student.Student;
import com.project.kursachv3.Student.StudentShowDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupShowDTO {
    private long id;
    private String name;
    @JsonProperty("students")
    private List<StudentShowDTO> studentShowDTOList = new ArrayList<>();

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

    public List<StudentShowDTO> getStudentShowDTOList() {
        return studentShowDTOList;
    }

    public void setStudentShowDTOList(List<StudentShowDTO> studentShowDTOList) {
        this.studentShowDTOList = studentShowDTOList;
    }

    public static GroupShowDTO convertToDTO(Group group) {
        ModelMapper modelMapper = new ModelMapper();
        GroupShowDTO groupShowDTO = modelMapper.map(group, GroupShowDTO.class);
        List<Student> students = group.getStudents();
        groupShowDTO.setStudentShowDTOList(students.stream()
                .map(StudentShowDTO::convertToDTO)
                .collect(Collectors.toList()));
        return groupShowDTO;
    }
}
