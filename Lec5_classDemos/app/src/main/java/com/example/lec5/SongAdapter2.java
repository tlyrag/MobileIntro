package com.example.lec5;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter2 extends BaseAdapter {
    List<Song> songsList2;
    int SelectedInd =-1;

    public SongAdapter2(List<Song> songsList2, int selectedInd) {
        this.songsList2 = songsList2;
        SelectedInd = selectedInd;
    }

    public List<Song> getSongsList2() {
        return songsList2;
    }

    public void setSongsList2(List<Song> songsList2) {
        this.songsList2 = songsList2;
        notifyDataSetChanged();// Recall getViews to repopulate the view
    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {
        SelectedInd = selectedInd;
        notifyDataSetChanged();// Recall getViews to repopulate the view
    }

    public SongAdapter2(List<Song> songsList2) {
        this.songsList2 = songsList2;
    }

    @Override
    public int getCount() {
        return this.songsList2.size();
    }

    @Override
    public Object getItem(int i) {
        return this.songsList2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    /** @author = Thiago
     * Inflate the view if the view is null
     * get the Items from the layout
     * Set the layout and return view
     *
     * */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {
            view= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_song2,viewGroup,false);
        }

        TextView txtViewSong = view.findViewById(R.id.textViewSongItem2);
        ImageView imgViewSong2 = view.findViewById(R.id.imageViewSongItem2);
        ImageView imgViewPlayStop = view.findViewById(R.id.imageViewPlayStop);


        txtViewSong.setText(this.songsList2.get(i).getSongName());
        imgViewSong2.setImageResource(this.songsList2.get(i).getSongPic());

        /**
         * Changing the image if the selected item is selected in the view
         * */
        if(i== SelectedInd) {
            imgViewPlayStop.setImageResource(R.drawable.stop);
        } else {
            imgViewPlayStop.setImageResource(R.drawable.play);
        }


        return view;
    }
}
