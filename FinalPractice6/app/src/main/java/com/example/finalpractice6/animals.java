package com.example.finalpractice6;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animals")
public class animals {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "animalId")
    String id;

    @ColumnInfo(name="animalName")
    String name;
    @ColumnInfo(name = "pathPicture")
    int pathPicture;

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

    public int getPathPicture() {
        return pathPicture;
    }

    public void setPathPicture(int pathPicture) {
        this.pathPicture = pathPicture;
    }

    public animals(@NonNull String id, String name, int pathPicture) {
        this.id = id;
        this.name = name;
        this.pathPicture = pathPicture;
    }

    public animals() {
    }

    @Override
    public String toString() {
        return "animals{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pathPicture='" + pathPicture + '\'' +
                '}';
    }
}
