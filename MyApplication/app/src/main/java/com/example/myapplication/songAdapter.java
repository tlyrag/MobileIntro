package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class songAdapter extends BaseAdapter {
    List<Song> songList;
    TextView txtSongTitle;
    ImageView imageViewSongImage;
    ImageView imageViewPlayStop;
    int index =-1;

    public void setIndex(int index) {
        try{
            this.index = index;
            notifyDataSetChanged();    
        } catch (Exception err) {
            Log.d(TAG, "setIndex: Error Setting Index");
        }
        
    }

    final String TAG= "APP";

    public songAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Object getItem(int i) {
        return songList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            Log.d(TAG, "GOT HERE");
            if(view==null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_list_view,viewGroup,false);
            }
        } catch (Exception err) {
            Log.d(TAG, "getView: Not Able to inflate " + err.getMessage());
        }

        txtSongTitle = view.findViewById(R.id.textViewSongName);
        getViewItems(view);
        setItems(i);

        return view;
    }

    public void setItems(int i)  {
        try {
            txtSongTitle.setText(songList.get(i).getSongTitle());
            imageViewSongImage.setImageResource(songList.get(i).getSongImg());

            if(this.index==i) {
                imageViewPlayStop.setImageResource(R.drawable.stop);
            } else  {
                imageViewPlayStop.setImageResource(R.drawable.play);
            }

        } catch (Exception err) {
            Log.d(TAG, "setItems: Failed to set Items " + err.getMessage());
        }
    }
    public void getViewItems(View view) {
        try {
            txtSongTitle = view.findViewById(R.id.textViewSongName);
            imageViewSongImage = view.findViewById(R.id.imageViewSongImg);
            imageViewPlayStop = view.findViewById(R.id.imageViewSongPlayStop);


        }catch (Exception err) {
            Log.d(TAG, "getViewItems: Error getting items " + err.getMessage());
        }
    }
}

