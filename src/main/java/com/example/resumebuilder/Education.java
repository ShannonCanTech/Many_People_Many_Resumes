package com.example.resumebuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Education {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_education")
    private Resume education;
}
