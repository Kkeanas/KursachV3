package com.project.kursachv3.Practice;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.kursachv3.Student.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "practice")
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String isPayed;
    @Column(nullable = false)
    private String relevance;
    @Column(nullable = false)
    private String material;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String director;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String futureWork;
    @Column(nullable = false)
    private String nextYear;
    @Column(nullable = false)
    private String reportPassed;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String work;
    @JsonBackReference
    @OneToOne(mappedBy = "practice", cascade = CascadeType.ALL)
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(String isPayed) {
        this.isPayed = isPayed;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFutureWork() {
        return futureWork;
    }

    public void setFutureWork(String futureWork) {
        this.futureWork = futureWork;
    }

    public String getNextYear() {
        return nextYear;
    }

    public void setNextYear(String nextYear) {
        this.nextYear = nextYear;
    }

    public String getReportPassed() {
        return reportPassed;
    }

    public void setReportPassed(String reportPassed) {
        this.reportPassed = reportPassed;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

@Repository
interface PracticeRepository extends JpaRepository<Practice, Long> {
    Practice findByStudent(Student student);
}
