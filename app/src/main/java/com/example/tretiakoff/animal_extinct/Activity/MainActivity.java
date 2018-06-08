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
    private Button listBtn;
    private EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchText = (EditText)findViewById(R.id.animalSearchText);

        searchBtn = findViewById(R.id.animalSearchBtn);
        listBtn = findViewById(R.id.animalListBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, AnimalActivity.class);
                Bundle b = new Bundle();
                b.putString("name", searchText.getText().toString());
                myIntent.putExtras(b);
                startActivity(myIntent);
                finish();
            }
        });

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SearchFiltersActivity.class);
                Bundle b = new Bundle();
                b.putString("source", "main");
                myIntent.putExtras(b);
                startActivity(myIntent);
                finish();
            }
        });

    }
}
