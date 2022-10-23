package com.example.learningmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document(collection="Subject")
public class Subject {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    private long id;
    private String subjectName;


    public Subject(String subjectName) {
        this.id = id;
        this.subjectName = subjectName;

    }
    public Subject() {

    }
}