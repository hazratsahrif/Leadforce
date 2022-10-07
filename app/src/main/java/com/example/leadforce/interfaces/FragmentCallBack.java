package com.example.leadforce.interfaces;

import com.example.leadforce.model.ActivityModel;

public interface FragmentCallBack {
    void onClick(boolean isCheck);
    void onAdapterListener(ActivityModel activityModel);
}
