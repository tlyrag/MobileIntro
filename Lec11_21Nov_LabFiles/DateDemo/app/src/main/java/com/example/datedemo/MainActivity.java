package com.example.datedemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.datedemo.databinding.ActivityMainBinding;

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
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ReadDogData();

        setAdapterWithClick();
        //setAdapterInfo();

        Log.d(TAG, "onCreate: Testing DogData" + DogList.get(0));

    }
    public  void setAdapterWithClick() {
        DogAdapter dogAdapter = new DogAdapter(DogList, new DogAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                binding.txtViewAdoptionSumary.setText("Thank you for taking" + DogList.get(i).getDogName() + "To their forever home");
            }
        });
        binding.recyclerViewDogItems.setAdapter(dogAdapter);
        binding.recyclerViewDogItems.setLayoutManager(new LinearLayoutManager(this));
    }
    public void setAdapterInfo() {
        DogAdapter dogAdapter = new DogAdapter(DogList);
        binding.recyclerViewDogItems.setAdapter(dogAdapter);
        binding.recyclerViewDogItems.setLayoutManager(new LinearLayoutManager(this));
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
                //MM - 2 digit number
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