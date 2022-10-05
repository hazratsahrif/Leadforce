package com.example.leadforce.model;

import android.text.style.CharacterStyle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedModel extends ViewModel {
    private MutableLiveData<String> text = new MutableLiveData<>();
    private MutableLiveData<Integer> isCheck = new MutableLiveData<>();

    public MutableLiveData<Integer> getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(MutableLiveData<Integer> isCheck) {
        this.isCheck = isCheck;
    }

    public  void setText(String input){
        text.setValue(input);
    }
    public LiveData<String > getText(){
        return text;
    }
}
