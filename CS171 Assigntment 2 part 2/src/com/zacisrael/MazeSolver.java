package com.zacisrael;
/*THIS CODE WAS OUR OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN
BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Zac Israel and Terry Floyd II*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MazeSolver {

    static char[][] maze;
    static int startX, startY;
    static int endX, endY;

    public MazeSolver(String filename) throws IOException {
        startX = 0;
        startY = 0;
        readMaze(filename);
    }

    public static void readMaze(String filename) throws IOException {
        Scanner scanner;
        try {
            scanner = new Scanner(new FileInputStream(filename));
        } catch (IOException ex) {
            System.err.println("[ERROR] Invalid filename: " + filename);
            return;
        }

        int N = scanner.nextInt();
        scanner.nextLine();
        maze = new char[N][N];
        endX = N - 1;
        endY = N - 1;
        int i = 0;
        while (i < N && scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            int j = 0;
            for (; j < tokens.length; j++) {
                maze[i][j] = tokens[j].charAt(0);
            }
            if (j != N) {
                System.err.println("[ERROR] Invalid line: " + i + " has wrong # columns: " + j);
                return;
            }
            i++;
        }
        if (i != N) {
            System.err.println("[ERROR] Invalid file: has wrong number of rows: " + i);
            return;
        }
    }

    // Helper method for printing the maze in a matrix format
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public boolean isEndPosition(MazePosition mazePosition) {
        int currentX = mazePosition.getX();
        int currentY = mazePosition.getY();

        if ((currentX == endX) && (currentY == endY)) {
            return true;
            // If the x index of the currentPosition is equal to end x position,
            // and the y index of the currentPosition is equal to the y position,
            // return true
        }
        return false;
        // Otherwise, return false
    }

    public boolean isPositionValid(MazePosition mazePosition) {
        int currentX = mazePosition.getX();
        int currentY = mazePosition.getY();
        if ((currentX >= 0 && currentX < maze.length) && (currentY >= 0 && currentY < maze.length)
                && maze[currentX][currentY] == '0') {
            return true;
            // If the current coordinates of the mazePosition are inside the of the maze,
            // return true
        }
        return false;
        // Otherwise, return false
    }

    public boolean isInStack(MazePosition mazePosition) {
        return maze[mazePosition.getX()][mazePosition.getY()] == 'X';
        // returns true if the current mazePosition has been visited

    }

    public void solveMaze() {
        Stack<MazePosition> stack = new Stack<>();

        MazePosition mazePosition = new MazePosition(0, 0); // starting point of the maze
        stack.push(mazePosition); // adds the starting point of the maze to the stack


        int i = 0; // row tracker
        int j = 0; // column tracker
        MazePosition currentPosition = new MazePosition(i, j);
        MazePosition rightPosition;
        MazePosition upPosition;
        MazePosition downPosition;
        MazePosition leftPosition;

        while (!stack.isEmpty()) { // while the stack is Not empty
            currentPosition = stack.pop(); // removes current position from the stack

            if (isEndPosition(currentPosition)) {
                // if the current position is equal to the exit
                System.out.println("Maze is Solvable");
                printMaze();
                return;
            } else {
                i = currentPosition.getX();
                j = currentPosition.getY();
                rightPosition = new MazePosition(i, j + 1);
                upPosition = new MazePosition(i - 1, j);
                downPosition = new MazePosition(i + 1, j);
                leftPosition = new MazePosition(i, j - 1);
                 if (isPositionValid(rightPosition) && !isInStack(rightPosition)) {
                     // checks if the rightPosition has not been visited and if its a valid position
                     // if that is true, the right position will be pushed to the stack.
                    stack.push(rightPosition);
                    maze[rightPosition.getX()][rightPosition.getY()] = 'X';
                }
                if (isPositionValid(downPosition) && !isInStack(downPosition)) {
                    // checks if the downPosition has not been visited and if its a valid position
                    // if that is true, the downPosition will be pushed to the stack.
                     stack.push(downPosition);
                     maze[downPosition.getX()][downPosition.getY()] = 'X';
                 }
                 if (isPositionValid(upPosition) && !isInStack(upPosition)) {
                     // checks if the upPosition has not been visited and if its a valid position
                     // if that is true, the upPosition will be pushed to the stack.
                    stack.push(upPosition);
                    maze[upPosition.getX()][upPosition.getY()] = 'X';
                }
                if (isPositionValid(leftPosition) && !isInStack(leftPosition)) {
                    // checks if the leftPosition has not been visited and if its a valid position
                    // if that is true, the leftPosition will be pushed to the stack.
                    stack.push(leftPosition);
                    maze[upPosition.getX()][upPosition.getY()] = 'X';
                }
            }


        }
        if (stack.isEmpty()) {
            // If the stack is empty, print out the following message
            System.out.println("Maze is not solvable");
        }


    }

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.err.println("[ERROR] usage: java PathFinder maze_file");
            System.exit(-1);
        }
        String filename = args[0];

        MazeSolver ms = new MazeSolver("maze3.txt");
        System.out.println("[Before Traversal] Maze: ");
        ms.printMaze();
        System.out.println();

        ms.solveMaze();
        System.out.println();
        System.out.println("[After Traversal] Maze: ");
        ms.printMaze();
    }
}
