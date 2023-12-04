package com.example.finalpractice4;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class},version = 1,exportSchema = false)

public abstract class DatabaseController extends RoomDatabase {
    public abstract PersonDao personDao();
}
