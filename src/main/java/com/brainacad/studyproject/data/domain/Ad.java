package com.brainacad.studyproject.data.domain;

/**
 * Created by ${UArabei}.
 */
public class Ad {
    //TODO: describe ad

    private int AdID;
    private int UserId;
    private String shortDesc;
    private String fullDesc;
    private Type type;

    public int getAdID() {
        return AdID;
    }

    public void setAdID(int adID) {
        AdID = adID;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "AdID=" + AdID +
                ", UserId=" + UserId +
                ", shortDesc='" + shortDesc + '\'' +
                ", fullDesc='" + fullDesc + '\'' +
                ", type=" + type +
                '}';
    }
}
