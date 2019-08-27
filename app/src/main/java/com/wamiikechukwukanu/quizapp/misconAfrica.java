package com.wamiikechukwukanu.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.LinkedList;

public class misconAfrica extends AppCompatActivity {

    private final LinkedList<String> linkedList = new LinkedList<>();
    private int mWord = 0;
    private RecyclerView mRecyclerView;
    private wordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscon_africa);

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recycler_view);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new wordListAdapter(this, linkedList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for (int i = 0; i < 20; i++) {
            linkedList.add("recyclerView_Text " + mWord);
            Log.d("WORD", linkedList.getLast());
            mWord++;
        }


    }

}
