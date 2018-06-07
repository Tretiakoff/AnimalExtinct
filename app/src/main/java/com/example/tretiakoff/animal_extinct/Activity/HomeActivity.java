package com.example.tretiakoff.animal_extinct.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.tretiakoff.animal_extinct.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent moveToMainActivity = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(moveToMainActivity);
                finish();
            }
        }, 1000);

    }

}





