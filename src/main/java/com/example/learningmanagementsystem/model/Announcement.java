package com.example.learningmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="Announcement")
public class Announcement {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    private long id;
    private String announcementName;
    private String postedDate;
    private String postedBy;
    private String description;

    public Announcement( String announcementName, String postedDate, String postedBy, String description) {
        this.id = id;
        this.announcementName = announcementName;
        this.postedDate = postedDate;
        this.postedBy = postedBy;
        this.description = description;
    }

    public Announcement() {

    }
}
