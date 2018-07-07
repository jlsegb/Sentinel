package com.jlsegb.sentinel;

public class Profile {

    private String tag; // "sponsor" or "addict"
    private String name;
    private String city;
    private String addictions;
    private String preferredCommunication;
    private String meetingFrequency;
    private String bio;
    // picture?

// Accessors and Mutators
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddictions() {
        return addictions;
    }

    public void setAddictions(String addictions) {
        this.addictions = addictions;
    }

    public String getPreferedCommunication() {
        return preferredCommunication;
    }

    public void setPreferedCommunication(String preferedCommunication) {
        this.preferredCommunication = preferedCommunication;
    }

    public String getMeetingFrequency() {
        return meetingFrequency;
    }

    public void setMeetingFrequency(String meetingFrequency) {
        this.meetingFrequency = meetingFrequency;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
