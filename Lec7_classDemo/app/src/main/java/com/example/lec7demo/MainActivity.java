package com.example.lec7demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<GalleryImg> imgList = new ArrayList<>();
    Toast currentToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        ImageView imgViewLarge = findViewById(R.id.imgViewLarge);
        GridView grdview = findViewById(R.id.gridViewImages);
        imgAdapter adpt = new imgAdapter(imgList);
        grdview.setAdapter(adpt);
        grdview.setNumColumns(3);
        grdview.setVerticalSpacing(8);
        grdview.setHorizontalSpacing(8);

        grdview.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l)  -> {
            imgViewLarge.setImageResource(imgList.get(i).getImgPic());

            //
            if(currentToast!=null) {
                currentToast.cancel();
            }
            currentToast =  Toast.makeText(MainActivity.this,"Clicked on :" + imgList.get(i).getImgName(),Toast.LENGTH_LONG);
            currentToast.show();

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

}