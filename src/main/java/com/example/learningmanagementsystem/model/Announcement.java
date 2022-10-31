package com.example.learningmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection="Announcement")
public class Announcement {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @JsonProperty("id")
    private String id;
    private String announcementName;
    private String postedDate;
    private String postedBy;
    private String description;
    private String sub_id;


    public Announcement( String announcementName, String postedDate, String postedBy, String description, String sub_id) {
        this.id = new ObjectId().toString();
        this.announcementName = announcementName;
        this.postedDate = postedDate;
        this.postedBy = postedBy;
        this.description = description;
        this.sub_id=sub_id;

    }

    public Announcement() {
        this.id = new ObjectId().toString();
    }
}
