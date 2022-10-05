package com.example.leadforce.model;

public class HomeModel {

    String checkBoxTitle, time;
    int checkBoxIcon;
    boolean flag;

    public String getCheckBoxTitle() {
        return checkBoxTitle;
    }

    public void setCheckBoxTitle(String checkBoxTitle) {
        this.checkBoxTitle = checkBoxTitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCheckBoxIcon() {
        return checkBoxIcon;
    }

    public void setCheckBoxIcon(int checkBoxIcon) {
        this.checkBoxIcon = checkBoxIcon;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public HomeModel(String checkBoxTitle, String time, int checkBoxIcon, boolean flag) {
        this.checkBoxTitle = checkBoxTitle;
        this.time = time;
        this.checkBoxIcon = checkBoxIcon;
        this.flag = flag;
    }

    public ActivityModel toActivityModel(){
        return  new ActivityModel()
    }
}
