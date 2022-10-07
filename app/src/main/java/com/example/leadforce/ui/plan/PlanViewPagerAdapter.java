package com.example.leadforce.ui.plan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.leadforce.interfaces.FragmentCallBack;
import com.example.leadforce.ui.plan.plantabs.MonthFragment;
import com.example.leadforce.ui.plan.plantabs.TodayFragment;
import com.example.leadforce.ui.plan.plantabs.TomorrowFragment;

public class PlanViewPagerAdapter extends FragmentStateAdapter {


    FragmentCallBack mContext;
    public PlanViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, FragmentCallBack context) {
        super(fragmentManager, lifecycle);
        mContext=context;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {


        if (position==0){
            return new TodayFragment(mContext);
        }
        else if(position==1){
            return new TomorrowFragment(mContext);

        }
        return new MonthFragment(mContext);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}