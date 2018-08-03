package com.example.resumebuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String jobTitle;
    private String organization;
    private String startDate;
    private String endDate;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="resume_id")
    private Resume resume;

    public Experience() {
        super();
    }

    public Experience(String jobTitle, String organization, String startDate, String endDate, String description, Resume resume) {
        this();
        this.jobTitle = jobTitle;
        this.organization = organization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.resume = resume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
