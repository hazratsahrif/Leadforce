package com.example.leadforce.ui.plan.plantabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.leadforce.R;
import com.example.leadforce.adpater.MyPlanAdapter;
import com.example.leadforce.databinding.FragmentTodayBinding;
import com.example.leadforce.interfaces.CalendarClickInterface;
import com.example.leadforce.interfaces.CheckBoxListnerInterface;
import com.example.leadforce.interfaces.FragmentCallBack;
import com.example.leadforce.model.HomeModel;
import com.example.leadforce.ui.addnewactivity.AddActivityFragment;
import com.example.leadforce.ui.plan.PlanFragment;

import java.util.ArrayList;


public class TodayFragment extends Fragment implements CheckBoxListnerInterface {
    FragmentTodayBinding binding;
    ArrayList<HomeModel> list;
    MyPlanAdapter adapter;
    FragmentCallBack callBack;
    public TodayFragment(FragmentCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentTodayBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

//        planFragment.setClickInterface(this);

//        planFragment=new PlanFragment(this);


        list=new ArrayList<>();

        list.add(new HomeModel("Call","04:30 P.M",R.drawable.ic_call,false));
        list.add(new HomeModel("Email","11:30 P.M",R.drawable.mail,false));
        list.add(new HomeModel("Task","04:30 P.M",R.drawable.time_fast,false));
        list.add(new HomeModel("Direct","04:30 P.M",R.drawable.visit,false));
//        adapter.setCheckBoxListnerInterface(this);
        adapter = new MyPlanAdapter(list,getContext(),this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);


        return view;
    }


    @Override
    public void onCheckBoxClick(boolean isCheck) {
    if(callBack!=null){
        callBack.onClick(isCheck);
    }

    }


}