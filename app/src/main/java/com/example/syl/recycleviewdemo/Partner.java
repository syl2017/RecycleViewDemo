package com.example.syl.recycleviewdemo;

/**
 * Created by syl on 2017/4/27.
 */

public class Partner {
    private String name;
    private int imageId;
    private int profiledId;

    public Partner(String name, int imageId, int profiledId) {
        this.name = name;
        this.imageId = imageId;
        this.profiledId = profiledId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getProfiledId() {
        return profiledId;
    }

    public void setProfiledId(int profiledId) {
        this.profiledId = profiledId;
    }
}
