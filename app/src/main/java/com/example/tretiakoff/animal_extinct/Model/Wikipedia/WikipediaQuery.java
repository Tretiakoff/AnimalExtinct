package com.example.tretiakoff.animal_extinct.Model.Wikipedia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class WikipediaQuery {

    public WikipediaQuery(Map<String, WikipediaSinglePage> result) {
        this.result = result;
    }

    @SerializedName("pages")
    @Expose
    private Map<String, WikipediaSinglePage> result;

    public WikipediaSinglePage getWikipediaSinglePageResult()
    {
        for(WikipediaSinglePage wiki : result.values())
        {
            return wiki;
        }
        return null;
    }
}
