package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayPage extends AppCompatActivity {
    ActionBar actBar;
    final String TAG = "APP";
    ListView songView;
    List<Song> songList = new ArrayList<>();
    List<String> songListTitle= new ArrayList<>(Arrays.asList("BagPipes","Ukulele","Drums"));
    List<Integer> songListImg= new ArrayList<>(Arrays.asList(R.drawable.bagpipes,R.drawable.ukulele,R.drawable.drums));
    List<Integer> songListSound= new ArrayList<>(Arrays.asList(R.raw.bagpipes,R.raw.ukulele,R.raw.drums));
    MediaPlayer mdia;
    songAdapter adpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_page);
        actionBar();
        getItemsInView();
        createSongList();
        setListView();

        songView.setOnItemClickListener((AdapterView<?> adapterView, View view, int i, long l) ->{
            Log.d(TAG, "onCreate: Here0");

            Log.d(TAG, "onCreate: Here1");
            if(mdia != null && mdia.isPlaying()) {
                mdia.stop();
                Log.d(TAG, "onCreate: Here2");
            }
            if(adpt.index ==i) {
                mdia.stop();
                Log.d(TAG, "onCreate: Here3");
                adpt.setIndex(-1);
            } else {
                Log.d(TAG, "onCreate: Here4");
                adpt.setIndex(i);
                mdia =MediaPlayer.create(PlayPage.this,songList.get(i).getSongMusic());
                mdia.start();
            }

        });
    }

    public void getItemsInView() {
        try {
            songView = findViewById(R.id.listViewSongs);
        } catch (Exception err) {
            Log.d(TAG, "getItemsInView: Failed to get itens in view " + err.getMessage());
        }

    }
    public void setListView() {
        try {
            adpt = new songAdapter(songList);
            songView.setAdapter(adpt);

        } catch (Exception err) {
            Log.d(TAG, "setListView: " + err.getMessage());

        }

    }
    public void createSongList() {
        try{
            for (int i =0; i<songListTitle.size();i++) {
                Song newSong = new Song(songListTitle.get(i),songListImg.get(i),songListSound.get(i));
                songList.add(newSong);
            }
        } catch (Exception err) {
            Log.d(TAG, "createSongList: failed to create songs" + err.getMessage());
        }

    }
    public void actionBar() {
        try {
            actBar = getSupportActionBar();
            actBar.setDisplayShowHomeEnabled(true);
            actBar.setDisplayUseLogoEnabled(true);
            actBar.setLogo(R.mipmap.ic_launcher_lion);
            actBar.setTitle("MidTerm Application");
        } catch (Exception err) {
            Log.d(TAG, "actionBar: " + err.getMessage());
        }
    }
}