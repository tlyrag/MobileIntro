package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements ImageRecyclerViewAdapter.OnItemClickListener {
    List<GalleryImage> ImageList = new ArrayList<>();
    ImageView imgViewLarge2;

    int SelectedInd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        AddData();

        SharedPreferences preferences
                = this.getPreferences(Context.MODE_PRIVATE);
        SelectedInd = preferences.getInt(getString(R.string.txtImgInd),-1);

        RecyclerView recyclerViewImages = findViewById(R.id.recyclerViewImages);
        imgViewLarge2 = findViewById(R.id.imgViewLarge2);

        if (SelectedInd != -1) {
            imgViewLarge2
                    .setImageResource(ImageList.get(SelectedInd).getImgPic());
        } else {
            imgViewLarge2.setImageResource(0);
        }

       // ImageRecyclerViewAdapter myAdapter
       //         = new ImageRecyclerViewAdapter(ImageList);

       /* ImageRecyclerViewAdapter myAdapter
                = new ImageRecyclerViewAdapter(ImageList,
                new ImageRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                SelectedInd = i;
                if (i != -1)
                    imgViewLarge2
                            .setImageResource(ImageList.get(i).getImgPic());
            }
        });*/

        ImageRecyclerViewAdapter myAdapter
                = new ImageRecyclerViewAdapter(ImageList,this);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        GridLayoutManager gm = new GridLayoutManager(this,2);
        recyclerViewImages.setAdapter(myAdapter);
        recyclerViewImages.setLayoutManager(gm);
        //recyclerViewImages.setLayoutManager(lm);

        Button btnShowImage = findViewById(R.id.btnShowImage);
        btnShowImage.setOnClickListener((View view) -> {
            int selInd = myAdapter.getSelectedInd();
            if (selInd != -1) {
                imgViewLarge2.setImageResource(
                        ImageList.get(selInd).getImgPic());
            } else {
                imgViewLarge2.setImageResource(0);
            }
        });



    }
    private void AddData(){
        ImageList.add(
                new GalleryImage(101,"Eagle",R.drawable.eagle));
        ImageList.add(
                new GalleryImage(102,"Elephant",R.drawable.elephant));
        ImageList.add(
                new GalleryImage(103,"Gorilla",R.drawable.gorilla));
        ImageList.add(
                new GalleryImage(104,"Panda",R.drawable.panda));
        ImageList.add(
                new GalleryImage(105,"Panther",R.drawable.panther));
        ImageList.add(
                new GalleryImage(106,"Polar Bear",R.drawable.polar));

    }

    @Override
    public void onItemClick(int i) {
        if (i != -1) {
            SelectedInd = i;
            imgViewLarge2
                    .setImageResource(ImageList.get(i).getImgPic());
        }
    }

    @Override
    protected void onPause() {
        SharedPreferences preferences
                = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getString(R.string.txtImgInd),SelectedInd); //add as many key value pairs as needed
        editor.apply();
        super.onPause();
    }
}