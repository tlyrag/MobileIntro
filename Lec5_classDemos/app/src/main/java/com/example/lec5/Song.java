package com.example.lec5;

public class Song {

    private String songName;
    private int songPic;

    public int getSongRaw() {
        return songRaw;
    }

    public void setSongRaw(int songRaw) {
        this.songRaw = songRaw;
    }

    private int songRaw;

    public Song(String songName, int songPic) {
        this.songName = songName;
        this.songPic = songPic;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Song(String songName, int songPic, int songRaw) {
        this.songName = songName;
        this.songPic = songPic;
        this.songRaw = songRaw;
    }

    public int getSongPic() {
        return songPic;
    }

    public void setSongPic(int songPic) {
        this.songPic = songPic;
    }
}
