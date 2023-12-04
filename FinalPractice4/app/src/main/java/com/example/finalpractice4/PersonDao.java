package com.example.finalpractice4;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void insertPerson(List<Person> personList);
    @Query("SELECT * FROM person WHERE id=:id")
    Person getPerson(int id);

    @Query("UPDATE person SET name =:newName where name=:oldName")
    int updatePersonName(String oldName ,String newName);
}
