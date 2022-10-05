package com.example.leadforce.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ActivityModel implements Parcelable {

    private String serviceName;
    //    private int serviceIcon;
    private String date,
            time;
    private String personName;
    //    private int personIcon;
    private String dealName;
    //    private int dealIcon;
    private String managerName;
//    private int managerIocn;

    public ActivityModel() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public ActivityModel setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getDate() {
        return date;
    }

    public ActivityModel setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public ActivityModel setTime(String time) {
        this.time = time;
        return this;
    }

    public String getPersonName() {
        return personName;
    }

    public ActivityModel setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public String getDealName() {
        return dealName;
    }

    public ActivityModel setDealName(String dealName) {
        this.dealName = dealName;
        return this;
    }

    public String getManagerName() {
        return managerName;
    }

    public ActivityModel setManagerName(String managerName) {
        this.managerName = managerName;
        return this;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.serviceName);
        dest.writeString(this.date);
        dest.writeString(this.time);
        dest.writeString(this.personName);
        dest.writeString(this.dealName);
        dest.writeString(this.managerName);
    }

    public void readFromParcel(Parcel source) {
        this.serviceName = source.readString();
        this.date = source.readString();
        this.time = source.readString();
        this.personName = source.readString();
        this.dealName = source.readString();
        this.managerName = source.readString();
    }

    protected ActivityModel(Parcel in) {
        this.serviceName = in.readString();
        this.date = in.readString();
        this.time = in.readString();
        this.personName = in.readString();
        this.dealName = in.readString();
        this.managerName = in.readString();
    }

    public static final Creator<ActivityModel> CREATOR = new Creator<ActivityModel>() {
        @Override
        public ActivityModel createFromParcel(Parcel source) {
            return new ActivityModel(source);
        }

        @Override
        public ActivityModel[] newArray(int size) {
            return new ActivityModel[size];
        }
    };
}
