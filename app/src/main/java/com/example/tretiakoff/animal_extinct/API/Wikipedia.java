package com.example.tretiakoff.animal_extinct.API;

/**
 * Created by tretiakoff on 05/06/2018.
 */

import com.example.tretiakoff.animal_extinct.Model.Wikipedia.WikipediaResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Wikipedia {

    String BASE_URL = "https://en.wikipedia.org/w/";

    @GET("api.php")
    Call<WikipediaResult> getContent(@Query("format") String format, @Query("action") String action,
                                     @Query("prop") String prop, @Query("exintro") String exintro,
                                     @Query("explaintext") String explaintext, @Query("titles") String titles);
}

