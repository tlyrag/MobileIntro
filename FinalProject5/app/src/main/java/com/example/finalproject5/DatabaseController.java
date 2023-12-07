package com.example.finalproject5;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;
@Database(entities = {Animal.class, Person.class},version = 1,exportSchema = false)
public abstract class DatabaseController extends  RoomDatabase{
    public abstract AnimalDao  animalDao();
    public abstract PersonDao personDao();

}
