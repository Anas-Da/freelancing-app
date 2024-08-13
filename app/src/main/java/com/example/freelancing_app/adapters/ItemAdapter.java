package com.example.freelancing_app.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> itemList;
    private Context context;

    private int selectedPosition = -1;

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.groups_view_big, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,  int position) {
        Item item = itemList.get(position);
        holder.textView.setText(item.getName());
        holder.imageView.setImageResource(item.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            if (selectedPosition == position) {
                return;
            }

            if (selectedPosition != -1) {
                Toast.makeText(context, "You can only select one item!", Toast.LENGTH_SHORT).show();
            }

            selectedPosition = position;
            notifyDataSetChanged();
        });

        holder.itemView.setBackgroundColor(selectedPosition == position ?
                context.getResources().getColor(android.R.color.holo_blue_light) :
                context.getResources().getColor(android.R.color.transparent));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}