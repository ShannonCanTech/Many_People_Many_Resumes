package com.example.resumebuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Ref;
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

//   Removed  fetch = FetchType.EAGER because of BeanCreation Exception: cannot simultaneously fetch multiple bags

    //Work Experience
   /* private String jobTitle;
    private String organization;*/
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
//    private List<Experience> experiences = new ArrayList<Experience>();
//    private Set<Experience> experiences = new HashSet<Experience>();
    private List<Experience> experiences;

    //EducationalAchievements
/*    private String degree;
    private String institution;*/
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
//    private List<Education> educations = new ArrayList<Education>();
//    private Set<Education> educations = new HashSet<Education>();
    private List<Education> educations;

    //Skills
/*    private String skills;
    private String proficiency;*/
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
//    private List<Skill> skill = new ArrayList<Skill>();
//    private Set<Skill> skills = new HashSet<Skill>();
    private List<Skill> skills;

//    References
    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
//    private List<Reference> references = new ArrayList<Reference>();
//    private Set<Reference> references = new HashSet<Reference>();
    private List<Reference> references;


    @ManyToMany()
    private Set<Person> personResume;

    public Resume() {
        super();
        personResume = new HashSet<>();
        experiences = new ArrayList<>();
        educations = new ArrayList<>();
        skills = new ArrayList<>();
        references = new ArrayList<>();
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

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    /*public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }*/

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }
}
