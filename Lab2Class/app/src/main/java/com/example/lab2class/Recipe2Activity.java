package com.example.lab2class;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recipe2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe2);

        Button btnBack = findViewById(R.id.btnBack2);

       btnBack.setOnClickListener((View view) -> {
           startActivity(new Intent(Recipe2Activity.this,MainActivity.class));
        }

       );
    }
}