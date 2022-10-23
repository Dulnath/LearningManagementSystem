package com.example.learningmanagementsystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscussionForum {
    private int commentId;
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private int teacherId;
    private String teacherFirstName;
    private String teacherLastName;
    private int responseTo;
    private String title;
    private String comment;

    public DiscussionForum(int commentId, int studentId, String studentFirstName, String studentLastName, int teacherId, String teacherFirstName, String teacherLastName, int responseTo, String title, String comment){
        this.commentId = commentId;
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.teacherId = teacherId;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.responseTo = responseTo;
        this.title = title;
        this.comment = comment;
    }

}
