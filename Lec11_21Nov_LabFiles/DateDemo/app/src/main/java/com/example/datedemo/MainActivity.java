package com.example.datedemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    /// Read File from CSV
    /// Using View Binding
    /// RecyclerView - Adapter
    /// Database
    List<Dog> DogList = new ArrayList<>();
    String TAG = "DOGDemo";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReadDogData();
        Log.d(TAG, "onCreate: Testing DogData" + DogList.get(0));
    }


    public void ReadDogData() {
        InputStream inputStream = getResources().openRawResource(R.raw.doginfo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String csvLine;
            //headerLine

            while  ((csvLine=reader.readLine())!=null) {
                String[] eachDogFields = csvLine.split(",");

                int dogId = Integer.parseInt(eachDogFields[0]);
                int dogDrawable = getResources().getIdentifier(eachDogFields[1],"drawable",getPackageName());
                String dogBreed = eachDogFields[2];
                String dogName = eachDogFields[3];
                String dogDobSTR = eachDogFields[4];

                //Parse dogDobStr into LocaleDate
                //d - date fields, or or more digits (e.g. 8,18,31)
                //MMM - three letter code for the mont(e.g JAN,MAY,JUN)
                //yyyy- 4 digit year (e.g., 01,11,10,12)

                //dd - two digit dates(e.g., 01,08,31,18)
                //mm - 2 digit number
                //yy two digit year

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

                LocalDate dob = LocalDate.parse(dogDobSTR,formatter);

                Dog eachDog = new Dog(dogId,dogName,dogBreed,dogDrawable,dob);
                DogList.add(eachDog);

            }

        } catch (Exception err) {
            Log.d(TAG, "ReadDogData: " + err.getMessage());
        }

    }
}