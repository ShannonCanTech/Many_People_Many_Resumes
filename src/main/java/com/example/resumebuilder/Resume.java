package com.example.resumebuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Work Experience
    private String jobTitle;
    private String organization;

    //EducationalAchievements
    private String degree;
    private String institution;

    //Skills
    private String skills;
    private String proficiency;

    @ManyToMany()
    private Set<Person> personResume;

    public Resume() {
        personResume = new HashSet<>();
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public Set<Person> getPersonResume() {
        return personResume;
    }

    public void setPersonResume(Set<Person> personResume) {
        this.personResume = personResume;
    }
}
