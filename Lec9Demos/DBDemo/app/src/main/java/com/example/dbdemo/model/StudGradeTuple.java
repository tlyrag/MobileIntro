package com.example.dbdemo.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

public class StudGradeTuple {


    @ColumnInfo(name = "studentname")
    @NonNull
    String StudName;

    @ColumnInfo(name="studgrade")
    @NonNull
    Double StudGrade;

    @NonNull
    public String getStudName() {
        return StudName;
    }

    public void setStudName(@NonNull String studName) {
        StudName = studName;
    }

    @NonNull
    public Double getStudGrade() {
        return StudGrade;
    }

    public void setStudGrade(@NonNull Double studGrade) {
        StudGrade = studGrade;
    }
}
