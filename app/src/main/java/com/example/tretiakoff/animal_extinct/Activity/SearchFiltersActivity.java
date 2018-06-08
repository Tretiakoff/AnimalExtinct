package com.example.tretiakoff.animal_extinct.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tretiakoff.animal_extinct.R;

public class SearchFiltersActivity extends AppCompatActivity {

    private Button searchBtn;
    private Spinner familyDropdown;
    private Spinner statusDropdown;
    private Spinner locationDropdown;
    private TextView noResultMsgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filters);
        Bundle b = getIntent().getExtras();
        String source = b.getString("source");

        noResultMsgView = findViewById(R.id.noResultMsg);

        if (source.equals("noResult") == true) {
            noResultMsgView.setText("No results for this research.");
        }

        searchBtn = findViewById(R.id.filterSearchBtn);

        familyDropdown = findViewById(R.id.familySelect);
        String[] families = new String[]{"All", "Mammals", "Birds", "Reptiles", "Amphibians", "Fish"};
        ArrayAdapter<String> familyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, families);
        familyDropdown.setAdapter(familyAdapter);

        statusDropdown = findViewById(R.id.statusSelect);
        String[] statuses = new String[]{"All", "Extinct", "Endangered", "Vulnerable"};
        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, statuses);
        statusDropdown.setAdapter(statusAdapter);

        locationDropdown = findViewById(R.id.locationSelect);
        String[] locations = new String[]{"All", "USA", "France", "China", "Australia", "Peru", "Morocco", "Norway"};
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locations);
        locationDropdown.setAdapter(locationAdapter);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String family = familyDropdown.getSelectedItem().toString();
                String status = statusDropdown.getSelectedItem().toString();
                String location = locationDropdown.getSelectedItem().toString();

                Intent myIntent = new Intent(SearchFiltersActivity.this, AnimalListActivity.class);
                Bundle b = new Bundle();
                b.putString("family", family);
                b.putString("status", status);
                b.putString("location", location);
                myIntent.putExtras(b);
                startActivity(myIntent);
                finish();
            }
        });
    }

    public void onBackPressed(){
        Intent myIntent = new Intent(SearchFiltersActivity.this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("source", "search");
        myIntent.putExtras(b);
        startActivity(myIntent);
        startActivity(myIntent);
        finish();
    }
}
