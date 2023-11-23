package com.example.lec7demo;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements imgRecyclerAdapter.OnItemClickListener{
    List<GalleryImg> imgList = new ArrayList<>();
    int selectedInd;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler_view);

        Button btnShowImage = findViewById(R.id.btnShowImg);
        img = findViewById(R.id.imageViewLarge2);

        addData();

        SharedPreferences preferences = this.getPreferences(Context.MODE_PRIVATE);
        selectedInd = preferences.getInt(getString(R.string.txtImgInd),-1);
        //imgRecyclerAdapter adpt = new imgRecyclerAdapter(imgList);
//        imgRecyclerAdapter adpt = new imgRecyclerAdapter(imgList, new imgRecyclerAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int i) {
//                if(i!=-1) {
//                    img.setImageResource(imgList.get(i).getImgPic());
//                }
//
//            }
//        });
        imgRecyclerAdapter adpt = new imgRecyclerAdapter(imgList,this);

        RecyclerView recyclerView = findViewById(R.id.reciclerViewImages);

        LinearLayoutManager lm = new LinearLayoutManager(this);


        GridLayoutManager gm = new GridLayoutManager(this,2);
        recyclerView.setAdapter(adpt);recyclerView.setLayoutManager(gm);
        //recyclerView.setLayoutManager(lm);

        if(selectedInd!=-1) {
            img.setImageResource(imgList.get(selectedInd).getImgPic());
        } else {
            img.setImageResource(0);
        }



        btnShowImage.setOnClickListener((View view)  -> {
            int index = adpt.getSelectedInd();
            if(index!=-1) {
                img.setImageResource(imgList.get(index).getImgPic());
            }


        });




    }
    private void addData() {
        imgList.add(new GalleryImg(101,"Eagle",R.drawable.eagle));
        imgList.add(new GalleryImg(102,"Elephant",R.drawable.elephant));
        imgList.add(new GalleryImg(103,"Gorilla",R.drawable.gorilla));
        imgList.add(new GalleryImg(104,"Panda",R.drawable.panda));
        imgList.add(new GalleryImg(105,"Panther",R.drawable.panther));
        imgList.add(new GalleryImg(106,"Polar Bear",R.drawable.polar));

    }

    @Override
    public void onItemClick(int i) {
        if(i!=-1) {
                selectedInd=i;
                   img.setImageResource(imgList.get(i).getImgPic());
              }
    }

    @Override
    protected void onPause() {
        SharedPreferences preferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(getString(R.string.txtImgInd),selectedInd);
        editor.apply();
        super.onPause();
    }
}