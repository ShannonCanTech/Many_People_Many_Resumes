package com.example.resumebuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Added Resume Name Request for user
    @NotEmpty
    private String resumeName;

    //Optional
    private String objective;

    //Work Experience
    private String jobTitle;
    private String organization;
    @OneToMany(mappedBy = "user_experience")
    private List<Experience> experiences = new ArrayList<Experience>();

    //EducationalAchievements
    private String degree;
    private String institution;
    @OneToMany(mappedBy = "user_education")
    private List<Education> educations = new ArrayList<Education>();

    //Skills
    private String skills;
    private String proficiency;
    @OneToMany(mappedBy = "user_skills")
    private List<Skill> skill = new ArrayList<Skill>();


    @ManyToMany()
    private Set<Person> personResume;

    public Resume() {
        personResume = new HashSet<>();
    }

    public Resume(@NotEmpty String resumeName) {
        this.resumeName = resumeName;
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

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public Set<Person> getPersonResume() {
        return personResume;
    }

    public void setPersonResume(Set<Person> personResume) {
        this.personResume = personResume;
    }
}
