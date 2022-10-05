package com.example.leadforce.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.leadforce.model.ActivityModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> text = new MutableLiveData<>();
    private MutableLiveData<Integer> isCheck = new MutableLiveData<>();

    private MutableLiveData<ActivityModel> activityModelMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<Integer> getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(MutableLiveData<Integer> isCheck) {
        this.isCheck = isCheck;
    }

    public void setText(String input) {
        text.setValue(input);
    }

    public LiveData<ActivityModel> getActivityModelMutableLiveData() {
        return activityModelMutableLiveData;
    }

    public void setActivityModelMutableLiveData(ActivityModel activityModel) {
        this.activityModelMutableLiveData.setValue(activityModel);
    }

    public LiveData<String> getText() {
        return text;
    }
}
