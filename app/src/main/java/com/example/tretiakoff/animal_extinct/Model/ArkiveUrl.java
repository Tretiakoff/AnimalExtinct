package com.example.tretiakoff.animal_extinct.Model;

/**
 * Created by tretiakoff on 05/06/2018.
 */

public class ArkiveUrl {

    public ArkiveUrl(String str) {
        this.str = str;
        this.setImageUrl(str);

    }

    public String str;
    public String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String str) {
        String startString = "<img src=\\\"";
        String endString = "alt=\\\"";


        int startIndex = str.indexOf(startString)+startString.length();
        int endIndex = str.indexOf(endString)+endString.length();

        String urlImage = str.substring(startIndex, endIndex).replace("\\\" alt=\\\"", "");

        this.imageUrl = urlImage;
    }
}
