package com.example.dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.dbdemo.R;
import com.example.dbdemo.adapter.StudentAdapter;
import com.example.dbdemo.databinding.ActivityMainBinding;
import com.example.dbdemo.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> StudentList = new ArrayList<>();
    public String TAG = "DBDemoo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ReadStudentCSV();
        Log.d(TAG, "onCreate: "+ StudentList);
        StudentAdapter adpt = new StudentAdapter(StudentList);
        binding.listViewStudents.setAdapter(adpt);
    }

    private List<Student> ReadStudentCSV() {
        List<Student> Students = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String studentLine;

        try {
            if((studentLine=reader.readLine()) !=null) {
                //hader
            } while ((studentLine= reader.readLine())!=null) {
                String[] studArr = studentLine.split(",");
                Student newStud = new Student(studArr[0],studArr[1],studArr[2]);
                StudentList.add(newStud);

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Students;
    }
}