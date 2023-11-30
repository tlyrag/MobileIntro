package com.example.finalpractice2.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.util.Date;
@Entity(tableName = "animals")

public class Animals {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name="AnimalId")
    String id;
    @ColumnInfo(name ="AnimalPicRef")
    int animalPicture;
    @ColumnInfo(name="AnimalName")
    String name;
    @ColumnInfo(name = "DoB")
    String dob;
    @ColumnInfo(name="AnimalPrice")
    Double price;


    public Animals(@NonNull String id, int animalPicture, String name, String dob, Double price) {
        this.id = id;
        this.animalPicture = animalPicture;
        this.name = name;
        this.dob = dob;
        this.price = price;
    }

    public Animals() {
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public int getAnimalPicture() {
        return animalPicture;
    }

    public void setAnimalPicture(int animalPicture) {
        this.animalPicture = animalPicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                '}';
    }
}
