package com.example.finalpractice6;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class person {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name="personName")
    String name;

    @ColumnInfo(name="animalId")
    String favoriteAnimal;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getFavoriteAnimal() {
        return favoriteAnimal;
    }

    public void setFavoriteAnimal(String favoriteAnimal) {
        this.favoriteAnimal = favoriteAnimal;
    }

    public person(@NonNull String name, String favoriteAnimal) {
        this.name = name;
        this.favoriteAnimal = favoriteAnimal;
    }

    public person() {
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", favoriteAnimal='" + favoriteAnimal + '\'' +
                '}';
    }
}
