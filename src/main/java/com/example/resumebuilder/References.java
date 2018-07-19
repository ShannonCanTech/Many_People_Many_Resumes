package com.example.resumebuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class References {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_references")
    private Resume reference;
}
