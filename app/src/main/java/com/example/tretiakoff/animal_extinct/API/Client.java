package com.example.tretiakoff.animal_extinct.API;

/**
 * Created by tretiakoff on 05/06/2018.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static Arkive getClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Arkive.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Arkive.class);
    }

}
