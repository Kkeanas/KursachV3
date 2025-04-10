package com.project.kursachv3.Group;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.kursachv3.Student.Student;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "groupl")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

@Repository
interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByName(String name);
    @Query("SELECT g.name FROM Group g")
    List<String> findAllGroupNames();
    boolean existsByName(String name);
}
