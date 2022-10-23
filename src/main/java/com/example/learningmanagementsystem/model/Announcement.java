package com.example.learningmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection="Announcement")
public class Announcement {
    private int id;
    private String announcementName;
    private String postedDate;
    private String postedBy;
    private String description;

    public Announcement(int id, String announcementName, String postedDate, String postedBy, String description) {
        this.id = id;
        this.announcementName = announcementName;
        this.postedDate = postedDate;
        this.postedBy = postedBy;
        this.description = description;
    }

    public Announcement() {

    }
}
