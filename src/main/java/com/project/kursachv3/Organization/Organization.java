package com.project.kursachv3.Organization;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.kursachv3.Student.Student;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "organizaiton")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String contacts;
    private String contactName;
    private String requirements;
    @JsonBackReference
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
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


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

@Repository
interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByName(String name);
    long countByName(String name);

    @Query("SELECT o.name FROM Organization o")
    List<String> getAllOrganizationNames();
}
