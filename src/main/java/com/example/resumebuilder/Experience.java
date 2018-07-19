package com.example.resumebuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Experience {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_experience")
    private Resume experience;

//    Not sure whether to extend Resume class just yer
/*    public Experience(@NotEmpty String resumeName, Resume experience) {
        super(resumeName);
        this.experience = experience;
    }*/

    public Experience(Resume experience) {
        this.experience = experience;
    }


//  Are getters and setters needed for a ManyToOne
    public Resume getExperience() {
        return experience;
    }

    public void setExperience(Resume experience) {
        this.experience = experience;
    }

}
