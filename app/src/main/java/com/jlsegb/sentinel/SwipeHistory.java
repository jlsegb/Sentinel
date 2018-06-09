package com.jlsegb.sentinel;

import java.util.ArrayList;

public class SwipeHistory {

    private ArrayList<String> allSwipes;
    private ArrayList<String> desiredMatches;
    private ArrayList<String> matches;

// Accessors
    public ArrayList<String> getAllSwipes() {
        return allSwipes;
    }

    public ArrayList<String> getDesiredMatches() {
        return desiredMatches;
    }

    public ArrayList<String> getMatches() {
        return matches;
    }

// Add
    public void add(String id, boolean isDesiredMatch) {

        allSwipes.add(id);
        if (isDesiredMatch) {
            desiredMatches.add(id);
            // check if match
        }

    }

}
