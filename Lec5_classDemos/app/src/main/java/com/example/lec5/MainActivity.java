package com.example.lec5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> SongNames = new ArrayList<>(Arrays.asList("BagPipes","Ukelele","Drums"));
    List<Integer> SongPics = new ArrayList<>(Arrays.asList(R.drawable.bagpipes,R.drawable.ukulele,R.drawable.drums));
    List<Song> SongList = new ArrayList<>();
    List<Integer> SongRaws = new ArrayList<>(Arrays.asList(R.raw.bagpipes,R.raw.ukulele,R.raw.drums));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadMOdelData();
        ListView listViewSongs = findViewById(R.id.listViewSongs);
        SongAdapter myAdapter = new SongAdapter(SongList);
        listViewSongs.setAdapter(myAdapter);

    }
    private void LoadMOdelData() {
        for(int i=0; i<SongNames.size();i++) {
            Song eachSong  = new Song(SongNames.get(i),SongPics.get(i),SongRaws.get(i));
            SongList.add(eachSong);
        }
    }
}