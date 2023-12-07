package com.example.finalproject5;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPersonList(List<Person> personList);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPerson(Person person);

    @Query("SELECT * FROM person")
    List<Person> getAllPersons();

}
