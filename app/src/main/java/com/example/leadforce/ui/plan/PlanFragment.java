package com.example.leadforce.ui.plan;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.leadforce.R;
import com.example.leadforce.databinding.FragmentPlanBinding;
import com.example.leadforce.interfaces.CalendarClickInterface;
import com.example.leadforce.interfaces.FragmentCallBack;
import com.example.leadforce.model.ActivityModel;
import com.example.leadforce.model.SharedModel;
import com.example.leadforce.ui.addnewactivity.AddActivityFragment;
import com.example.leadforce.ui.plan.plantabs.TodayFragment;
import com.google.android.material.tabs.TabLayout;

public class PlanFragment extends Fragment implements FragmentCallBack {


   public PlanFragment(){};
   private SharedModel model;

    private FragmentPlanBinding binding;
    TodayFragment todayFragment;
    CalendarClickInterface clickInterface;

    int count=0;

    public PlanFragment setClickInterface(CalendarClickInterface clickInterface) {
        this.clickInterface = clickInterface;
        return this;

    }

//    @Override
//    public void onAttach(Context context) {
//        if(Build.VERSION.SDK_INT >=23){
//
//        super.onAttach(context);
//        if (context instanceof CalendarClickInterface) {
//            clickInterface = (CalendarClickInterface) context;
//        } else {
//            throw new RuntimeException(
//                    " must implemenet MyListFragment.OnItemSelectedListener");
//        }
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        clickInterface = null;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlanBinding.inflate(inflater, container, false);
        todayFragment = new TodayFragment(this);
        View root = binding.getRoot();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        PlanViewPagerAdapter adapter = new PlanViewPagerAdapter(fragmentManager , getLifecycle(),this);
        ViewPager2 viewPager = binding.viewPager;
        viewPager.setAdapter(adapter);

        TabLayout tabs = binding.tabLayout;
        tabs.addTab(tabs.newTab().setText("Today"));
        tabs.addTab(tabs.newTab().setText("Tomorrow"));
        tabs.addTab(tabs.newTab().setText("Jun 23, 2022"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabs.selectTab(tabs.getTabAt(position));
            }
        });

        binding.etSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View arg0, boolean hasfocus) {
                if (hasfocus) {

                    Toast.makeText(getContext(), "shared model"+model.getText(), Toast.LENGTH_SHORT).show();
                    Log.e("TAG", "e1 focused");
                    binding.editTextBackgroud.setBackgroundResource(R.drawable.blue_rounded_dashes);
                } else {
                    binding.editTextBackgroud.setBackgroundResource(R.drawable.rounded_dashes);

                }
            }
        });
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_plan_to_addActivityFragment);
            }
        });
//        binding.btnCal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                if(clickInterface!=null){
//                    Toast.makeText(getContext(), "not null", Toast.LENGTH_SHORT).show();
//                    clickInterface.onCalendarClick(true);
//                }
//            }
//        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireParentFragment())
                .get(SharedModel.class);
        model.getText().observe(getActivity(), item->{
             binding.tvAct.setText(item);
        });
        
    }
//
//
//        @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
////        if(getArguments() != null){
////            PlanFragmentArgs planFragment =  PlanFragmentArgs.fromBundle(getArguments());
////            ActivityModel model = planFragment.getModel();
////            Log.i("TAG","user data "+ model.toString());
////        }
////        else {
////            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
////        }
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(boolean isCheck) {
        if(isCheck==true){
            count++;
            binding.tvActivityCount.setVisibility(View.VISIBLE);
            binding.tvActivityCount.setText(String.valueOf(count)+" /");
        }
        else{
            count--;
            binding.tvActivityCount.setVisibility(View.VISIBLE);
            binding.tvActivityCount.setText(String.valueOf(count)+" /");
            if(count==0){
                binding.tvActivityCount.setVisibility(View.GONE);
            }
        }
    }

}