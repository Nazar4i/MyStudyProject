package com.brainacad.studyproject.data.domain;

/**
 * Created by ${UArabei}.
 */
public class Ad {
    //TODO: describe ad

    private int userID;
    private int annoucementID;
    private int annoucementTupe;
    private String descriptionL;
    private String descriptionS;
    private AdType adType;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAnnoucementID() {
        return annoucementID;
    }

    public void setAnnoucementID(int annoucementID) {
        this.annoucementID = annoucementID;
    }

    public int getAnnoucementTupe() {
        return annoucementTupe;
    }

    public void setAnnoucementTupe(int annoucementTupe) {
        this.annoucementTupe = annoucementTupe;
    }

    public String getDescriptionL() {
        return descriptionL;
    }

    public void setDescriptionL(String descriptionL) {
        this.descriptionL = descriptionL;
    }

    public String getDescriptionS() {
        return descriptionS;
    }

    public void setDescriptionS(String descriptionS) {
        this.descriptionS = descriptionS;
    }

    public AdType getAdType() {
        return adType;
    }

    public void setAdType(AdType adType) {
        this.adType = adType;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "userID=" + userID +
                ", annoucementID=" + annoucementID +
                ", annoucementTupe=" + annoucementTupe +
                ", descriptionL='" + descriptionL + '\'' +
                ", descriptionS='" + descriptionS + '\'' +
                ", adType=" + adType +
                '}';
    }
}
