package com.example.tretiakoff.animal_extinct.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tretiakoff.animal_extinct.API.Arkive;
import com.example.tretiakoff.animal_extinct.API.Client;
import com.example.tretiakoff.animal_extinct.API.Wikipedia;
import com.example.tretiakoff.animal_extinct.Model.Arkive.ArkiveResponseDoc;
import com.example.tretiakoff.animal_extinct.Model.Arkive.ArkiveResult;
import com.example.tretiakoff.animal_extinct.Model.Wikipedia.WikipediaResult;
import com.example.tretiakoff.animal_extinct.Model.Wikipedia.WikipediaSinglePage;
import com.example.tretiakoff.animal_extinct.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class AnimalActivity extends AppCompatActivity {

    ImageView imageView;
    TextView enNameView;
    TextView scientificNameView;
    TextView classificationView;
    TextView IUCNStatusView;
    TextView descriptionView;
    Button threatsBtnView;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        setContentView(R.layout.activity_animal);
        imageView = findViewById(R.id.imageView);
        threatsBtnView = findViewById(R.id.threatsBtn);

        getContent(name);

        threatsBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(AnimalActivity.this, ThreatsActivity.class);
                Bundle b = new Bundle();
                b.putString("name", scientificNameView.getText().toString());
                b.putString("url", imageUrl.toString());
                myIntent.putExtras(b);
                startActivity(myIntent);
                finish();
            }
        });
    }


    private void getContent(String name) {
        Arkive service = Client.getArkiveClient();
        retrofit2.Call call = service.getImage("doctype:species and "+name.toUpperCase(), "1", "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    Log.d("OKOKOOKOK", result.getResponse().getDocs().toString());
                    if(result.getResponse().getDocs().toString() == "[]"){
                        Log.d("OKOKOOKOK", "OKOKOKO");
                        Intent myIntent = new Intent(AnimalActivity.this, MainActivity.class);
                        Bundle b = new Bundle();
                        b.putString("source", "noResult");
                        myIntent.putExtras(b);
                        startActivity(myIntent);
                        finish();
                        return;
                    }

                    ArkiveResponseDoc doc = result.getResponse().getDocs().get(0);

                    if (doc == null){
                        return;
                    }
                    imageUrl = doc.getThumbnailURL();
                    imageUrl = doc.getImageUrl(imageUrl);

                    getDescription(doc.getNameCommon());
                    imageView = findViewById(R.id.imageView);
                    Picasso.with(getBaseContext()).load(imageUrl).into(imageView);

                    enNameView =  findViewById(R.id.enName);
                    enNameView.setText(doc.getNameCommon());

                    scientificNameView = findViewById(R.id.scientificName);
                    scientificNameView.setText(doc.getNameScientific());

                    classificationView = findViewById(R.id.classificaition);
                    classificationView.setText(doc.getFolksonomyGroups().get(0));

                    IUCNStatusView = findViewById(R.id.IUCNStatus);
                    IUCNStatusView.setText(doc.getiUCNStatus().toString());


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

    private void getDescription(String name) {
        Wikipedia service = Client.getWikipediaClient();
        retrofit2.Call call = service.getContent("json", "query", "extracts", "l", "l", name);
        call.enqueue(new Callback<WikipediaResult>() {
            @Override
            public void onResponse(Call<WikipediaResult> call, Response<WikipediaResult> response) {
                if (response.code() == 200) {
                    WikipediaResult result = response.body();
                    WikipediaSinglePage page = result.getQuery().getWikipediaSinglePageResult();

                    if (page == null) {
                        return;
                    }
                    String content = result.getQuery().getWikipediaSinglePageResult().getExtract();

                    descriptionView = findViewById(R.id.description);
                    descriptionView.setText(content);


                } else {
                    Log.d("error", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                return;
            }
        });

    }

    public void onBackPressed(){
        Intent myIntent = new Intent(AnimalActivity.this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("source", "animal");
        myIntent.putExtras(b);
        startActivity(myIntent);
        startActivity(myIntent);
        finish();
    }
}