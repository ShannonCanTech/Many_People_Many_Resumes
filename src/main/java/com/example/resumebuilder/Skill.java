package com.example.resumebuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skill {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_skill")
    private Resume skill;

//  Set constructor just in case it's actually needed
    public Skill(Resume skill) {
        this.skill = skill;
    }
}
