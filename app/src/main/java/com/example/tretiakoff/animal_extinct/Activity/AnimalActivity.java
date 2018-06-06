package com.example.tretiakoff.animal_extinct.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.tretiakoff.animal_extinct.API.Arkive;
import com.example.tretiakoff.animal_extinct.API.Client;
import com.example.tretiakoff.animal_extinct.Model.ArkiveResponse;
import com.example.tretiakoff.animal_extinct.Model.ArkiveResult;
import com.example.tretiakoff.animal_extinct.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        setContentView(R.layout.activity_animal);
        imageView = (ImageView) findViewById(R.id.imageView);
//        String test = "<a href=\\\"http://www.arkive.org/grey-wolf/canis-lupus/image-G57747.html#src=portletV3api\\\" title=\\\"Arkive image - Arctic wolf with pup near den\\\" ><img src=\\\"https://53744bf91d44b81762e0-fbbc959d4e21c00b07dbe9c75f9c0b63.ssl.cf3.rackcdn.com/media/3B/3BC91E34-AC18-45B3-BFC3-10725A395CB3/Presentation.Portlet/Arctic-wolf-with-pup-near-den.jpg\\\" alt=\\\"Arkive image - Arctic wolf with pup near den\\\" title=\\\"Arkive image - Arctic wolf with pup near den\\\" border=\\\"0\\\"/></a>";
//        ArkiveUrl arkiveResult = new ArkiveUrl(test);
//
//        String url = arkiveResult.getImageUrl();
//
//        Picasso.with(getBaseContext()).load(url).into(imageView);

        getUrl(name);
    }


    private void getUrl(String name) {
        Arkive service = Client.getClient();
        retrofit2.Call call = service.getImage("doctype:image and "+name, "1", "json");
        call.enqueue(new Callback<ArkiveResult>() {

            @Override
            public void onResponse(Call<ArkiveResult> call, Response<ArkiveResult> response) {
                Log.d("resp", response.toString());
                Log.d("SUCCES", "SUCCES");
                if (response.code() == 200) {
                    ArkiveResult result = response.body();
                    String imageUrl = result.getResponse().getDocs().get(0).getThumbnailURL();
                    String url = result.getResponse().getDocs().get(0).getImageUrl(result.getResponse().getDocs().get(0).getThumbnailURL());
                    imageView = (ImageView) findViewById(R.id.imageView);
                    Picasso.with(getBaseContext()).load(url).into(imageView);

                } else {
                    Log.d("error", "error");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("ERROR", "THERE IS AN ERROR");
            }
        });

    }

    public void onBackPressed(){
        Intent myIntent = new Intent(AnimalActivity.this, MainActivity.class);
        startActivity(myIntent);
        finish();

    }
}
