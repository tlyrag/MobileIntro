package com.example.finalpractice6;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;


public class favAnimal {
    @NonNull
    @ColumnInfo(name = "personName")
    String personName;
    @ColumnInfo(name ="animalName")
    String animalName;
    @ColumnInfo(name = "picture path")
    int animalPic;

}
