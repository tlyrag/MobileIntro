package com.example.dbdemo.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.dbdemo.model.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudents(Student... students);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[] insertStudentFromList(List<Student> Student);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOneStudent(Student student);

    @Query("SELECT * FROM students")
    List<Student> GetAllStudents();

}
