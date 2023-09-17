package com.example.lab2class;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecipieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipie);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener((View view)-> {
            startActivity(new Intent(RecipieActivity.this, MainActivity.class));
        });



    }
}