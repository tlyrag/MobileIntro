package com.example.dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

//import com.example.dbdemo.R;
import com.example.dbdemo.R;
import com.example.dbdemo.adapters.StudentAdapter;
import com.example.dbdemo.databases.CollegeDatabase;
import com.example.dbdemo.databinding.ActivityMainBinding;
import com.example.dbdemo.model.Grade;
import com.example.dbdemo.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    List<Student> StudentList = new ArrayList<>();
    List<Grade> GradeList = new ArrayList<>();
    CollegeDatabase cdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding
                = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        StudentList = ReadStudentCSV();
        GradeList = ReadGrades();
        Log.d("DBDEMO",GradeList.size() + " Grades in the file");

        //binding.listViewStudents.setAdapter(new StudentAdapter(StudentList));

        cdb = Room.databaseBuilder(getApplicationContext(),CollegeDatabase.class,"college.db").build();
        insertDatabase(binding);

        binding.btnNext.setOnClickListener(view -> {
            Intent newIntent = new Intent(this,NextActivity.class);
            startActivity(newIntent);
        });


    }
    private void insertDatabase(ActivityMainBinding binding) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            cdb.studentDao().insertStudentFromList(StudentList);
            cdb.gradeDao().insertGrades(GradeList);
            List<Student> StudentsFromDB = cdb.studentDao().GetAllStudents();
            runOnUiThread(() -> {
                binding.listViewStudents.setAdapter(new StudentAdapter(StudentsFromDB));
            });

        });
    }

    private List<Grade> ReadGrades() {
        List<Grade> grades = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.grades);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String gradeLine;

        try {
            if((gradeLine = reader.readLine())!=null) {
                //header
            }
            while((gradeLine = reader.readLine())!=null) {
                String[] eachGradeFields = gradeLine.split(",");
                double grade = Double.parseDouble(eachGradeFields[2]);
                Grade newGrade = new Grade(eachGradeFields[0],eachGradeFields[1],grade);
                grades.add(newGrade);

            }

        } catch (Exception err) {
            Log.d("DBDemo", "ReadGrades: "+ err.getMessage());
            err.printStackTrace();
        }
        return grades;
    }
    private List<Student> ReadStudentCSV(){
        List<Student> Students = new ArrayList<>();
        InputStream inputStream = getResources()
                                    .openRawResource(R.raw.students);
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(inputStream));
        String studentLine;

        try {
            if ((studentLine = reader.readLine()) != null){
                //process header
            }
            while((studentLine = reader.readLine()) != null){
                String[] eachStudFields = studentLine.split(",");
                Student eachStudent =
                        new Student(eachStudFields[0],
                                eachStudFields[1], eachStudFields[2]);
                Students.add(eachStudent); //cannot add to a null list
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return Students;
    }


}