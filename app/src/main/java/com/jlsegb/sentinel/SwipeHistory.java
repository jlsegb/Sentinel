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
    public void addDesirable(String id) {
        allSwipes.add(id);
        desiredMatches.add(id);
        if (isMatch(id)) {
            matches.add(id);
            // Also needs to add themselves to the other person's list of matches
            // Also needs to reveal other persons contact info
            // Also needs to allow other person to see their contact info
        }
    }
    public void addUndesirable(String id) {
        allSwipes.add(id);
    }

// Matching Logic
    public boolean isMatch(String id) {
        return false; // do something
    }
}
