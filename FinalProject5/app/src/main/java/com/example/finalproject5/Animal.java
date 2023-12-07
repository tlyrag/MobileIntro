package com.example.finalproject5;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animal")
public class Animal {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name ="animalID")
    String animalId;

    @ColumnInfo(name = "animalName")
    String animalName;

    @ColumnInfo(name="animalPicture")
    int animalPicture;



    public Animal(String animalId, String animalName, int animalPicture) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalPicture = animalPicture;
    }

    public Animal() {}

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalPicture() {
        return animalPicture;
    }

    public void setAnimalPicture(int animalPicture) {
        this.animalPicture = animalPicture;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId='" + animalId + '\'' +
                ", animalName='" + animalName + '\'' +
                ", animalPicture=" + animalPicture +
                '}';
    }


}
