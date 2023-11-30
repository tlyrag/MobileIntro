package com.example.finalpractice2.Views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import com.example.finalpractice2.Adapters.AnimalAdapter;
import com.example.finalpractice2.Database.DatabaseController;
import com.example.finalpractice2.Models.Animals;
import com.example.finalpractice2.R;
import com.example.finalpractice2.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity implements AnimalAdapter.OnItemClickListener{
    List<Animals> animalsList= new ArrayList<>();
    String TAG = "Animal";
    DatabaseController dbc;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbc = Room.databaseBuilder(getApplicationContext(),DatabaseController.class,"animal.db").build();
        readFile();
        insertAnimalstoDB();
        createAnimalRecycler();



    }
    public void createAnimalRecycler() {
        try{
        binding.RecyclerViewAnimal.setAdapter( new AnimalAdapter(animalsList,this));
        binding.RecyclerViewAnimal.setLayoutManager(new LinearLayoutManager(this));
        }
        catch (Exception ex){
            Log.d(TAG, "createAnimalRecycler: " + ex.getMessage());
        }
    }
    public void insertAnimalstoDB() {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();

            executorService.execute(()->{
                dbc.animalDao().insertAnimals(animalsList);
                Animals randomAnimal;
                int randomNum = (int) (Math.random() *animalsList.size());
                String randomAnimalID = animalsList.get(randomNum).getId();
                randomAnimal = dbc.animalDao().getAnimalById(randomAnimalID);
                runOnUiThread(() -> {

                    binding.imgViewLarge.setImageResource(randomAnimal.getAnimalPicture());
                });
            });
        } catch (Exception ex) {
            Log.d(TAG, "insertAnimalstoDB: " + ex.getMessage());
        }

    }
    public void readFile() {
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.animals);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String header;

            if((header=reader.readLine())!=null) {

            }
            String animalLine;
            while ((animalLine=reader.readLine())!=null){
                String[] eachLine = animalLine.split(",");

                String AnimalID =eachLine[0];
                int Animalpic =getResources().getIdentifier(eachLine[1],"drawable",getPackageName());
                String AnimalName=eachLine[2];
                String AnimalStringDate =eachLine[3];
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
//                LocalDate AnimalDobDate = LocalDate.parse(AnimalStringDate,formatter);
                Double AnimalPrice = Double.parseDouble(eachLine[4]);

                Animals newAnimal = new Animals(AnimalID,Animalpic,AnimalName,AnimalStringDate,AnimalPrice);
                animalsList.add(newAnimal);


            }
            Log.d(TAG, "readFile: " + animalsList);
        } catch (Exception ex) {
            Log.d(TAG, "readFile: " + ex.getMessage());
        }

    }

    @Override
    public void onItemClick(int i) {
        Intent newIntent = new Intent(this,NextActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("animalId",animalsList.get(i).getId());
        newIntent.putExtras(bundle);
        startActivity(newIntent);
        Toast.makeText(this, animalsList.get(i) + "", Toast.LENGTH_SHORT).show();
    }
}