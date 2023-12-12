package com.example.finalpractice6;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface animalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void inserAnimal(List<animals> animalsList);

    @Query("SELECT * FROM animals WHERE animalId=:animalId")
    public animals getAnimalById(String  animalId);
}
