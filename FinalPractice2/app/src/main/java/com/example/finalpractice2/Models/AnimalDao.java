package com.example.finalpractice2.Models;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Long[] insertAnimals(List<Animals> Animal);
    @Query("Select * From animals")
    List<Animals> getAllAnimals();

    @Query("Select * From animals where animals.AnimalId =:id")
    Animals getAnimalById(String id);

}
