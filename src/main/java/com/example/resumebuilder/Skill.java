package com.example.resumebuilder;

import javax.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameOfSkill;
    private String proficiency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Skill() {
        super();
    }

    public Skill(String nameOfSkill, String proficiency, Resume resume) {
        this();
        this.nameOfSkill = nameOfSkill;
        this.proficiency = proficiency;
        this.resume = resume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfSkill() {
        return nameOfSkill;
    }

    public void setNameOfSkill(String nameOfSkill) {
        this.nameOfSkill = nameOfSkill;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}
