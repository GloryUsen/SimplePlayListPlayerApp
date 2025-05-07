package com.glory;

import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Songs> song;

    public Album(String name, String artist, ArrayList<Songs> songs) {
        this.name = name;
        this.artist = artist;
        this.song = songs;
    }

    public Album(){

    }

    public boolean addSong(String title, double duration){
        if (findSong(title) == null){
            song.add(new Songs(title, duration));
            System.out.println(title + "successfully added to the list");
            return true;
        }
        else {
            System.out.println("Songs with name" + title + "already exist in the list");
            return false;
        }
    }
}


