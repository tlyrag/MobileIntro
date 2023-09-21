package com.example.practicinglab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import kotlin.jvm.Throws;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =  "App Error";
    static int selectedConcertId = 0;
     static double finalPrice =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner concertSpinner = findViewById(R.id.spinnerConcert);
        Button  purchaseBtn = findViewById(R.id.btnPurchase);
        EditText numOfTix = findViewById(R.id.editTextNumTix);

        concertSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedConcertId = i;
                Toast.makeText(MainActivity.this, getConcert() + " Selected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        purchaseBtn.setOnClickListener(view -> {
            int numTix = getNumTix(numOfTix);
            finalPrice =getFinalPrice(numTix);
            Toast.makeText(this, "Total Amount is " + finalPrice, Toast.LENGTH_SHORT).show();
        });
    }

    protected  static String getConcert() {
        String concert = "";


        switch (selectedConcertId) {
            case 0:
                return "Rock Concert";
            case 1:
                return "Jazz Concert";
            case 2:
                return "Blues Concert";
        }

        return concert;
    }

    protected static double getFinalPrice(int numOfTix) {
        double currentPrice =0;

        switch (selectedConcertId) {
            case 0:
                return (currentPrice+10) *numOfTix;
            case 1:
                return (currentPrice+15) * numOfTix;
            case 2:
                return (currentPrice+20) * numOfTix;
        }

        return  currentPrice;
    }
    protected  int getNumTix(EditText text) {
        try {
            String numberOfTixText = text.getText().toString();
            int numberOfTix = Integer.parseInt(numberOfTixText);
            if(numberOfTix<0) {
                String exceptionMessage = "Number of Tickets cannot be lesser than 0";
                Toast.makeText(MainActivity.this, "exceptionMessage", Toast.LENGTH_SHORT).show();
                throw new Exception(exceptionMessage);
            }
            return numberOfTix;
        } catch (Exception err) {
            Log.d(TAG,"Error: " + err.getMessage());
            return 0;
        }
    }
}