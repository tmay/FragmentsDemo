package com.detroitlabs.fragmentsdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Terry on 10/27/14.
 */
public class Queue implements Parcelable {
    public ArrayList<BroadsideItem> queue;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.queue);
    }

    public Queue() {
    }

    private Queue(Parcel in) {
        this.queue = (ArrayList<BroadsideItem>) in.readSerializable();
    }

    public static final Parcelable.Creator<Queue> CREATOR = new Parcelable.Creator<Queue>() {
        public Queue createFromParcel(Parcel source) {
            return new Queue(source);
        }

        public Queue[] newArray(int size) {
            return new Queue[size];
        }
    };
}
