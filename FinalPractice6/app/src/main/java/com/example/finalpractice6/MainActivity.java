package com.example.finalpractice6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.finalpractice6.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<animals> animalsList = new ArrayList<>();
    List<person> personList = new ArrayList<>();
    String TAG = "Finals";
    DatabaseController dbc;
    zooRecyclerAdapter adpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        dbc = Room.databaseBuilder(getApplicationContext(),DatabaseController.class,"zoo.db").build();
        setContentView(binding.getRoot());
        readFile();
        insertIntoDatabase();
        loadRecyclerView();

        binding.btnnAdd.setOnClickListener(view-> {
            insertStudent();
            Log.d(TAG, "onCreate: " + personList);
        });


    }
    private void readFile() {
        InputStream inputStream = getResources().openRawResource(R.raw.animaldata);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String readerLine;
        try {
            while (!((readerLine=reader.readLine())!=null)) {
                String[] animalLine = readerLine.split(",");
                String animalId = animalLine[0];
                String animalName = animalLine[1];
                int animalPath = getResources().getIdentifier(animalLine[2],"drawable",getPackageName());

                animals currAnimal = new animals(animalId,animalName,animalPath);

                animalsList.add(currAnimal);

            }
        } catch (Exception err) {
            Log.d(TAG, "readFile: "+ err.getMessage());
        }
    }
    public void insertIntoDatabase () {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            dbc.AnimalDao().inserAnimal(animalsList);
        });
    }
    public void loadRecyclerView() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> {

            personList=dbc.PersonDao().getAllPersons();
            runOnUiThread(() -> {
                adpt = new zooRecyclerAdapter(personList,(i) ->{
                    Toast.makeText(this, personList.get(i)+"", Toast.LENGTH_SHORT).show();
                });
                binding.recyclerView.setAdapter(adpt);
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
            });
        });


    }
    public void insertStudent() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> {

            String personName = binding.editTextName.getText().toString();
            String animalName = binding.spinnerAnimals.getSelectedItem().toString();
            person newPerson = new person(personName,animalName);
            dbc.PersonDao().addPerson(newPerson);
            personList = dbc.PersonDao().getAllPersons();


            runOnUiThread(() -> {
                adpt.setPersonList(personList);
            });
        });
    }

}