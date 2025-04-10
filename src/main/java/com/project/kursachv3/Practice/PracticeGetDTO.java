package com.project.kursachv3.Practice;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.modelmapper.ModelMapper;

public class PracticeGetDTO {
    private long id;
    private String isPayed;
    private String relevance;
    private String material;
    private String description;
    private String director;
    private String date;
    private String futureWork;
    private String nextYear;
    private String reportPassed;
    private String position;
    private String work;

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

    public static PracticeGetDTO convertToDTO(Practice practice) {
        ModelMapper modelMapper = new ModelMapper();
        PracticeGetDTO practiceGetDTO = modelMapper.map(practice, PracticeGetDTO.class);
        return practiceGetDTO;
    }
}
