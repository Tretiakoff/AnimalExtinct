package com.example.tretiakoff.animal_extinct.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class ArkiveResponse {

    public ArkiveResponse(int numFound, int start, ArrayList<ArkiveResponseDoc> docs) {
        this.numFound = numFound;
        this.start = start;
        this.docs = docs;
    }

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int numFound;

    public int start;


    public ArrayList<ArkiveResponseDoc> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<ArkiveResponseDoc> docs) {
        this.docs = docs;
    }

    public ArrayList<ArkiveResponseDoc> docs;

}
