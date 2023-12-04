package com.example.finalpractice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.finalpractice4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String name;
    String dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setPreferences();


    }

    @Override
    protected void onPause() {

        SharedPreferences preferences= this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        name = binding.editTextName.getText().toString();
        dob = binding.editTextDob.getText().toString();
        editor.putString(getString(R.string.txtCacheName),name);
        editor.putString(getString(R.string.txtCacheDob),dob);
        editor.apply();
        super.onPause();
    }

    public void setPreferences() {
        SharedPreferences preferences = this.getPreferences(Context.MODE_PRIVATE);
        name = preferences.getString(getString(R.string.txtCacheName),"");
        dob = preferences.getString(getString(R.string.txtCacheDob),"");
        binding.editTextDob.setText(dob);
        binding.editTextName.setText(name);
    }
}