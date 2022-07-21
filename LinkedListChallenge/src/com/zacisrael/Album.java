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

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean addSong(String title, double duration) {

        if(findSong(title) == null){ // If we cannot find the song in the List, add the song to the list and return true
            this.songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }
    public Song findSong(String title){
        for(Song checkedSong: this.songs){
            //Iterating through each entry in the songs arrayList
            if(checkedSong.getTitle().equals(title)){
                // If the checkedSong variable is equal to the current iteration of the songs ArrayList,
                // return that title.
                return checkedSong;
            }
        }
        return null;

    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1; // trackNumbers start from 1, but java starts from 0
        if((index>=0) && (index <= this.songs.size())){
            // if the index is greater than 0 && the index is less than or equal to the size of the songs List,
            //then add the song to the playList and return true;
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

}
