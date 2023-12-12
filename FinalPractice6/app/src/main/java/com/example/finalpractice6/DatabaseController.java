package com.example.finalpractice6;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {animals.class,person.class},version = 1,exportSchema = false)
public abstract class DatabaseController  extends RoomDatabase {
    public abstract animalDao AnimalDao();
    public abstract personDao PersonDao();

}
