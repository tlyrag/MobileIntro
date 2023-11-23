package com.example.myapplication;

public class Song {
    String songTitle;
    int songImg;
    int SongMusic;

    public Song(String songTitle, int songImg, int songMusic) {
        this.songTitle = songTitle;
        this.songImg = songImg;
        SongMusic = songMusic;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public int getSongImg() {
        return songImg;
    }

    public void setSongImg(int songImg) {
        this.songImg = songImg;
    }

    public int getSongMusic() {
        return SongMusic;
    }

    public void setSongMusic(int songMusic) {
        SongMusic = songMusic;
    }
}
