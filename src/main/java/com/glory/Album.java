package com.glory;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Songs> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Songs>();
    }

    public Album(){}

    public Songs findSong(String title){
        for (Songs checkSong: songs){
            if (checkSong.getTitle().equals(title))
                return checkSong;
        }
        return null;
    }


    public boolean addSong(String title, double duration){
        if (findSong(title) == null){

            songs.add(new Songs(title,duration));
            System.out.println(title + "successfully added to the list");
            return true;
        }
        else {
            System.out.println("Songs with name" + title + "already exist in the list");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Songs> PlayList){
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;

        }
        System.out.println("This album doesn't have song with trackNumber" + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Songs> PlayList){
        for (Songs checkedSong: this.songs){
            PlayList.add(checkedSong);
            return true;
        }
       // System.out.println(title + "there is no such song in album");
        return false;
    }
}


