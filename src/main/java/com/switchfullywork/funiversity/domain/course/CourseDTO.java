package com.switchfullywork.funiversity.domain.course;

import com.switchfullywork.funiversity.domain.professor.Professor;

public class CourseDTO {

    private final Long id;
    private final String name;
    private int amountOfStudyPoints;
    private final Professor professor;

    public CourseDTO(Long id, String name, int amountOfStudyPoints, Professor professor) {
        this.id = id;
        this.name = name;
        setAmountOfStudyPoints(amountOfStudyPoints);
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    private void setAmountOfStudyPoints(int amountOfStudyPoints) {
        if(amountOfStudyPoints< 7 && amountOfStudyPoints > 0){
            this.amountOfStudyPoints = amountOfStudyPoints;
        }
        if(amountOfStudyPoints < 1){
            this.amountOfStudyPoints = 1;
        }
        if(amountOfStudyPoints>6){
            this.amountOfStudyPoints = 6;
        }
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
