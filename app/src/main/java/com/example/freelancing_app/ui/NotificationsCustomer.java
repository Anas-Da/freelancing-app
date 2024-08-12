package com.example.freelancing_app.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.NotificationItem;

import java.util.ArrayList;
import java.util.List;

public class NotificationsCustomer extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<NotificationItem> notificationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_customer);

        recyclerView = findViewById(R.id.notifications_li);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notificationList = new ArrayList<>();
        // Add some dummy data
        //notificationList.add(new NotificationItem("Service Approved", R.drawable.account_img_small));

        adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        Bitmap LL = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_5);
        Bitmap SS = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_3);
        notificationList.add(new NotificationItem("Lina Al_Rashid", LL));

        notificationList.add(new NotificationItem("Sdra Al_Kusaier", SS));
    }

    public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

        private final List<NotificationItem> notificationList;

        public NotificationAdapter(List<NotificationItem> notificationList) {
            this.notificationList = notificationList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_customer, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            NotificationItem item = notificationList.get(position);
            holder.personName.setText(item.getPersonName());
            holder.photo.setImageBitmap(item.getPhotoResId());
        }

        @Override
        public int getItemCount() {
            return notificationList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView photo;
            TextView personName;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                photo = itemView.findViewById(R.id.photo_iv);
                personName = itemView.findViewById(R.id.person_name_tv);
            }
        }
    }
}
