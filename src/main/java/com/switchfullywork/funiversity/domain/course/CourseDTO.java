package com.switchfullywork.funiversity.domain.course;

import com.switchfullywork.funiversity.domain.professor.Professor;

public class CourseDTO {

    private final Long id;
    private final String name;
    private final int amountOfStudyPoints;
    private Professor professor;

    public CourseDTO(Long id, String name, int amountOfStudyPoints, Professor professor) {
        this.id = id;
        this.name = name;
        this.amountOfStudyPoints = amountOfStudyPoints;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfStudyPoints() {
        return amountOfStudyPoints;
    }

    public Professor getProfessor() {
        return professor;
    }
}
