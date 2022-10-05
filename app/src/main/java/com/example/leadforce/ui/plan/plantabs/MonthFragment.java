package com.example.leadforce.ui.plan.plantabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.leadforce.databinding.FragmentMonthBinding;

public class MonthFragment extends Fragment {
    FragmentMonthBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentMonthBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        return view;
    }
}