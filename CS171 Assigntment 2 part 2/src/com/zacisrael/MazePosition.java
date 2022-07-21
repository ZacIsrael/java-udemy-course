package com.zacisrael;
/*THIS CODE WAS OUR OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel and Terry Floyd II*/

public class MazePosition {

    private int x;
    private int y;

    public MazePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
