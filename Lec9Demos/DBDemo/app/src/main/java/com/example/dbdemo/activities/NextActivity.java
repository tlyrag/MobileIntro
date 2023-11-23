package com.example.dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.dbdemo.R;
import com.example.dbdemo.databases.CollegeDatabase;
import com.example.dbdemo.databinding.ActivityNextBinding;
import com.example.dbdemo.model.Grade;
import com.example.dbdemo.model.StudGradeTuple;
import com.example.dbdemo.model.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NextActivity extends AppCompatActivity {
    String TAG = "dbDemo";
    CollegeDatabase cdb;
    ActivityNextBinding binding;
    StringBuilder outputText = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_next);
        binding = ActivityNextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cdb = Room.databaseBuilder(getApplicationContext(), CollegeDatabase.class,"college.db").build();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {

            int retValue = cdb.studentDao().deleteStudentWithId("312345");
            Log.d(TAG, "onCreate: Return Value from delete is "+retValue);
            List<Student> Students = cdb.studentDao().GetAllStudents();
            outputText.append("Display all Students after deletion..\n");
            outputText.append(String.format("%-10s%-10s%-10s \n","Id","Name","Dept"));




            for(Student student:Students) {

                outputText.append(String.format("%-10s%-10s%-10s \n",student.getStudId(),student.getStudName(),student.getStudDept()));

            }
            outputText.append("Displaying Grades.....\n");
            outputText.append(String.format("%-10s%-10s%-10s","CourseId \n","StudId","Grade"));
            List<Grade> AllGrades = cdb.gradeDao().GetAllGrades();
            for(Grade grade:AllGrades) {
                outputText.append(String.format("%-10s%-10s%-10.2f \n",grade.getCourseId(),grade.getStudentID(),grade.getStudGrade()));
            }

            //outputText.setLength(0);
            outputText.append("Increasing grade for student.. \n");

            int retUpdate = cdb.gradeDao().IncreaseGradeForOneStudent("123567");
            Log.d(TAG, "onCreate: Updated Records increased for one student " + retUpdate);

            outputText.append("\n\n Update grades after update\n\n");

            outputText.append("Displaying Grades.....\n");
            outputText.append(String.format("%-10s%-10s%-10s \n","CourseId ","StudId","Grade"));
            AllGrades = cdb.gradeDao().GetAllGrades();
            for(Grade grade:AllGrades) {
                outputText.append(String.format("%-10s%-10s%-10.2f \n",grade.getCourseId(),grade.getStudentID(),grade.getStudGrade()));
            }
            List<String> StudIds2= Arrays.asList("300234","123567");
            int retUpdate2 = cdb.gradeDao().IncreaseGradesForStudentsInCourse(StudIds2,"CSIS3475");
            Log.d(TAG, "onCreate: Updated Records increased for one student " + retUpdate2);
            outputText.append("Displaying Grades.....\n");
            outputText.append(String.format("%-10s%-10s%-10s \n","CourseId","StudId","Grade"));
             AllGrades = cdb.gradeDao().GetAllGrades();
            for(Grade grade:AllGrades) {
                outputText.append(String.format("%-10s%-10s%-10.2f \n",grade.getCourseId(),grade.getStudentID(),grade.getStudGrade()));
            }

            outputText.append("\n\n Displaying stud name and grade.. \n\n");

            List<StudGradeTuple> StudNamesAndGrades = cdb.studentGradeDao().GetStudentNameAndGrades();

            outputText.append(String.format("%-10s%-10s \n","Name","Grade"));
            for(StudGradeTuple grade:StudNamesAndGrades) {
                outputText.append(String.format("%-10s%-10s \n",grade.getStudName(),grade.getStudGrade()));
            }

            runOnUiThread(() -> {
                binding.txtViewSummary.setText(outputText);
            });

        });
    }


}