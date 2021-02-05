package com.wamiikechukwukanu.quizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.recyclerViewHolder> {

    private final ArrayList<mdataModel> mMdataModels;

    public recyclerViewAdapter(ArrayList<mdataModel> mdataModels) {

        mMdataModels = mdataModels;
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
        mdataModel currentItem = mMdataModels.get(i);
        recyclerViewHolder.mImageView.setImageResource(currentItem.getmImageResource());
        recyclerViewHolder.mTextView.setText(currentItem.getmText());

    }

    @Override
    public int getItemCount() {

        return mMdataModels.size();
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
