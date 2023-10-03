package com.example.lec5;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongAdapter extends BaseAdapter {

    //data
    List<Song> adapterSongs;

    // constructor

    public SongAdapter(List<Song> adapterSongs) {
        this.adapterSongs = adapterSongs;
    }


    //customize methods
    @Override
    // return the size of the data
    public int getCount() {
        return adapterSongs.size();
    }

    @Override
    public Object getItem(int i) {
        return adapterSongs.get(i);
    }
    // Should return the ID of the item in the database;
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // inflate
        if(view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_song,viewGroup,false);
        }
        // populate
        TextView txtViewSong = view.findViewById(R.id.textViewSong);
        txtViewSong.setText(adapterSongs.get(i).getSongName());

        //Drawable Object creation with the song pic
        Drawable img = ContextCompat.getDrawable(viewGroup.getContext()
                , adapterSongs.get(i).getSongPic());
        // set the bouds of the drawable
        img.setBounds(0,0,80,80);
        // set up compound drawable for textview
        txtViewSong.setCompoundDrawables(img,null,null,null);

        return view;
    }
}
