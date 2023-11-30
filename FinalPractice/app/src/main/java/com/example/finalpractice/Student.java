package com.example.finalpractice;

public class Student {

   String name;
   String course;
   String Department;

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    public Student(String name, String course, String department) {
        this.name = name;
        this.course = course;
        Department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", Department='" + Department + '\'' +
                '}';
    }


}
