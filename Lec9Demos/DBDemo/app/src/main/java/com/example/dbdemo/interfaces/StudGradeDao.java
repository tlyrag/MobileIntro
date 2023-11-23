package com.example.dbdemo.interfaces;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.dbdemo.model.StudGradeTuple;

import java.util.List;
@Dao
public interface StudGradeDao {

    @Query(
            "SELECT studentname, studgrade " +
            "FROM students as s " +
            "INNER JOIN grades as g " +
                "ON s.studentid = g.studentid"
    )
    List<StudGradeTuple> GetStudentNameAndGrades();


    @Query(
            "SELECT studentname, studgrade " +
            "FROM students as s " +
            "INNER JOIN grades as g " +
                "ON s.studentid = g.studentid " +
                    "WHERE studgrade>:gradeThreshold "


    )
    List<StudGradeTuple> GetStudentNamesAndGradesWithHIghScore(double gradeThreshold);
}
