package com.switchfullywork.funiversity.domain.professor;


import java.util.UUID;

public class Professor {

    private Long id;
    private String firstName;
    private String lastName;


    public Professor() {
    }

    public Professor(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
