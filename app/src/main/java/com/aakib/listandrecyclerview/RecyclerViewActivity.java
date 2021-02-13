package com.aakib.listandrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aakib.listandrecyclerview.adapters.ReceipeAdapter;
import com.aakib.listandrecyclerview.listner.RecyclerItemClickListener;
import com.aakib.listandrecyclerview.models.ReceipeModel;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        getSupportActionBar().setTitle("RecyclerView");

        ArrayList<ReceipeModel> list = new ArrayList<>();
        list.add(new ReceipeModel(R.drawable.f1, getString(R.string.b1)));
        list.add(new ReceipeModel(R.drawable.f2, getString(R.string.b2)));
        list.add(new ReceipeModel(R.drawable.f3, getString(R.string.b3)));
        list.add(new ReceipeModel(R.drawable.f4, getString(R.string.b4)));
        list.add(new ReceipeModel(R.drawable.f5, getString(R.string.b5)));
        list.add(new ReceipeModel(R.drawable.f6, getString(R.string.b6)));
        list.add(new ReceipeModel(R.drawable.f7, getString(R.string.b7)));
        list.add(new ReceipeModel(R.drawable.f8, getString(R.string.b88)));
        list.add(new ReceipeModel(R.drawable.f9, getString(R.string.b9)));
        list.add(new ReceipeModel(R.drawable.f2,getString(R.string.sweet)));

        ReceipeAdapter adapter = new ReceipeAdapter(list, this);
        recyclerView.setAdapter(adapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position) {
                    case 0:
                        startActivity(new Intent(RecyclerViewActivity.this, ScrollingActivity.class));
                        break;

                    case 1:
                        Toast.makeText(RecyclerViewActivity.this, "Custom toast1", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(RecyclerViewActivity.this, "Custom toast2", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onLongItemClick(View view, int position) {
//todo code here
            }
        }));

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        GridLayoutManager manager=new GridLayoutManager(this,3);
//        recyclerView.setLayoutManager(manager);

//        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(manager);
    }
}