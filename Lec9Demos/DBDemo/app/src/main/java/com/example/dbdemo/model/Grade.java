package com.example.dbdemo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "grades", primaryKeys = {"courseid","studentid"}
        ,foreignKeys = @ForeignKey(
                entity = Student.class,parentColumns = "studentid",
                childColumns = "studentid",
                onDelete = ForeignKey.CASCADE)
        ,indices = {@Index("studentid")}
        )
public class Grade {
    @NonNull
    @ColumnInfo(name="courseid")
    private String CourseId;

    @NonNull
    @ColumnInfo(name="studentid")
    private String StudentID;


    @NonNull
    @ColumnInfo(name="studgrade")
    private double StudGrade;

    @NonNull
    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(@NonNull String courseId) {
        CourseId = courseId;
    }

    @NonNull
    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(@NonNull String studentID) {
        StudentID = studentID;
    }

    public double getStudGrade() {
        return StudGrade;
    }

    public void setStudGrade(double studGrade) {
        StudGrade = studGrade;
    }

    public Grade(@NonNull String courseId, @NonNull String studentID, double studGrade) {
        CourseId = courseId;
        StudentID = studentID;
        StudGrade = studGrade;
    }
    public Grade() {}
}
