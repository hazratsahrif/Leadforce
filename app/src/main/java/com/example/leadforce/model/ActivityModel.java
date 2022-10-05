package com.example.leadforce.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ActivityModel implements Parcelable {

   String serviceName;
   int serviceIcon;
   String date, time;
   String personName;
   int personIcon;
   String dealName;
   int dealIcon;
   String managerName;
   int managerIocn;
  public  ActivityModel(){}
    public ActivityModel(Parcel in) {
        serviceName = in.readString();
        serviceIcon = in.readInt();
        date = in.readString();
        time = in.readString();
        personName = in.readString();
        personIcon = in.readInt();
        dealName = in.readString();
        dealIcon = in.readInt();
        managerName = in.readString();
        managerIocn = in.readInt();
    }

    public static final Creator<ActivityModel> CREATOR = new Creator<ActivityModel>() {
        @Override
        public ActivityModel createFromParcel(Parcel in) {
            return new ActivityModel(in);
        }

        @Override
        public ActivityModel[] newArray(int size) {
            return new ActivityModel[size];
        }
    };

    public String getServiceName() {
        return serviceName;
    }

    public int getServiceIcon() {
        return serviceIcon;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPersonName() {
        return personName;
    }

    public int getPersonIcon() {
        return personIcon;
    }

    public String getDealName() {
        return dealName;
    }

    public int getDealIcon() {
        return dealIcon;
    }

    public String getManagerName() {
        return managerName;
    }

    public int getManagerIocn() {
        return managerIocn;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServiceIcon(int serviceIcon) {
        this.serviceIcon = serviceIcon;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPersonIcon(int personIcon) {
        this.personIcon = personIcon;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public void setDealIcon(int dealIcon) {
        this.dealIcon = dealIcon;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public void setManagerIocn(int managerIocn) {
        this.managerIocn = managerIocn;
    }

    @Override
    public String toString() {
        return "ActivityModel{" +
                "serviceName='" + serviceName + '\'' +
                ", serviceIcon=" + serviceIcon +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", personName='" + personName + '\'' +
                ", personIcon=" + personIcon +
                ", dealName='" + dealName + '\'' +
                ", dealIcon=" + dealIcon +
                ", managerName='" + managerName + '\'' +
                ", managerIocn=" + managerIocn +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(serviceName);
        parcel.writeInt(serviceIcon);
        parcel.writeString(date);
        parcel.writeString(time);
        parcel.writeString(personName);
        parcel.writeInt(personIcon);
        parcel.writeString(dealName);
        parcel.writeInt(dealIcon);
        parcel.writeString(managerName);
        parcel.writeInt(managerIocn);
    }
}
