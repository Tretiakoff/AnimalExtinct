package com.example.tretiakoff.animal_extinct.Model.Wikipedia;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class WikipediaResult {

    public WikipediaResult(String batchcomplete, WikipediaQueryResult query) {
        this.batchcomplete = batchcomplete;
        this.query = query;
    }

    public WikipediaQueryResult getQuery() {
        return query;
    }

    public void setQuery(WikipediaQueryResult query) {
        this.query = query;
    }

    private String batchcomplete;
    private WikipediaQueryResult query;
}
