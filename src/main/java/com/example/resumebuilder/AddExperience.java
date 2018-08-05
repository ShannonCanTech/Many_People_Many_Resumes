package com.example.resumebuilder;

import org.hibernate.validator.constraints.EAN;

import javax.persistence.ManyToOne;
import java.util.List;

public class AddExperience {
    @ManyToOne
    private List<Experience> experiences;

    public void addExperience(Experience experience){
        this.experiences.add(experience);
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
