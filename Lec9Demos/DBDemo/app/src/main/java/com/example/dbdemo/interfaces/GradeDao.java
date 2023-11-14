package com.example.dbdemo.interfaces;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.dbdemo.model.Grade;
import com.example.dbdemo.model.Student;

import java.util.List;

@Dao
public interface GradeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOneGrade(Grade grade);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGrades(List<Grade> gradeList);



    @Query("SELECT * FROM grades")
    List<Grade> GetAllGrades();
}