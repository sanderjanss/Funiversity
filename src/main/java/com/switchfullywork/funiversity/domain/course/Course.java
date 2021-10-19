package com.switchfullywork.funiversity.domain.course;

import com.switchfullywork.funiversity.domain.professor.Professor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Course {

    private final Long id;
    private final String name;
    @Min(value = 1, message = "Study points should not be less than 1")
    @Max(value = 6, message = "Study points should not be greater than 6")
    private final int amountOfStudyPoints;
    private final Professor professor;


    public Course(Long id, String name, int amountOfStudyPoints, Professor professor) {
        this.id = id;
        this.name = name;
        //setAmountOfStudyPoints(amountOfStudyPoints);
        this.amountOfStudyPoints = amountOfStudyPoints;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

//    private void setAmountOfStudyPoints(int amountOfStudyPoints) {
//        if(amountOfStudyPoints< 7 && amountOfStudyPoints > 0){
//            this.amountOfStudyPoints = amountOfStudyPoints;
//        }
//        if(amountOfStudyPoints < 1){
//            this.amountOfStudyPoints = 1;
//        }
//        if(amountOfStudyPoints>6){
//            this.amountOfStudyPoints = 6;
//        }
//    }

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


