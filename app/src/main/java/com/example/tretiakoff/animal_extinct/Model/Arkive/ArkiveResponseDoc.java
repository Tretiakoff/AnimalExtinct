package com.example.tretiakoff.animal_extinct.Model.Arkive;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class ArkiveResponseDoc {

    public ArkiveResponseDoc(String mediaCaption, boolean imageLandscape, boolean videoWidescreen, String vaultGuid, String kalturaId, int mediaLicense, boolean embedPermitted, int exchangeId, String id, String title, String dateModified, String accessionsGroup, String iUCNStatus, String nameCommon, String nameScientific, int iUCNId, ArrayList<String> folksonomyGroups, String thumbnailURL, String thumbnailCaption, String shortDescription, String doctype, String warehouseId, int version) {
        this.mediaCaption = mediaCaption;
        this.imageLandscape = imageLandscape;
        this.videoWidescreen = videoWidescreen;
        this.vaultGuid = vaultGuid;
        this.kalturaId = kalturaId;
        this.mediaLicense = mediaLicense;
        this.embedPermitted = embedPermitted;
        this.exchangeId = exchangeId;
        this.id = id;
        this.title = title;
        this.dateModified = dateModified;
        this.accessionsGroup = accessionsGroup;
        this.iUCNStatus = iUCNStatus;
        this.nameCommon = nameCommon;
        this.nameScientific = nameScientific;
        this.iUCNId = iUCNId;
        this.folksonomyGroups = folksonomyGroups;
        this.thumbnailURL = thumbnailURL;
        this.thumbnailCaption = thumbnailCaption;
        this.shortDescription = shortDescription;
        this.doctype = doctype;
        this.warehouseId = warehouseId;
        this.version = version;
    }

    private String mediaCaption;
    private boolean imageLandscape;
    private boolean videoWidescreen;
    private String vaultGuid;
    private String kalturaId;
    private int mediaLicense;
    private boolean embedPermitted;
    private int exchangeId;
    private String id;
    private String title;
    private String dateModified;
    private String accessionsGroup;
    private String iUCNStatus;
    private String nameCommon;
    private String nameScientific;
    private int iUCNId;

    public ArrayList<String> getFolksonomyGroups() {
        return folksonomyGroups;
    }

    public void setFolksonomyGroups(ArrayList<String> folksonomyGroups) {
        this.folksonomyGroups = folksonomyGroups;
    }

    private ArrayList<String> folksonomyGroups = null;

    public String getiUCNStatus() {
        return iUCNStatus;
    }

    public void setiUCNStatus(String iUCNStatus) {
        this.iUCNStatus = iUCNStatus;
    }

    public String getNameCommon() {
        return nameCommon;
    }

    public void setNameCommon(String nameCommon) {
        this.nameCommon = nameCommon;
    }

    public String getNameScientific() {
        return nameScientific;
    }

    public void setNameScientific(String nameScientific) {
        this.nameScientific = nameScientific;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getImageUrl(String str) {
        String url = str.replace("Thumb", "Large");

        return url;
    }


    private String thumbnailURL;
    private String thumbnailCaption;
    private String shortDescription;
    private String doctype;
    private String warehouseId;
    private int version;
}
