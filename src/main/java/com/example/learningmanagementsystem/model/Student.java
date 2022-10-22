package com.example.learningmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="Student")
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;

    public Student(int id, String firstName, String lastName, String dateOfBirth, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Student() {

    }
}