package com.wamiikechukwukanu.quizapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class wordListAdapter extends RecyclerView.Adapter<wordListAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private LinkedList<String> mWordList;

    public wordListAdapter(Context context, LinkedList<String> mWordList) {

        this.mWordList = mWordList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public wordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View mItemView = mInflater.inflate(R.layout.layout_holder, viewGroup, false);
        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull wordListAdapter.WordViewHolder wordViewHolder, int i) {

        String mCurrent = mWordList.get(i);
        wordViewHolder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {

        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {

        public final TextView wordItemView;
        final wordListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, wordListAdapter adapter) {

            super(itemView);
            wordItemView = itemView.findViewById(R.id.recyclerView_Text);
            this.mAdapter = adapter;

        }

    }

}
