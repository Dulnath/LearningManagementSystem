package com.example.learningmanagementsystem.model;

import com.mongodb.lang.NonNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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