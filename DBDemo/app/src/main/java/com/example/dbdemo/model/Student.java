package com.example.dbdemo.model;

public class Student {
    private String StudID;
    private String StudName;
    private String StudDept;

    @Override
    public String toString() {
        return "Student{" +
                "StudID='" + StudID + '\'' +
                ", StudName='" + StudName + '\'' +
                ", StudDept='" + StudDept + '\'' +
                '}';
    }

    public Student(String studID, String studName, String studDept) {
        StudID = studID;
        StudName = studName;
        StudDept = studDept;
    }

    public String getStudID() {
        return StudID;
    }

    public void setStudID(String studID) {
        StudID = studID;
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
}
