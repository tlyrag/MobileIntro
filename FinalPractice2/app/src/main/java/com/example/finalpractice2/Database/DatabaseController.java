package com.example.finalpractice2.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.finalpractice2.Models.AnimalDao;
import com.example.finalpractice2.Models.Animals;

@Database(entities = {Animals.class},version = 1,exportSchema = false)
public abstract class  DatabaseController extends RoomDatabase {
    public abstract AnimalDao animalDao();

}
