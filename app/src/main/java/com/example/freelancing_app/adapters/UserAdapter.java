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

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private ArrayList<SearchResults.User> userList;
    GlobalVariables globalVariables;

    public UserAdapter(ArrayList<SearchResults.User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_result_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        SearchResults.User user = userList.get(position);

        // Set user data to the views
        holder.fullname_tv.setText(user.getFirstName() + " " + user.getSecondName() );
        holder.workGroup_tv.setText(user.getWorkGroup());
        holder.rate_tv.setText(String.valueOf(user.getRate()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView fullname_tv, workGroup_tv, rate_tv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname_tv = itemView.findViewById(R.id.fullname_tv);
            workGroup_tv = itemView.findViewById(R.id.work_group_tv);
            rate_tv = itemView.findViewById(R.id.rate_tv);
        }
    }
}
