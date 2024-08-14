package com.example.freelancing_app.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class SearchResults {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static class User implements Parcelable {
        private String username;
        private String firstName;
        private String secondName;
        private String workGroup;
        private String providedServices;
        private float rate;
        private boolean active;

        // Constructor, Getters, Setters

        protected User(Parcel in) {
            username = in.readString();
            firstName = in.readString();
            secondName = in.readString();
            workGroup = in.readString();
            providedServices = in.readString();
            rate = in.readFloat();
            active = in.readByte() != 0;
        }

        public static final Creator<User> CREATOR = new Creator<User>() {
            @Override
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            @Override
            public User[] newArray(int size) {
                return new User[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(username);
            dest.writeString(firstName);
            dest.writeString(secondName);
            dest.writeString(workGroup);
            dest.writeString(providedServices);
            dest.writeFloat(rate);
            dest.writeByte((byte) (active ? 1 : 0));
        }
    }
}
