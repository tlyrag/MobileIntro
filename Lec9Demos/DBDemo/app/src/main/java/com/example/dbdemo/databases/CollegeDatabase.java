package com.example.dbdemo.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.dbdemo.interfaces.StudentDao;
import com.example.dbdemo.model.Student;
@Database(entities = {Student.class}, version = 1, exportSchema = false)

public abstract class CollegeDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();


}
