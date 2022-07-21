package com.zacisrael;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {
	// write your code here



        Album album = new Album("Lost in My Head", "Jackboy");
        album.addSong("No Cap", 2.38);
        album.addSong("City Boy", 2.21);
        album.addSong("In the Uber with a Ruger", 3.2);
        album.addSong("Live and Learn", 2.42);

        albums.add(album);

        Album album2 = new Album("Pain and Pressure", "Dta Duffway & APA Rozay");
        album2.addSong("24 Hrs", 2.02);
        album2.addSong("Blow Something", 1.53);
        album2.addSong("Crimes", 2.24);
        album2.addSong("No Safety", 3.05);
        albums.add(album2);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("In the Uber with a Ruger", playList);
        albums.get(1).addToPlayList("Crimes", playList);




    }
    
}
