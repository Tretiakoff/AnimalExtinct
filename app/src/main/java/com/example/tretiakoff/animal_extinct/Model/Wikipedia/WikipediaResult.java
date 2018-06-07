package com.example.tretiakoff.animal_extinct.Model.Wikipedia;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class WikipediaResult {

    public WikipediaResult(String batchcomplete, WikipediaQuery query) {
        this.batchcomplete = batchcomplete;
        this.query = query;
    }

    public WikipediaQuery getQuery() {
        return query;
    }

    public void setQuery(WikipediaQuery query) {
        this.query = query;
    }

    private String batchcomplete;
    private WikipediaQuery query;
}
