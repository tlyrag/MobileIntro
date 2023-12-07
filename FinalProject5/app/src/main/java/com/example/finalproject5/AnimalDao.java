package com.example.finalproject5;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAnimals(List<Animal> animalList);

    @Query("SELECT * FROM animal")
    List<Animal> getAnimals();

    @Query("SELECT * FROM animal WHERE animalID=:id")
    Animal getAnimalbyId(int id);

    @Query("SELECT * FROM animal WHERE animalName=:name")
    Animal getAnimalByName(String name);
}
