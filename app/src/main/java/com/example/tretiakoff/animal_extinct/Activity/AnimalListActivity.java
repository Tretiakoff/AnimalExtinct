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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);
        RecyclerView mRecyclerView = findViewById(R.id.topRatedRecyclerView);

        mAnimalRecyclerViewAdapter = new AnimalRecyclerViewAdapter(AnimalListActivity.this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(AnimalListActivity.this));
        mRecyclerView.setAdapter(mAnimalRecyclerViewAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("OOHOHO","AAAA");
//        getAnimalListByLocation();
//        getAnimalListByLocationAndStatus();
//        getAnimalsByLocationAndFamily();
//        getAnimalListByFamilyAndStatus();
    }

    private void getAnimalListByAllParams() {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        String status = "Vulnerable";
        String location = "USA";
        String family = "Mammals";



        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}IUCNStatus:"+status+"{!tag=ag}geographicLocation:"+location+"{!tag=ag}accessionsGroup:"+family, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    Log.d("resultSize", String.valueOf(results.size()));
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        Log.d("randomIndex", String.valueOf(randomIndex));
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    Log.d("resultMelangeSize", String.valueOf(resultInDifferentOrder.size()));



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

    private void getAnimalListByStatus() {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        String status = "Vulnerable";

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}IUCNStatus:"+status, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    Log.d("resultSize", String.valueOf(results.size()));
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        Log.d("randomIndex", String.valueOf(randomIndex));
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    Log.d("resultMelangeSize", String.valueOf(resultInDifferentOrder.size()));



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

    private void getAnimalListByFamily() {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        String family = "Mammals";

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}accessionsGroup:"+family, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    Log.d("resultSize", String.valueOf(results.size()));
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        Log.d("randomIndex", String.valueOf(randomIndex));
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    Log.d("resultMelangeSize", String.valueOf(resultInDifferentOrder.size()));



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

    private void getAnimalListByLocation() {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        String location = "USA";

        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}geographicLocation:"+location, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    Log.d("resultSize", String.valueOf(results.size()));
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        Log.d("randomIndex", String.valueOf(randomIndex));
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    Log.d("resultMelangeSize", String.valueOf(resultInDifferentOrder.size()));



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

    private void getAnimalListByLocationAndStatus() {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        String status = "Vulnerable";
        String location = "USA";


        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}IUCNStatus:"+status+"{!tag=ag}geographicLocation:"+location, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    Log.d("resultSize", String.valueOf(results.size()));
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        Log.d("randomIndex", String.valueOf(randomIndex));
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    Log.d("resultMelangeSize", String.valueOf(resultInDifferentOrder.size()));



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

    private void getAnimalsByLocationAndFamily() {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        String location = "USA";
        String family = "Mammals";


        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}geographicLocation:"+location+"{!tag=ag}accessionsGroup:"+family, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    Log.d("resultSize", String.valueOf(results.size()));
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        Log.d("randomIndex", String.valueOf(randomIndex));
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    Log.d("resultMelangeSize", String.valueOf(resultInDifferentOrder.size()));



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

    private void getAnimalListByFamilyAndStatus() {
        ArkiveFilters service = Client.getArkiveFiltersClient();

        String status = "Vulnerable";
        String family = "Mammals";


        retrofit2.Call call = service.getAnimals(30, "doctype:species", "score desc", "{!tag=ag}IUCNStatus:"+status+"{!tag=ag}accessionsGroup:"+family, "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    ArrayList<ArkiveResponseDoc> results = result.getResponse().getDocs();

                    ArrayList<ArkiveResponseDoc> resultInDifferentOrder = new ArrayList<ArkiveResponseDoc>();
                    Log.d("resultSize", String.valueOf(results.size()));
                    int security = 0;
                    while(resultInDifferentOrder.size() < results.size() && security < 1000)
                    {
                        Random r = new Random();
                        int randomIndex = r.nextInt(results.size());
                        Log.d("randomIndex", String.valueOf(randomIndex));
                        ArkiveResponseDoc randomElement = results.get(randomIndex);
                        if(!resultInDifferentOrder.contains(randomElement))
                        {
                            resultInDifferentOrder.add(randomElement);

                        }
                        security++;
                    }
                    Log.d("resultMelangeSize", String.valueOf(resultInDifferentOrder.size()));



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
        Intent myIntent = new Intent(AnimalListActivity.this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }


    @Override
    public void onTopRatedClick(ArkiveResponseDoc animal) {

    }
}
