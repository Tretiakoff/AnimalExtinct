package com.example.tretiakoff.animal_extinct.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.Random;


import com.example.tretiakoff.animal_extinct.API.ArkiveFilters;
import com.example.tretiakoff.animal_extinct.API.Client;
import com.example.tretiakoff.animal_extinct.Model.Arkive.ArkiveResponseDoc;
import com.example.tretiakoff.animal_extinct.Model.Arkive.ArkiveResult;
import com.example.tretiakoff.animal_extinct.Model.Wikipedia.WikipediaSinglePage;
import com.example.tretiakoff.animal_extinct.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalListActivity extends AppCompatActivity implements AnimalRecyclerViewAdapter.OnTopRatedClickListener {
    private AnimalRecyclerViewAdapter mAnimalRecyclerViewAdapter;
    String status;
    String location;
    String family;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();

        status = b.getString("status");
        location = b.getString("location");
        family = b.getString("family");

        setContentView(R.layout.activity_animal_list);
        RecyclerView mRecyclerView = findViewById(R.id.topRatedRecyclerView);

        mAnimalRecyclerViewAdapter = new AnimalRecyclerViewAdapter(AnimalListActivity.this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(AnimalListActivity.this));
        mRecyclerView.setAdapter(mAnimalRecyclerViewAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();


        if (status.equals("All"))
        {
            if (location.equals("All"))
            {
                if(family.equals("All"))
                {
                    getAll();
                }
                else
                {
                    getAnimalListByFamily(family);
                }
            }
            else if(family.equals("All"))
            {
                getAnimalListByLocation(location);
            }
            else
            {
                getAnimalsByLocationAndFamily(location, family);
            }
        }
        else
        {
            if (location.equals("All"))
            {
                if(family.equals("All"))
                {
                    getAnimalListByStatus(status);
                }
                else
                {
                    getAnimalListByFamilyAndStatus(status, family);
                }
            }
            else if(family.equals("All"))
            {
                getAnimalListByLocationAndStatus(status,location);
            }
            else
            {
                getAnimalListByAllParams(status, location, family);
            }
        }

    }

    private void getAnimalListByAllParams(String status, String location, String family) {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}IUCNStatus:"+status+"{!tag=ag}geographicLocation:"+location+"{!tag=ag}accessionsGroup:"+family, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    if (results == null){
                        noResultMessage();
                    }

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    mAnimalRecyclerViewAdapter.setTopRatedList(resultInDifferentOrder);
                    mAnimalRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d("error", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });

    }

    private void getAnimalListByStatus(String status) {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}IUCNStatus:"+status, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();
                    if (results == null){
                        noResultMessage();
                    }
                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    mAnimalRecyclerViewAdapter.setTopRatedList(resultInDifferentOrder);
                    mAnimalRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });

    }

    private void getAnimalListByFamily(String family) {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}accessionsGroup:"+family, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();
                    if (results == null){
                        noResultMessage();
                    }
                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    mAnimalRecyclerViewAdapter.setTopRatedList(resultInDifferentOrder);
                    mAnimalRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d("error", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });

    }

    private void getAnimalListByLocation(String location) {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}geographicLocation:"+location, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();
                    if (results == null){
                        noResultMessage();
                    }
                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    mAnimalRecyclerViewAdapter.setTopRatedList(resultInDifferentOrder);
                    mAnimalRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d("error", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });

    }

    private void getAll() {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "", "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    mAnimalRecyclerViewAdapter.setTopRatedList(resultInDifferentOrder);
                    mAnimalRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d("error", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });

    }

    private void getAnimalListByLocationAndStatus(String status, String location) {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}IUCNStatus:"+status+"{!tag=ag}geographicLocation:"+location, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();
                    Log.d("SIZE", String.valueOf(results.size()));
                    if (results.size() == 0){
                        noResultMessage();
                    }
                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    mAnimalRecyclerViewAdapter.setTopRatedList(resultInDifferentOrder);
                    mAnimalRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d("error", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });

    }

    private void getAnimalsByLocationAndFamily(String location, String family) {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}geographicLocation:"+location+"{!tag=ag}accessionsGroup:"+family, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();
                    if (results == null){
                        noResultMessage();
                    }
                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    mAnimalRecyclerViewAdapter.setTopRatedList(resultInDifferentOrder);
                    mAnimalRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d("error", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });

    }

    private void getAnimalListByFamilyAndStatus(String status, String family) {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}IUCNStatus:"+status+"{!tag=ag}accessionsGroup:"+family, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    mAnimalRecyclerViewAdapter.setTopRatedList(resultInDifferentOrder);
                    mAnimalRecyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Log.d("error", "error");
                    return;
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                return;
            }
        });

    }

    public void onBackPressed(){
        Intent myIntent = new Intent(AnimalListActivity.this, SearchFiltersActivity.class);
        Bundle b = new Bundle();
        b.putString("source", "mainActivity");
        myIntent.putExtras(b);
        startActivity(myIntent);
        finish();
    }


    @Override
    public void onTopRatedClick(ArkiveResponseDoc animal) {
        Intent myIntent = new Intent(AnimalListActivity.this, AnimalDetailActivity.class);
        Bundle b = new Bundle();
        b.putString("imageUrl", animal.getThumbnailURL());
        b.putString("enName", animal.getNameCommon());
        b.putString("scientificName", animal.getNameScientific());
        b.putString("status", animal.getiUCNStatus());
        b.putString("initialStatus", status);
        b.putString("initialLocation", location);
        b.putString("initialFamily", family);
        myIntent.putExtras(b);
        startActivity(myIntent);
        finish();
    }

    public void noResultMessage() {
        Intent myIntent = new Intent(AnimalListActivity.this, SearchFiltersActivity.class);
        Bundle b = new Bundle();
        b.putString("source", "noResult");
        myIntent.putExtras(b);
        startActivity(myIntent);
        finish();
    }
}
