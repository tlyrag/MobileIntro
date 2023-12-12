package com.example.finalpractice6;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface favoriteAnimalDao {

    @Query("SELECT * FROM person AS p  INNER JOIN animals as a on p.animalId= a.animalId WHERE p.personName =:personName AND a.animalId=:animalId" )
    public List<favAnimal > getFavoriteData(String personName, String animalId);
}
