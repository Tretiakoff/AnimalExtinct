package com.example.tretiakoff.animal_extinct.API;

/**
 * Created by tretiakoff on 05/06/2018.
 */
import com.example.tretiakoff.animal_extinct.Model.Arkive.ArkiveResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Arkive {

    String BASE_URL = "http://search.arkive.org/solr/live/";
    @GET("discover")
    Call<ArkiveResult> getImage(@Query("q") String name, @Query("rows") String rows,
                                @Query("wt") String format);
}

