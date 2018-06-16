package com.jlsegb.sentinel;

import org.json.JSONObject;

import java.util.ArrayList;

public class DB {

    private ArrayList<String> sponsors;
    private ArrayList<String> addicts;

    // Accessors and Mutators
    public ArrayList<String> getSponsors() {
        return sponsors;
    }

    public void setSponsors(ArrayList<String> sponsors) {
        this.sponsors = sponsors;
    }

    public ArrayList<String> getAddicts() {
        return addicts;
    }

    public void setAddicts(ArrayList<String> addicts) {
        this.addicts = addicts;
    }

    public void addSponsor(String id, JSONObject json) {

    }

    public void addAddict(String id, JSONObject json) {

    }

    public void remove(String id) {

    }

}
