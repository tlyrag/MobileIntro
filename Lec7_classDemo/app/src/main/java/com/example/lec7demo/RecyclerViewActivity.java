package com.example.lec7demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    List<GalleryImg> imgList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler_view);
        addData();
        imgRecyclerAdapter adpt = new imgRecyclerAdapter(imgList);
        RecyclerView recyclerView = findViewById(R.id.reciclerViewImages);


        GridLayoutManager gm = new GridLayoutManager(this,2);
        recyclerView.setAdapter(adpt);
        recyclerView.setLayoutManager(gm);


    }
    private void addData() {
        imgList.add(new GalleryImg(101,"Eagle",R.drawable.eagle));
        imgList.add(new GalleryImg(102,"Elephant",R.drawable.elephant));
        imgList.add(new GalleryImg(103,"Gorilla",R.drawable.gorilla));
        imgList.add(new GalleryImg(104,"Panda",R.drawable.panda));
        imgList.add(new GalleryImg(105,"Panther",R.drawable.panther));
        imgList.add(new GalleryImg(106,"Polar Bear",R.drawable.polar));

    }
}