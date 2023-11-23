package com.example.finalpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> studentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void readCSv() {
        InputStream inputStream = getResources().openRawResource(R.raw.Students);
    }
}