package com.example.leadforce.ui.plan.plantabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.example.leadforce.databinding.FragmentTomorrowBinding;

public class TomorrowFragment extends Fragment {
    FragmentTomorrowBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentTomorrowBinding.inflate(inflater,container,false);

        View view = binding.getRoot();

        return view;
    }

}