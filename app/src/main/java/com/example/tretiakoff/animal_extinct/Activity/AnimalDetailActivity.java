package com.example.tretiakoff.animal_extinct.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tretiakoff.animal_extinct.API.Client;
import com.example.tretiakoff.animal_extinct.API.Wikipedia;
import com.example.tretiakoff.animal_extinct.Model.Wikipedia.WikipediaResult;
import com.example.tretiakoff.animal_extinct.Model.Wikipedia.WikipediaSinglePage;
import com.example.tretiakoff.animal_extinct.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView enNameView;
    TextView scientificNameView;
    TextView classificationView;
    TextView IUCNStatusView;
    TextView descriptionView;
    String initialStatus;
    String initialLocation;
    String initialFamily;
    Button threatsBtn;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();

        String imageUrl = b.getString("imageUrl");
        String enName = b.getString("enName");
        String scientificName = b.getString("scientificName");
        String status = b.getString("status");
        String classification = b.getString("classification");
        setContentView(R.layout.activity_animal);

        initialStatus = b.getString("initialStatus");
        initialLocation = b.getString("initialLocation");
        initialFamily = b.getString("initialFamily");

        imageView = findViewById(R.id.imageView);
        url = imageUrl;

        Picasso.with(getBaseContext())
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
        threatsBtn = findViewById(R.id.threatsBtn);
        enNameView =  findViewById(R.id.enName);
        enNameView.setText(enName);

        scientificNameView = findViewById(R.id.scientificName);
        scientificNameView.setText(scientificName);

        classificationView = findViewById(R.id.classificaition);
        classificationView.setText(classification);

        IUCNStatusView = findViewById(R.id.IUCNStatus);
        IUCNStatusView.setText(status);

        getDescription(enName);

        threatsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(AnimalDetailActivity.this, ThreatsActivity.class);
                Bundle b = new Bundle();
                b.putString("name", scientificNameView.getText().toString());
                myIntent.putExtras(b);
                startActivity(myIntent);
                finish();
            }
        });
    }

    private void getDescription(String name) {
        Wikipedia service = Client.getWikipediaClient();
        retrofit2.Call call = service.getContent("json", "query", "extracts", "l", "l", name);
        call.enqueue(new Callback<WikipediaResult>() {
            @Override
            public void onResponse(Call<WikipediaResult> call, Response<WikipediaResult> response) {
                Log.d("RESP", response.body().toString());
                if (response.code() == 200) {
                    WikipediaResult result = response.body();
                    WikipediaSinglePage page = result.getQuery().getWikipediaSinglePageResult();

                    if (page == null) {
                        Log.d("PAGE", "NULL");
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
        Intent myIntent = new Intent(AnimalDetailActivity.this, AnimalListActivity.class);
        Bundle b = new Bundle();
        b.putString("family", initialFamily);
        b.putString("status", initialStatus);
        b.putString("location", initialLocation);
        myIntent.putExtras(b);
        startActivity(myIntent);
        finish();
    }
}
