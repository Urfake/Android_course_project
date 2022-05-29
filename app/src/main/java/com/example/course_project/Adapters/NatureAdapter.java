package com.example.course_project.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.course_project.Domains.NatureDomain;
import com.example.course_project.R;

import java.util.ArrayList;

public class NatureAdapter extends RecyclerView.Adapter<NatureAdapter.ViewHolder> {

    ArrayList<NatureDomain> natureDomains = new ArrayList<>();

    public NatureAdapter(ArrayList<NatureDomain> natureDomains) {
        this.natureDomains = natureDomains;
    }

    @NonNull
    @Override
    public NatureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item, parent, false);
        return new NatureAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NatureAdapter.ViewHolder holder, int position) {
        holder.name.setText(natureDomains.get(position).getName());
        holder.price.setText(String.valueOf(natureDomains.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(natureDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return natureDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, price;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_cat_title);
            price = itemView.findViewById(R.id.tv_cat_price);
            pic = itemView.findViewById(R.id.iv_cat);
        }

    }
}
