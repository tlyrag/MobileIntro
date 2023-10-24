package com.example.lec7demo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class imgAdapter extends BaseAdapter {
    List<GalleryImg> adapterGalleryImages;

    public imgAdapter(List<GalleryImg> adapterGalleryImages) {
        this.adapterGalleryImages = adapterGalleryImages;
    }

    @Override
    public int getCount() {
        return this.adapterGalleryImages.size();
    }

    @Override
    public Object getItem(int i) {
        return this.adapterGalleryImages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.adapterGalleryImages.get(i).getImgId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            ImageView imgViewItem = new ImageView(viewGroup.getContext());
            imgViewItem.setLayoutParams(new ViewGroup.LayoutParams(GridView.AUTO_FIT,120));
            imgViewItem.setImageResource(this.adapterGalleryImages.get(i).getImgPic());
            imgViewItem.setBackgroundColor(Color.LTGRAY);
            view = imgViewItem;
        }


        return view;
    }
}
