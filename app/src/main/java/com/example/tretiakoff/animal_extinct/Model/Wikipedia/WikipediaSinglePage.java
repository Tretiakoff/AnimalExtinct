package com.example.tretiakoff.animal_extinct.Model.Wikipedia;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class WikipediaSinglePage {

    public WikipediaSinglePage(int pageid, int ns, String title, String extract) {
        this.pageid = pageid;
        this.ns = ns;
        this.title = title;
        this.extract = extract;
    }

    private int pageid;
    private int ns;
    private String title;
    private String extract;

    public String getExtract() {
        return extract;
    }
}
