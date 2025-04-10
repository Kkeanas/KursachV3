package com.project.kursachv3.Student;

import com.project.kursachv3.Practice.PracticeGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    @Autowired
    private StudentService studentService;


    @GetMapping()
    public List<StudentShowDTO> getAllStudent() {
        List<Student> rawResult = studentService.getAllStudents();
        List<StudentShowDTO> result = rawResult.stream()
                .map(StudentShowDTO::convertToDTO)
                .collect(Collectors.toList());;
        return result;
    }
    @GetMapping("/{id}")
    public StudentGetDTO getStudentById(@PathVariable long id) {
        Student rawResult = studentService.getStudentById(id);
        StudentGetDTO result = StudentGetDTO.convertToDTO(rawResult);
        return result;
    }

    @PostMapping()
    public StudentShowDTO postStudent(@RequestBody StudentPostDTO studentPostDTO) {
        Student rawResult = studentService.postStudent(studentPostDTO);
        StudentShowDTO result = StudentShowDTO.convertToDTO(rawResult);
        return result;
    }
    @PutMapping("/{id}")
    public StudentGetDTO updateStudentById(@RequestBody StudentUpdateDTO studentUpdateDTO, @PathVariable long id) {
        Student rawResult = studentService.updateStudent(studentUpdateDTO, id);
        StudentGetDTO result = StudentGetDTO.convertToDTO(rawResult);
        return result;
    }
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable long id) {
        String fullName = studentService.deleteStudentById(id);
        return String.format("Студент %s удален",fullName);
    }
}

