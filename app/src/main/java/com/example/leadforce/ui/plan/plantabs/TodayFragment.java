package com.example.leadforce.ui.plan.plantabs;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.leadforce.R;
import com.example.leadforce.adpater.MyPlanAdapter;
import com.example.leadforce.databinding.FragmentTodayBinding;
import com.example.leadforce.interfaces.CalendarClickInterface;
import com.example.leadforce.interfaces.CheckBoxListnerInterface;
import com.example.leadforce.interfaces.FragmentCallBack;
import com.example.leadforce.model.ActivityModel;
import com.example.leadforce.model.HomeModel;
import com.example.leadforce.model.ToggleEvent;
import com.example.leadforce.ui.addnewactivity.AddActivityFragment;
import com.example.leadforce.ui.plan.PlanFragment;
import com.example.leadforce.utils.Constants;
import com.example.leadforce.viewmodel.SharedViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;


public class TodayFragment extends Fragment implements CheckBoxListnerInterface {
    FragmentTodayBinding binding;
    ArrayList<ActivityModel> list;
    MyPlanAdapter adapter;
    FragmentCallBack callBack;
    private SharedViewModel viewModel;

    public TodayFragment(FragmentCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTodayBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

//        planFragment.setClickInterface(this);

//        planFragment=new PlanFragment(this);


        list = new ArrayList<>();


        list.add(new ActivityModel("Call", "12/2/200", "12:30 AM",
                getResources().getString(R.string.k_venkatakrishnan),
                getResources().getString(R.string.keertana_facility_management_service),
                getResources().getString(R.string.keertana_facility_management_service_deal),
                R.drawable.ic_call, false)
        );
        list.add(new ActivityModel("Mial", "12/2/200", "12:30 AM",
                getResources().getString(R.string.k_venkatakrishnan),
                getResources().getString(R.string.keertana_facility_management_service),
                getResources().getString(R.string.keertana_facility_management_service_deal),
                R.drawable.mail, false)
        );
        list.add(new ActivityModel("Task", "12/2/200", "12:30 AM",
                getResources().getString(R.string.k_venkatakrishnan),
                getResources().getString(R.string.keertana_facility_management_service),
                getResources().getString(R.string.keertana_facility_management_service_deal),
                R.drawable.clock, false)
        );
        list.add(new ActivityModel("Direct", "12/2/200", "12:30 AM",
                getResources().getString(R.string.k_venkatakrishnan),
                getResources().getString(R.string.keertana_facility_management_service),
                getResources().getString(R.string.keertana_facility_management_service_deal),
                R.drawable.visit, false)
        );


//        adapter.setCheckBoxListnerInterface(this);
        adapter = new MyPlanAdapter(list, getContext(), this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

        viewModel.getActivityModelMutableLiveData().observe(getViewLifecycleOwner(), (ActivityModel activityModel) -> {
            Log.d(Constants.TAG, "onCreateView: " + activityModel.toString());
            list.add(new ActivityModel(
                    activityModel.getServiceName(),
                    activityModel.getDate(),
                    activityModel.getTime(),
                    activityModel.getPersonName(),
                    activityModel.getManagerName(),
                    activityModel.getDealName(),
                    R.drawable.clock,
                    activityModel.isFlag()
            ));
            adapter.notifyDataSetChanged();
            Toast.makeText(requireContext(), activityModel.toString(), Toast.LENGTH_SHORT).show();

        });

        viewModel.getCalToggle().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                toggleItem(aBoolean);
            }
        });
    }

    private void toggleItem(Boolean aBoolean) {
        for (ActivityModel activityModel : list) {
            activityModel.setFlag(aBoolean);
        }
        adapter.notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToggleEvent event) {
//        Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
        toggleItem(event.value);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onCheckBoxClick(boolean isCheck) {
        if (callBack != null) {
            callBack.onClick(isCheck);
        }

    }


}