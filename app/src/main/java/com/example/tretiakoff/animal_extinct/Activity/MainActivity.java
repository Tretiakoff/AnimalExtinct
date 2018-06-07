package com.example.tretiakoff.animal_extinct.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tretiakoff.animal_extinct.R;

public class MainActivity extends AppCompatActivity {

    private Button searchBtn;
    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchText = (EditText)findViewById(R.id.animalSearchText);

        searchBtn = findViewById(R.id.animalSearchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, AnimalActivity.class);
                Bundle b = new Bundle();
                b.putString("name", searchText.getText().toString()); //Your id
                myIntent.putExtras(b); //Put your id to your next Intent
                startActivity(myIntent);
                finish();
            }
        });

    }
}