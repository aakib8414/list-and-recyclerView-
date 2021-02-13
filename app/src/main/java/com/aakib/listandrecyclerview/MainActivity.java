package com.aakib.listandrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] cities = {"mumbai", "Delhi", "Hyderabad", "Lucknow", "Bangalore", "Haryana", "Ludhiyana", "Pilibhit", "New York",
            "Raipur Bichpuri", "Lakhimpur"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        listView = findViewById(R.id.list);
        Arrays.sort(cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, cities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "clicked " + cities[position], Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_recycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                finish();
            }
        });
    }
}