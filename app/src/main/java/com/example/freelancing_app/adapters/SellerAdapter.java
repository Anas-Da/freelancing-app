package com.example.freelancing_app.adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Seller;

import java.util.List;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.SellerViewHolder> {

    private Context context;
    private List<Seller> sellerList;
    private OnItemClickListener onItemClickListener;

    public SellerAdapter(Context context, List<Seller> sellerList,OnItemClickListener onItemClickListener) {
        this.context = context;
        this.sellerList = sellerList;
        this.onItemClickListener = onItemClickListener;
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
        holder.image.setImageBitmap(seller.getImageResource());
        holder.type.setText(seller.getService_type());
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onSellerClick(position);
            }
        });
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
            name = itemView.findViewById(R.id.seller_name_tv);
            type = itemView.findViewById(R.id.type);
        }
    }
    public interface OnItemClickListener {
        void onSellerClick(int position);
    }


}