package com.timbuchalka;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class Location implements Serializable{

    // Serializable interface. Serializable is a marker interface (has no data member and method).
    // It is used to "mark" Java classes so that the objects of these classes may get a certain capability. ...
    // It must be implemented by the class whose object you want to persist.

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    private long serialVersionUID = 1L;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new LinkedHashMap<String, Integer>(exits);
        } else {
            this.exits = new LinkedHashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits);
    }
    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
