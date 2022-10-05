package com.example.leadforce.ui.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leadforce.R;
import com.example.leadforce.databinding.FragmentInfoBinding;


public class InfoFragment extends Fragment {
    FragmentInfoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(inflater,container,false);
        return  binding.getRoot();
    }
}