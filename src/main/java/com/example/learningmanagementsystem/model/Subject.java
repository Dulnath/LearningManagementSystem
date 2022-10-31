package com.example.learningmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@Document(collection="Subject")
public class Subject {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @JsonProperty("id")
    private String id;
    private String subjectName;
    private String subjectCode;
    private double noOfCredits;

    public Subject(String subjectName, String subjectCode, double noOfCredits) {
        this.id = new ObjectId().toString();
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.noOfCredits = noOfCredits;
    }
    public Subject() {
        this.id = new ObjectId().toString();
    }
}
