package com.jlsegb.sentinel;

public class Profile {

    String profileId;
    String name1;
    String location;
    String aboutMe;
    String frequency;

    public Profile () {

    }

    public Profile(String profileId, String name1, String location, String aboutMe, String frequency) {
        this.profileId = profileId;
        this.name1 = name1;
        this.location = location;
        this.aboutMe = aboutMe;
        this.frequency = frequency;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getName1() {
        return name1;
    }

    public String getLocation() {
        return location;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getFrequency() {
        return frequency;
    }

    /*
    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public void setName(String name) {
        this.name1 = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    */
}
