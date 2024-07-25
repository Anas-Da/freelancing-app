package com.example.freelancing_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.SellerViewHolder> {

    private Context context;
    private List<Seller> sellerList;

    public SellerAdapter(Context context, List<Seller> sellerList) {
        this.context = context;
        this.sellerList = sellerList;
    }

    @NonNull
    @Override
    public SellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new SellerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerViewHolder holder, int position) {
        Seller seller = sellerList.get(position);
        holder.name.setText(seller.getName());
        holder.image.setImageResource(seller.getImageResource());
    }

    @Override
    public int getItemCount() {
        return sellerList.size();
    }

    public static class SellerViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView type;

        public SellerViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.seller_name);
            type = itemView.findViewById(R.id.type);
        }
    }
}