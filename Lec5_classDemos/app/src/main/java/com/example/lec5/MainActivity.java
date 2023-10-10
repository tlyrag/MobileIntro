package com.example.lec5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> SongNames = new ArrayList<>(Arrays.asList("BagPipes","Ukelele","Drums"));
    List<Integer> SongPics = new ArrayList<>(Arrays.asList(R.drawable.bagpipes,R.drawable.ukulele,R.drawable.drums));
    List<Song> SongList = new ArrayList<>();
    List<Integer> SongRaws = new ArrayList<>(Arrays.asList(R.raw.bagpipes,R.raw.ukulele,R.raw.drums));

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadMOdelData();
        ListView listViewSongs = findViewById(R.id.listViewSongs);

        /**
         *  Should create an adapter object and pass the list of the songs in constructor
         *  so the listview can update the information based on the list of information
         * */
        //SongAdapter myAdapter = new SongAdapter(SongList);
        SongAdapter2 myAdapter2 = new SongAdapter2(SongList);
        listViewSongs.setAdapter(myAdapter2);

        listViewSongs.setOnItemClickListener(
                (AdapterView<?> adapterView, View view, int i, long l)  -> {

                    // Toast.makeText(MainActivity.this, "Clicked On", Toast.LENGTH_SHORT).show();

                    if(mediaPlayer != null && mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }

                    if(myAdapter2.getSelectedInd()==i) {
                        myAdapter2.setSelectedInd(-1);
                    } else {
                        myAdapter2.setSelectedInd(i);
                        mediaPlayer = MediaPlayer.create(MainActivity.this,SongList.get(i).getSongRaw());
                        mediaPlayer.start();

                        mediaPlayer.setOnCompletionListener((MediaPlayer mediaPlayer) ->{
                            myAdapter2.setSelectedInd(-1);

                        });


                    }
        });


    }
    private void LoadMOdelData() {
        for(int i=0; i<SongNames.size();i++) {
            Song eachSong  = new Song(SongNames.get(i),SongPics.get(i),SongRaws.get(i));
            SongList.add(eachSong);
        }
    }
}