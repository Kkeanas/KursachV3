package com.project.kursachv3.Student;

import com.project.kursachv3.Group.Group;
import com.project.kursachv3.Group.GroupService;
import com.project.kursachv3.Organization.Organization;
import com.project.kursachv3.Organization.OrganizationService;
import com.project.kursachv3.Practice.Practice;
import com.project.kursachv3.Practice.PracticePostDTO;
import com.project.kursachv3.Practice.PracticeService;
import com.project.kursachv3.User.User;
import com.project.kursachv3.User.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PracticeService practiceService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private UserService userService;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        Student result = studentRepository.findById(id).orElse(null);
        return result;
    }

    public boolean existStudentByFullName(String fullName) {
        return studentRepository.existsByFullName(fullName);
    }
    public Student getStudentByFullName(String fullName) {
        return studentRepository.findByFullName(fullName).orElse(null);
    }

    public Student postStudent(StudentPostDTO studentPostDTO) {
        Student student = StudentPostDTO.convertFromDTO(studentPostDTO);
        if (existStudentByFullName(student.getFullName())) {
            throw new DataIntegrityViolationException("Студент с таким именем уже существует");
        }
        Group group = groupService.getGroupByName(studentPostDTO.getGroupName());
        if (group == null) {
            throw new DataIntegrityViolationException("Такой группы не существует");
        }
        User user = userService.generateUser();
        student.getPractice().setStudent(student);
        student.setGroup(group);
        student.setUser(user);
        return studentRepository.save(student);

    }

    public String deleteStudentById(long id) {
        Student student = getStudentById(id);
        if (student != null) {
            studentRepository.deleteById(id);
            return student.getFullName();
        }
        throw new DataIntegrityViolationException(String.format("Студента с id=%d не существует", id));
    }

    public Student updateStudent(StudentUpdateDTO studentUpdateDTO, long id) {
        Student old = getStudentById(id);
        if (old == null) {
            throw new DataIntegrityViolationException(String.format("Студента с id = %d не существует",id));
        }

        Organization organization = organizationService.getOrganizationByName(studentUpdateDTO.getOrganizationName());
        if (organization == null) {
            throw new DataIntegrityViolationException(String.format("Организация с именем = %s не существует", studentUpdateDTO.getOrganizationName()));
        }
        Student newS = StudentUpdateDTO.convertFromDTO(studentUpdateDTO);
        newS.setFullName(old.getFullName());
        newS.setId(old.getId());
        newS.getPractice().setStudent(newS);
        newS.getPractice().setId(old.getPractice().getId());
        newS.setOrganization(organization);
        return studentRepository.save(newS);
    }
}
