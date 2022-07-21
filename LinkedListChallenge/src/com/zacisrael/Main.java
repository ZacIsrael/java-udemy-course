package com.zacisrael;


import java.sql.SQLOutput;
import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {

        Album album = new Album("Rich Shoota ", "Q da fool");
        album.addSong("Average", 3.5);
        album.addSong("Real", 2.3);
        album.addSong("Busters", 3.3);
        album.addSong("Shots Out The Uber", 2.43);
        album.addSong("No Time Out", 2.35);
        albums.add(album);

        album = new Album("Baby on Baby", "DaBaby");
        album.addSong("Suge", 3.15);
        album.addSong("Talking It Out", 2.3);
        album.addSong("Goin Baby", 1.57);
        album.addSong("Pony", 3.3);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Average", playList);
        // Add this song from the album with the index of 0 (The first album)
        albums.get(0).addToPlayList("Real", playList);
        albums.get(1).addToPlayList("Suge", playList);
        albums.get(1).addToPlayList("Life", playList);
        albums.get(0).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(0).addToPlayList(1, playList);
        albums.get(1).addToPlayList(3, playList);

        play(playList);


    }
    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("No songs in playlist");
            return;
        } else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            System.out.println("Now playing: " + listIterator.next().toString());
                        } else{
                            System.out.println("We have reached the end of the playlist");
                            forward = false;
                        }
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous());
                    } else{
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }

                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            // If the iterator is able to go back, then print out this message
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else{
                            System.out.println("We are at the start of the list");
                        }
                    } else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else{
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                            // Automatically moves to the next song
                        } else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                            // moves to the previous song if there is no next song
                        }
                    }
                    break;
            }

        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\n press");
        System.out.println("0 - to quit ");
        System.out.println("1 - to play next song ");
        System.out.println("2 - to play previous song ");
        System.out.println("3 - to replay current song ");
        System.out.println("4 - list songs in the playlist ");
        System.out.println("5 - print available actions ");
        System.out.println("6 - delete current song from playlist");

    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("=================");
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("=================");

    }

}
