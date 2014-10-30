package com.detroitlabs.fragmentsdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Terry on 10/27/14.
 */
public class BroadsideItem implements Parcelable {
    public String id;
    public String url;
    public String gravatar;
    public String email;
    public String fitScreen;
    public String timeCreated;
    public String moduleType;
    public int timeToLive;
    public int viewCount;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.url);
        dest.writeString(this.gravatar);
        dest.writeString(this.email);
        dest.writeString(this.fitScreen);
        dest.writeString(this.timeCreated);
        dest.writeString(this.moduleType);
        dest.writeInt(this.timeToLive);
        dest.writeInt(this.viewCount);
    }

    public BroadsideItem() {
    }

    private BroadsideItem(Parcel in) {
        this.id = in.readString();
        this.url = in.readString();
        this.gravatar = in.readString();
        this.email = in.readString();
        this.fitScreen = in.readString();
        this.timeCreated = in.readString();
        this.moduleType = in.readString();
        this.timeToLive = in.readInt();
        this.viewCount = in.readInt();
    }

    public static final Parcelable.Creator<BroadsideItem> CREATOR = new Parcelable.Creator<BroadsideItem>() {
        public BroadsideItem createFromParcel(Parcel source) {
            return new BroadsideItem(source);
        }

        public BroadsideItem[] newArray(int size) {
            return new BroadsideItem[size];
        }
    };
}
