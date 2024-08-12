package com.example.freelancing_app.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.service.CustomerNotificationsService;
import com.example.freelancing_app.models.NotificationItem;

import java.util.ArrayList;
import java.util.List;
//todo check
//
public class NotificationsServiceProvider extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    NotificationAdapter adapter;
    List<NotificationItem> notificationList;
    ImageButton back_b;
    ImageButton account_ib;
    ImageButton home_ib;
    ImageButton chat_ib;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_service_provider);


        account_ib = findViewById(R.id.account_ib);
        home_ib = findViewById(R.id.home_ib);
        chat_ib = findViewById(R.id.chat_ib);
        back_b = findViewById(R.id.back_b);
        account_ib.setOnClickListener(this);
        home_ib.setOnClickListener(this);
        chat_ib.setOnClickListener(this);
        back_b.setOnClickListener(this);

         recyclerView= findViewById(R.id.notifications_li);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notificationList = new ArrayList<>();

        Bitmap AA = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_6);
        Bitmap DD = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_1);
        notificationList.add(new NotificationItem("Ahmad Shamma", AA));
        notificationList.add(new NotificationItem("Anas Da", DD));

        adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.account_ib) {
            Intent i = new Intent(NotificationsServiceProvider.this, AccountServiceProvider.class);
            startActivity(i);
        } else if (v.getId() == R.id.home_ib) {
            Intent i = new Intent(NotificationsServiceProvider.this, Home.class);
        } else if (v.getId() == R.id.chat_ib) {
            Intent i = new Intent(NotificationsServiceProvider.this, ChatList.class);
            startActivity(i);
        } else if (v.getId() == R.id.back_b) {
            finish();
        }

    }
    public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

        private final List<NotificationItem> notificationList;

        public NotificationAdapter(List<NotificationItem> notificationList) {
            this.notificationList = notificationList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_service_provider, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            NotificationItem item = notificationList.get(position);
            holder.personName.setText(item.getPersonName());
            holder.photo.setImageBitmap(item.getPhotoResId());

            holder.acceptButton.setOnClickListener(v -> {
                Toast.makeText(NotificationsServiceProvider.this, "Accepted", Toast.LENGTH_SHORT).show();

                // Start service to notify the customer
                Intent serviceIntent = new Intent(NotificationsServiceProvider.this, CustomerNotificationsService.class);
                startService(serviceIntent);
            });

            holder.denyButton.setOnClickListener(v -> {
                Toast.makeText(NotificationsServiceProvider.this, "Denied", Toast.LENGTH_SHORT).show();
            });
        }

        @Override
        public int getItemCount() {
            return notificationList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder  {

            ImageView photo;
            TextView personName;
            ImageButton acceptButton;
            ImageButton denyButton;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                photo = itemView.findViewById(R.id.photo_iv);
                personName = itemView.findViewById(R.id.person_name_tv);
                acceptButton = itemView.findViewById(R.id.accept_b);
                denyButton = itemView.findViewById(R.id.deny_b);
            }
        }
    }
}

