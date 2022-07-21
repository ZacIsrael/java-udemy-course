package com.zacisrael;

public class Song {

    private String title;
    private double durationInSec;

    public Song(String title, double durationInSec) {
        this.title = title;
        this.durationInSec = durationInSec;
    }

    public String getTitle() {
        return title;
    }

    public double getDurationInSec() {
        return durationInSec;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.durationInSec;
    }
}
