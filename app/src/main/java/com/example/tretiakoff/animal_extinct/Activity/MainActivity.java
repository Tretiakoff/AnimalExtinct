package com.example.tretiakoff.animal_extinct.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tretiakoff.animal_extinct.R;

public class MainActivity extends AppCompatActivity {

    private Button topRatedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topRatedList = findViewById(R.id.animalSearchBtn);

        topRatedList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, AnimalActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
