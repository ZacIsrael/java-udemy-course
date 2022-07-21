package com.zacisrael;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    // Buffered Reader reads text from the input stream and buffers the characters into a character array.

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        // main method will now throw the IOException


//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
//
//            }
//
//        } finally {
//            System.out.println("in finally block");
//            if (locFile != null) {
//                System.out.println("Attempting to close locfile");
//                locFile.close();
//            }
//
//        }

        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")){
            for (Location location: locations.values()) {
                locFile.write(location.getLocationID() + ", " + location.getDescription());
                for(String direction : location.getExits().keySet()){
                    dirFile.write(location.getLocationID() + ", " + direction + ", " + location.getExits().get(direction) );
                }
            }
            // The exception from the try block will be thrown back up the stack
        }

    }

    static {
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(","); // tells scanner our info is separated by commas
            while(scanner.hasNextLine()){
                int loc = scanner.nextInt(); // location ID
                scanner.skip(scanner.delimiter()); // skips over the comma to get the location description
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally {
            if(scanner != null) scanner.close();
        }

        // Now reading the exits

        try{
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String direction = scanner.next();
                scanner.skip(scanner.delimiter());
                String dest = scanner.nextLine();
                int destination = Integer.parseInt(dest);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }
//        Map<String, Integer> tempExit = new HashMap<>();
//        locations.put(0, new Location(0, "You are sitting in front of your computer" +
//                " learning Java.", null));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
       // locations.put(1, new Location(1, "You are standing at the end of a road before a " +
//                "small brick building", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside of a building, a well house for" +
//                " a small spring trip", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//        tempExit = new HashMap<>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest", tempExit));

    }

    // You cannot ignore checked Exceptions


    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

}
