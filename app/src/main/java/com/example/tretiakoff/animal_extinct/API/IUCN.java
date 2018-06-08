package com.example.tretiakoff.animal_extinct.API;

/**
 * Created by tretiakoff on 05/06/2018.
 */

import com.example.tretiakoff.animal_extinct.Model.IUCNResponse;
import com.example.tretiakoff.animal_extinct.Model.Wikipedia.WikipediaResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface IUCN {

    String BASE_URL = "http://apiv3.iucnredlist.org/";

    @GET("api/v3/species/narrative/{name}")
    Call<IUCNResponse> getThreats(@Path(value = "name", encoded = true) String name, @Query("token") String token);
}

