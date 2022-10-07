package com.example.leadforce.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.leadforce.model.ActivityModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> text = new MutableLiveData<>();
    private MutableLiveData<Integer> isCheck = new MutableLiveData<>();

    private MutableLiveData<Boolean> calToggle = new MutableLiveData<Boolean>(false);

    private MutableLiveData<ActivityModel> activityModelMutableLiveData = new MutableLiveData<>();


    private MutableLiveData<Integer> position = new MutableLiveData<>(0);

    public LiveData<Integer> getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.setPosition(position);
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

    public LiveData<Boolean> getCalToggle() {
        return calToggle;
    }

    public void toggleCal() {
        this.calToggle.setValue(Boolean.FALSE.equals(calToggle.getValue()));
    }
}
