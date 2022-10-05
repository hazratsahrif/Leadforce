package com.example.leadforce.ui.more;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leadforce.R;
import com.example.leadforce.databinding.FragmentInfoBinding;
import com.example.leadforce.databinding.FragmentMoreBinding;

public class MoreFragment extends Fragment {
    FragmentMoreBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMoreBinding.inflate(inflater,container,false);
        return  binding.getRoot();
    }
}