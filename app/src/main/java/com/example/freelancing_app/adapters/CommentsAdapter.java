package com.example.freelancing_app.adapters;

// CommentsAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Comment;

import java.time.Instant;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {
    private List<Comment> commentList;
    private Context context;

    public CommentsAdapter(List<Comment> commentList, Context context) {
        this.commentList = commentList;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comments_view_only, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        holder.userName.setText(comment.getUserName());
        holder.commentText.setText(comment.getText());
        //holder.userPhoto.setImageResource(comment.getUserPhotoResId());

        // Set stars based on rating
        for (int i = 0; i < 5; i++) {
            int starResource = (i < comment.getRating()) ? R.drawable.yellow_star : R.drawable.grey_star;
            holder.stars[i].setImageResource(starResource);
        }
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView commentText;
        ImageView userPhoto;
        ImageView[] stars = new ImageView[5];

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.username_tv);
            commentText = itemView.findViewById(R.id.comment_tv);
            userPhoto = itemView.findViewById(R.id.image);
            stars[0] = itemView.findViewById(R.id.star1_iv);
            stars[1] = itemView.findViewById(R.id.star2_iv);
            stars[2] = itemView.findViewById(R.id.star3_iv);
            stars[3] = itemView.findViewById(R.id.star4_iv);
            stars[4] = itemView.findViewById(R.id.star5_iv);
        }
    }
}
