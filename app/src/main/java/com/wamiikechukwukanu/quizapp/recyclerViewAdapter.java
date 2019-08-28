package com.wamiikechukwukanu.quizapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.recyclerViewHolder> {

    private ArrayList<dataModel> mDataModels;

    public recyclerViewAdapter(ArrayList<dataModel> dataModels) {

        mDataModels = dataModels;
    }

    @NonNull
    @Override
    public recyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_holder,
                viewGroup, false);
        recyclerViewHolder viewHolder = new recyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerViewHolder recyclerViewHolder, int i) {
        dataModel currentItem = mDataModels.get(i);
        recyclerViewHolder.mImageView.setImageResource(currentItem.getmImageResource());
        recyclerViewHolder.mTextView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {

        return mDataModels.size();
    }

    public static class recyclerViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView;

        public recyclerViewHolder(@NonNull View itemView) {

            super(itemView);
            mImageView = itemView.findViewById(R.id.recyclerView_Image);
            mTextView = itemView.findViewById(R.id.recyclerView_Text);
        }

    }

}
