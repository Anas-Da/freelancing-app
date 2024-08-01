package com.example.freelancing_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Profession;

import java.util.List;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder> {

    private Context context;
    private List<Profession> professionList;
    private OnItemClickListener onItemClickListener;
    public ProfessionAdapter(Context context, List<Profession> professionList,OnItemClickListener onItemClickListener) {
        this.context = context;
        this.professionList = professionList;
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public ProfessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.groups_view, parent, false);
        return new ProfessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionViewHolder holder, int position) {
        Profession profession = professionList.get(position);
        holder.textView.setText(profession.getName());
        holder.imageView.setImageResource(profession.getImageResource());
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onProfessionClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return professionList.size();
    }

    public static class ProfessionViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ProfessionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
    public interface OnItemClickListener {
        void onProfessionClick(int position);
    }
}