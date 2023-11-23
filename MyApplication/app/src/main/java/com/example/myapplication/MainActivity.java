package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ActionBar actBar;
    final String TAG ="APP";
    Button btnGoDog;
    Button btnGoPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar();
        getItemsInView();

        btnGoDog.setOnClickListener(view->{
            startActivity(new Intent(MainActivity.this, DogFood.class));
        });


        btnGoPlay.setOnClickListener(view->{
            startActivity(new Intent(MainActivity.this, PlayPage.class));
        });
    }

    public void actionBar() {
        try {
            actBar = getSupportActionBar();
            actBar.setDisplayShowHomeEnabled(true);
            actBar.setDisplayUseLogoEnabled(true);
            actBar.setLogo(R.mipmap.ic_launcher_lion);
            actBar.setTitle("MidTerm Application");
        } catch (Exception err) {
            Log.d(TAG, "actionBar: " + err.getMessage());
        }
    }
    public void getItemsInView(){
        try{
            btnGoDog = findViewById(R.id.btnGoToDog);
            btnGoPlay = findViewById(R.id.btnGoToPlay);
        } catch (Exception err) {
            Log.d(TAG, "getItemsInView: Failed to get Items" + err.getMessage());
        }

    }
}