package com.example.leadforce.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ActivityModel implements Serializable {

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
    private int serviceIcon;

    private boolean isFlag;


    public ActivityModel() {
      ;
    }

    public ActivityModel(String serviceName, String date, String time, String personName, String dealName, String managerName, int serviceIcon, boolean isFlag) {
        this.serviceName = serviceName;
        this.date = date;
        this.time = time;
        this.personName = personName;
        this.dealName = dealName;
        this.managerName = managerName;
        this.serviceIcon = serviceIcon;
        this.isFlag = isFlag;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getServiceIcon() {
        return serviceIcon;
    }

    public void setServiceIcon(int serviceIcon) {
        this.serviceIcon = serviceIcon;
    }
}
