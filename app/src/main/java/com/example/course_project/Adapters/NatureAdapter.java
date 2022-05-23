package com.example.course_project.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NatureAdapter extends RecyclerView.Adapter<NatureAdapter.ViewHolder> {
    @NonNull
    @Override
    public NatureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NatureAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, price;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
