package com.android.androidonkotlin;

import android.os.Parcel;
import android.os.Parcelable;

public class JavaCounter implements Parcelable {

    private final String name;
    private int counter = 0;

    public JavaCounter(String name, int startCounter) {
        this.name = name;
        counter = startCounter;
    }

    protected JavaCounter(Parcel in) {
        counter = in.readInt ();
        name = in.readString ();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt ( counter );
        dest.writeString ( name );
    }

    public static final Creator<JavaCounter> CREATOR = new Creator<JavaCounter> () {
        @Override
        public JavaCounter createFromParcel(Parcel in) {
            return new JavaCounter ( in );
        }

        @Override
        public JavaCounter[] newArray(int size) {
            return new JavaCounter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }
}