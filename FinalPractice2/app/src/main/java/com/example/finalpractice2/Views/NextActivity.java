package com.example.finalpractice2.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.finalpractice2.Database.DatabaseController;
import com.example.finalpractice2.Models.Animals;
import com.example.finalpractice2.R;
import com.example.finalpractice2.databinding.ActivityNextBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NextActivity extends AppCompatActivity {
    ActivityNextBinding nextBinding;
    DatabaseController dbc;
    //Animals currentAnimal;
    String animalId;
    final String TAG = "Animal";
    Animals currentAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nextBinding = ActivityNextBinding.inflate(getLayoutInflater());
        setContentView(nextBinding.getRoot());
        dbc = Room.databaseBuilder(getApplicationContext(),DatabaseController.class,"animal.db").build();
        getBundleItems();
        getAnimalFromDb();

    }

    public void getBundleItems() {
        Bundle bundle = getIntent().getExtras();
        animalId = bundle.getString("animalId");

    }
    public void getAnimalFromDb() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            currentAnimal = dbc.animalDao().getAnimalById(animalId);
            Log.d(TAG, "getAnimalFromDb: " + "animalId is: " + animalId + "Current Animal is" + currentAnimal);

            runOnUiThread(() -> {
                Log.d(TAG, "getAnimalFromDb UI Thread: " + "animalId is: " + animalId + "Current Animal is" + currentAnimal);
                nextBinding.imageViewAnimal.setImageResource(currentAnimal.getAnimalPicture());
                nextBinding.textViewName.setText(currentAnimal.getName());
                nextBinding.textViewDob.setText(currentAnimal.getDob());

                nextBinding.textViewPrice.setText(String.format("$%.2f",currentAnimal.getPrice()));
            });
        });


    }

}