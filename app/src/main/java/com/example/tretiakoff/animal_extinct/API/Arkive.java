package com.example.tretiakoff.animal_extinct.API;

/**
 * Created by tretiakoff on 05/06/2018.
 */
import com.example.tretiakoff.animal_extinct.Model.ArkiveResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Arkive {

    String BASE_URL = "http://search.arkive.org/solr/live/";
    String API_KEY = "SFSDF24242353434";

    @GET("discover") //i.e https://api.test.com/Search?
    Call<ArkiveResult> getImage(@Query("q") String name, @Query("rows") String rows,
                                @Query("wt") String format);

//    String BASE_URL = "http://search.arkive.org/solr/live/";
//    String IMAGE_URL = "http://cdn2.arkive.org/media/A7/A7D34FC1-8641-4FDC-9E15-04ACC94AA96C/Presentation.Large/Two-African-lions.jpg";
//
//    @GET("?q=doctype:{name}&rows=1&wt=json")
//    Call<ArkiveUrl> getImage(@Query("name") String name);

}

