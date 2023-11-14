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

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NextActivity extends AppCompatActivity {
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
            outputText.append("Displaying Grades.....\n");
            List<Grade> AllGrades = cdb.gradeDao().GetAllGrades();
            outputText.append(String.format("%-10s-%-10s%-10s","CourseId","StudId","Grade"));

            for(Grade grade:AllGrades) {
                Log.d("DBDemo", "onCreate: "+AllGrades.get(0).getCourseId());
                outputText.append(String.format("%-10s-%-10s%-10.2f",grade.getCourseId(),grade.getStudentID(),grade.getStudGrade()));

            }
            runOnUiThread(() -> {
                binding.txtViewSummary.setText(outputText);
            });

        });
    }


}