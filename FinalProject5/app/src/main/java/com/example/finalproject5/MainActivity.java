package com.example.finalproject5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.finalproject5.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.onItemClickListner{
    List<Animal> animalList = new ArrayList<>();
    String TAG = "finals";
    DatabaseController db;
    ActivityMainBinding binding;
    List<Person> personList = new ArrayList<>();
    RecyclerViewAdapter adpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        readData();
        db = Room.databaseBuilder(getApplicationContext(),DatabaseController.class,"finals.db").build();
        insertAnimals();
        getPersonData();
        //setRecyclerView();
        binding.btnnAdd.setOnClickListener(view -> {
            insertPerson();
        });

    }
    public void setRecyclerView () {
        try {
            adpt = new RecyclerViewAdapter(personList,this);
            binding.recyclerView.setAdapter(adpt);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } catch (Exception err) {
            Log.d(TAG, "setRecyclerView: " + err.getMessage());
        }
    }
    public void getPersonData() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> {
            personList = db.personDao().getAllPersons();
            runOnUiThread(() -> {
                setRecyclerView();
            });
        });
    }
    public void insertPerson() {
        String name = binding.editTextName.getText().toString();
        String dob = binding.editTextDob.getText().toString();
        String animalName = binding.spinnerAnimals.getSelectedItem().toString();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            Animal animal  =  db.animalDao().getAnimalByName(animalName);
            int randomId = (int)(Math.random() *999);
            Person newPerson = new Person(Integer.toString(randomId),name,dob,animal.animalId);

           db.personDao().insertPerson(newPerson);

           personList = db.personDao().getAllPersons();

           runOnUiThread(() -> {
               binding.editTextName.setText(" ");
               binding.editTextDob.setText(" ");
               Toast.makeText(this, newPerson.getPersonName() + " Added to Databases", Toast.LENGTH_SHORT).show();
                adpt.setPersonList(personList);
           });

        });

    }

    public void insertAnimals()  {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute( () -> {

                db.animalDao().insertAnimals(animalList);
            });

        } catch (Exception err) {
            Log.d(TAG, "insertAnimals: " + err.getMessage());
        }
    }
    public void readData() {
        InputStream input = getResources().openRawResource(R.raw.animaldata);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String animalLine;

            try {
                animalLine=reader.readLine();
                while(animalLine!=null) {

                    String[] animalArr = animalLine.split(",");
                    String id =animalArr[0];
                    String animalName = animalArr[1];
                    String animalPath = animalArr[2].split("\\.")[2];
                    int animalPicPath = getResources().getIdentifier(animalPath,"drawable",getPackageName());

                    Animal newAnimal = new Animal(id,animalName,animalPicPath);
                    animalList.add(newAnimal);
                    animalLine= reader.readLine();

                };
            } catch (IOException e) {
                Log.d(TAG, "readData: "+ e.getMessage());
                throw new RuntimeException(e);
            }



    }

    @Override
    public void onItemClick(int i) {

    }
}