package com.example.dbdemo.model;

public class Student {
    private String StudId;
    private String StudName;
    private String StudDept;

    public String getStudId() {
        return StudId;
    }

    public void setStudId(String studId) {
        StudId = studId;
    }

    public String getStudName() {
        return StudName;
    }

    public void setStudName(String studName) {
        StudName = studName;
    }

    public String getStudDept() {
        return StudDept;
    }

    public void setStudDept(String studDept) {
        StudDept = studDept;
    }

    public Student(String studId, String studName, String studDept) {
        StudId = studId;
        StudName = studName;
        StudDept = studDept;
    }
}
