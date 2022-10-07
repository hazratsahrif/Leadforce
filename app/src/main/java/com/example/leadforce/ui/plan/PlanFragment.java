package com.example.leadforce.ui.plan;


import android.content.res.ColorStateList;
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

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.example.leadforce.MainActivity;
import com.example.leadforce.R;
import com.example.leadforce.databinding.FragmentPlanBinding;
import com.example.leadforce.interfaces.CalendarClickInterface;
import com.example.leadforce.interfaces.FragmentCallBack;
import com.example.leadforce.model.ActivityModel;
import com.example.leadforce.ui.plan.plantabs.TodayFragment;
import com.example.leadforce.viewmodel.SharedViewModel;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.tabs.TabLayout;


public class PlanFragment extends Fragment implements FragmentCallBack, View.OnClickListener {


    public PlanFragment() {
    }


    private SharedViewModel viewModel;

    FragmentPlanBinding binding;
    TodayFragment todayFragment;
    CalendarClickInterface clickInterface;
    boolean toggle = false;
    int count = 0;

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
        PlanViewPagerAdapter adapter = new PlanViewPagerAdapter(fragmentManager, getLifecycle(), this);
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
                gotoActivityFragmnet(view);
            }
        });
        binding.btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle = !toggle;
                if(toggle){
                    binding.cvCal.setCardBackgroundColor(getResources().getColor(R.color.blueColor));
                    binding.btnCal.setColorFilter(getResources().getColor(R.color.white));
                }
                else {
                    binding.cvCal.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.btnCal.setColorFilter(getResources().getColor(R.color.black_color));
                }
//                EventBus.getDefault().post(new ToggleEvent(toggle));
                viewModel.toggleCal();

//                if (clickInterface != null) {
//                    Toast.makeText(getContext(), "not null", Toast.LENGTH_SHORT).show();
//                    clickInterface.onCalendarClick(true);
//                }
            }
        });


        binding.fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {

                } else {
                }
            }
        });

        //handling each floating action button clicked
        binding.fab1.setOnClickListener(this);
        binding.fab2.setOnClickListener(this);
        binding.fab3.setOnClickListener(this);
        binding.fab4.setOnClickListener(this);


        binding.fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.fam.isOpened()) {
                    binding.fam.close(true);
                }
            }
        });

//
//    private View.OnClickListener onButtonClick() {
//        return new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//        };
//    }


        return root;
    }

    private void gotoActivityFragmnet(View view) {
        ActivityModel model = new ActivityModel();
        PlanFragmentDirections.ActionNavigationPlanToAddActivityFragment action =
                PlanFragmentDirections.actionNavigationPlanToAddActivityFragment(model);
        Navigation.findNavController(view).navigate(action);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), item -> {
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

        if (isCheck == true) {
            count++;
            binding.tvActivityCount.setVisibility(View.VISIBLE);
            binding.tvActivityCount.setText(String.valueOf(count) + " /");
        } else {
            count--;
            binding.tvActivityCount.setVisibility(View.VISIBLE);
            binding.tvActivityCount.setText(String.valueOf(count) + " /");
            if (count == 0) {
                binding.tvActivityCount.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onAdapterListener(ActivityModel activityModel) {

       PlanFragmentDirections.ActionNavigationPlanToAddActivityFragment action= PlanFragmentDirections.actionNavigationPlanToAddActivityFragment(activityModel);
       Navigation.findNavController(getView()).navigate(action);


    }

    @Override
    public void onClick(View view) {
        if (view == binding.fab1) {
            gotoActivityFragmnet(view);

        } else if (view == binding.fab2) {
            //do nothing
        } else  if (view == binding.fab3){
            //do nothing
        }
        else {
            //do nothing
        }
        binding.fam.close(true);

    }
}