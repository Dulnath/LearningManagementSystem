package com.example.learningmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document(collection="Student")
public class Subject {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    private long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;

    public Subject(String firstName, String lastName, String dateOfBirth, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Subject() {

    }
}