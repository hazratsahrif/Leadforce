package com.example.leadforce.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ActivityModelV2 implements Parcelable {

    String serviceName;
    int serviceIcon;
    String date, time;
    String personName;
    int personIcon;
    String dealName;
    int dealIcon;
    String managerName;
    int managerIocn;

    public ActivityModelV2() {
    }





    public String getServiceName() {
        return serviceName;
    }

    public ActivityModelV2 setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public int getServiceIcon() {
        return serviceIcon;
    }

    public ActivityModelV2 setServiceIcon(int serviceIcon) {
        this.serviceIcon = serviceIcon;
        return this;
    }

    public String getDate() {
        return date;
    }

    public ActivityModelV2 setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public ActivityModelV2 setTime(String time) {
        this.time = time;
        return this;
    }

    public String getPersonName() {
        return personName;
    }

    public ActivityModelV2 setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public int getPersonIcon() {
        return personIcon;
    }

    public ActivityModelV2 setPersonIcon(int personIcon) {
        this.personIcon = personIcon;
        return this;
    }

    public String getDealName() {
        return dealName;
    }

    public ActivityModelV2 setDealName(String dealName) {
        this.dealName = dealName;
        return this;
    }

    public int getDealIcon() {
        return dealIcon;
    }

    public ActivityModelV2 setDealIcon(int dealIcon) {
        this.dealIcon = dealIcon;
        return this;
    }

    public String getManagerName() {
        return managerName;
    }

    public ActivityModelV2 setManagerName(String managerName) {
        this.managerName = managerName;
        return this;
    }

    public int getManagerIocn() {
        return managerIocn;
    }

    public ActivityModelV2 setManagerIocn(int managerIocn) {
        this.managerIocn = managerIocn;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.serviceName);
        dest.writeInt(this.serviceIcon);
        dest.writeString(this.date);
        dest.writeString(this.time);
        dest.writeString(this.personName);
        dest.writeInt(this.personIcon);
        dest.writeString(this.dealName);
        dest.writeInt(this.dealIcon);
        dest.writeString(this.managerName);
        dest.writeInt(this.managerIocn);
    }

    public void readFromParcel(Parcel source) {
        this.serviceName = source.readString();
        this.serviceIcon = source.readInt();
        this.date = source.readString();
        this.time = source.readString();
        this.personName = source.readString();
        this.personIcon = source.readInt();
        this.dealName = source.readString();
        this.dealIcon = source.readInt();
        this.managerName = source.readString();
        this.managerIocn = source.readInt();
    }

    protected ActivityModelV2(Parcel in) {
        this.serviceName = in.readString();
        this.serviceIcon = in.readInt();
        this.date = in.readString();
        this.time = in.readString();
        this.personName = in.readString();
        this.personIcon = in.readInt();
        this.dealName = in.readString();
        this.dealIcon = in.readInt();
        this.managerName = in.readString();
        this.managerIocn = in.readInt();
    }

    public static final Creator<ActivityModelV2> CREATOR = new Creator<ActivityModelV2>() {
        @Override
        public ActivityModelV2 createFromParcel(Parcel source) {
            return new ActivityModelV2(source);
        }

        @Override
        public ActivityModelV2[] newArray(int size) {
            return new ActivityModelV2[size];
        }
    };
}
