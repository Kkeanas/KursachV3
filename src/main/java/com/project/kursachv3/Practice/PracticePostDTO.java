package com.project.kursachv3.Practice;

import org.modelmapper.ModelMapper;

public class PracticePostDTO {
    private String isPayed = "-";
    private String relevance = "-";
    private String material = "-";
    private String description = "-";
    private String director = "-";
    private String date = "-";
    private String futureWork = "-";
    private String nextYear = "-";
    private String reportPassed = "-";
    private String position = "-";
    private String work = "-";

    public String getIsPayed() {
        return isPayed;
    }

    public String getRelevance() {
        return relevance;
    }

    public String getMaterial() {
        return material;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getDate() {
        return date;
    }

    public String getFutureWork() {
        return futureWork;
    }

    public String getNextYear() {
        return nextYear;
    }

    public String getReportPassed() {
        return reportPassed;
    }

    public String getPosition() {
        return position;
    }

    public String getWork() {
        return work;
    }
    public static Practice convertFromDTO(PracticePostDTO PracticePostDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Practice practice = modelMapper.map(PracticePostDTO, Practice.class);
        return practice;
    }
}
