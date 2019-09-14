package com.haerul.dicoding_made.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    
    private String title;
    private String description;
    private int banner;
    private int year;
    private float rating;

    Data(String title, String description, int banner, int year, float rating) {
        this.title = title;
        this.description = description;
        this.banner = banner;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public int getBanner() {
        return banner;
    }

    public int getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeInt(this.banner);
        dest.writeInt(this.year);
        dest.writeFloat(this.rating);
    }

    private Data(Parcel in) {
        title = in.readString();
        description = in.readString();
        banner = in.readInt();
        year = in.readInt();
        rating = in.readFloat();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
