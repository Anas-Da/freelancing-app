package com.example.freelancing_app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.SearchResults;
import com.example.freelancing_app.utils.GlobalVariables;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<SearchResults.User> userList;
    GlobalVariables globalVariables;

    public UserAdapter(List<SearchResults.User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        SearchResults.User user = userList.get(position);
        holder.fullnameTv.setText(globalVariables.getFullname());
        holder.usernameTv.setText(globalVariables.getUsername());
        holder.workGroupTv.setText(globalVariables.getWorkGroup());
        holder.rateTv.setText(String.valueOf(globalVariables.getRate()));
        // If you have an image loader, you can load the image here
        // Example: Glide.with(holder.image.getContext()).load(user.getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView fullnameTv, usernameTv, workGroupTv, rateTv;
        // Uncomment and import if you use Glide or similar libraries for image loading
        // CircleImageView image;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            fullnameTv = itemView.findViewById(R.id.fullname_tv);
            usernameTv = itemView.findViewById(R.id.username_tv);
            workGroupTv = itemView.findViewById(R.id.work_group_tv);
            rateTv = itemView.findViewById(R.id.rate_tv);
            // image = itemView.findViewById(R.id.image); // Uncomment if you have images to display
        }
    }
}
