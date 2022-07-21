package com.zacisrael;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artists;
    private ArrayList<Song> songs;

    public Album(String name, String artists) {
        this.name = name;
        this.artists = artists;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public Song findSong(String title){
        for (Song s: songs) {
            if(s.getTitle().equals(title)){
                return s;
            }
        }
        return null;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
       int index = trackNumber -1;
       if((index >= 0) && (index <= this.songs.size())){
           playList.add(this.songs.get(index));
           return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
       return false;
    }
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song s = findSong(title);
        if(s != null){
            playList.add(s);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}
