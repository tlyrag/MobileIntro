package com.example.finalproject5;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "personId")
    String  personId;

    @ColumnInfo(name="personName")
    String personName;
    @ColumnInfo(name = "personDob")
    String personDob;

    @ColumnInfo(name="favoriteAnimal")
    String animalId;

    public Person(@NonNull String personId, String personName, String personDob, String animalId) {
        this.personId = personId;
        this.personName = personName;
        this.personDob = personDob;
        this.animalId = animalId;
    }

    public Person() {
    }

    @NonNull
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(@NonNull String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonDob() {
        return personDob;
    }

    public void setPersonDob(String personDob) {
        this.personDob = personDob;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }
}
