package com.example.finalpractice4;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name="id")
    String id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "dob")
    String dob;
    @ColumnInfo(name = "favAnimal")
    String favAnimal;
    @ColumnInfo(name = "animalPic")
    int animalPic;

    public Person(@NonNull String id, String name, String dob, String favAnimal, int animalPic) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.favAnimal = favAnimal;
        this.animalPic = animalPic;
    }

    public Person() {
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
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

    public String getFavAnimal() {
        return favAnimal;
    }

    public void setFavAnimal(String favAnimal) {
        this.favAnimal = favAnimal;
    }

    public int getAnimalPic() {
        return animalPic;
    }

    public void setAnimalPic(int animalPic) {
        this.animalPic = animalPic;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", favAnimal='" + favAnimal + '\'' +
                ", animalPic=" + animalPic +
                '}';
    }
}
