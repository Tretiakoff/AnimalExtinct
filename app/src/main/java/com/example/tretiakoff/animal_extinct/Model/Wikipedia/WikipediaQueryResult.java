package com.example.tretiakoff.animal_extinct.Model.Wikipedia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class WikipediaQueryResult {

    public WikipediaQueryResult(Map<String, WikipediaSinglePageResult> result) {
        this.result = result;
    }

    @SerializedName("pages")
    @Expose
    private Map<String, WikipediaSinglePageResult> result;

    public WikipediaSinglePageResult getWikipediaSinglePageResult()
    {
        for(WikipediaSinglePageResult wiki : result.values())
        {
            return wiki;
        }
        return null;
    }
}
