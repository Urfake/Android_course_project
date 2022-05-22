package com.example.course_project.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.course_project.Domains.MaterialDomain;
import com.example.course_project.Helper.ManagementCart;
import com.example.course_project.Interface.ChangeNumberItemsListener;
import com.example.course_project.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ArrayList<MaterialDomain> materialDomains;
    private ManagementCart managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<MaterialDomain> foodDomains, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.materialDomains = foodDomains;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {
        holder.title.setText(materialDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(materialDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((materialDomains.get(position).getNumberInCart() * materialDomains.get(position).getFee()) * 100) / 100));
        holder.num.setText(String.valueOf(materialDomains.get(position).getNumberInCart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(materialDomains.get(position).getPic()
                , "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.plusNumberFood(materialDomains, position, new ChangeNumberItemsListener() {
                            @Override
                            public void changed() {
                                notifyDataSetChanged();
                                changeNumberItemsListener.changed();
                            }
                        });
            }
        });


                        holder.minusItem.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                managementCart.minusNumberFood(materialDomains, position, new ChangeNumberItemsListener() {
                                    @Override
                                    public void changed() {
                                        notifyDataSetChanged();
                                        changeNumberItemsListener.changed();
                                    }
                                });
                            }
                        });
    }

    @Override
    public int getItemCount() {
        return materialDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.picCart);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.numberItemTxt);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCartBtn);
        }
    }
}
