package com.example.learningmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;


@Getter
@Setter
@ToString
@Document(collection="Subject")
public class Subject {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    private long id;
    private String subjectName;
private Announcement announcement;

    /*
@OneToMany(targetEntity = Announcement.class,cascade = CascadeType.ALL)
@JoinColumn(name="sa_fk",referencedColumnName = "id")
 private List<Announcement> announcements;
 */

    public Subject(String subjectName) {

        this.subjectName = subjectName;

    }
    public Subject() {

    }
}