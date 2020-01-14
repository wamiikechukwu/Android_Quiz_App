package com.wamiikechukwukanu.quizapp;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class misconAfrica extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private recyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscon_africa);

        ArrayList<dataModel> dataModels = new ArrayList<>();
        dataModels.add(new dataModel(R.drawable.africa_map, "Text1"));
        dataModels.add(new dataModel(R.drawable.appsbackground, "Text2"));
        dataModels.add(new dataModel(R.drawable.button_default_shape, "Text3"));

        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new recyclerViewAdapter(dataModels);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
