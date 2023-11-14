package com.example.dbdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

//import com.example.dbdemo.R;
import com.example.dbdemo.R;
import com.example.dbdemo.adapters.StudentAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding
                = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        StudentList = ReadStudentCSV();
        Log.d("DBDEMO",StudentList.size() + " Students in the file");

        binding.listViewStudents.setAdapter(new StudentAdapter(StudentList));

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