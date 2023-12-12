package com.example.finalpractice6;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface personDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addPerson(person Person);

    @Query("SELECT * FROM person WHERE personName=:personName")
    public person getPersonByID(String personName);
    @Query("SELECT * FROM person")
    public List<person> getAllPersons();

}
