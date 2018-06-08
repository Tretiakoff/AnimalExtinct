package com.example.tretiakoff.animal_extinct.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tretiakoff.animal_extinct.API.Arkive;
import com.example.tretiakoff.animal_extinct.API.Client;
import com.example.tretiakoff.animal_extinct.API.IUCN;
import com.example.tretiakoff.animal_extinct.Model.Arkive.ArkiveResponseDoc;
import com.example.tretiakoff.animal_extinct.Model.Arkive.ArkiveResult;
import com.example.tretiakoff.animal_extinct.Model.IUCNResponse;
import com.example.tretiakoff.animal_extinct.Model.IUCNResult;
import com.example.tretiakoff.animal_extinct.R;
import com.squareup.picasso.Picasso;

import java.net.URLEncoder;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThreatsActivity extends AppCompatActivity {

    TextView nameView;
    TextView threatsView;
    ImageView imageUrlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threats);
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        String url = b.getString("url");
        Log.d("URL", url);

        nameView = findViewById(R.id.nameView);
        threatsView = findViewById(R.id.threatsView);
        imageUrlView = findViewById(R.id.imageUrlView);

        Picasso.with(getBaseContext()).load(url).into(imageUrlView);

        getThreats(name);
    }

    private void getThreats(String name) {
        IUCN service = Client.getIUCNClient();
        retrofit2.Call call = service.getThreats(name,"9bb4facb6d23f48efbf424bb05c0c1ef1cf6f468393bc745d42179ac4aca5fee");
        call.enqueue(new Callback<IUCNResponse>() {

            @Override
            public void onResponse(Call<IUCNResponse> call, Response<IUCNResponse> response) {
                if (response.code() == 200) {
                    IUCNResponse result = response.body();
                    IUCNResult data = result.getResult().get(0);
                    nameView.setText(result.getName());

                    if (result.getResult().size() == 0){
                        threatsView.setText("No threats information.");

                    }

                    threatsView.setText(android.text.Html.fromHtml(data.getThreats()).toString());

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
        Intent myIntent = new Intent(ThreatsActivity.this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("source", "threats");
        myIntent.putExtras(b);
        startActivity(myIntent);
        finish();
    }
}
