package com.example.leadforce.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.leadforce.R;
import com.example.leadforce.databinding.FragmentResetPasswordBinding;

public class ResetPassword extends Fragment {
    FragmentResetPasswordBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding= FragmentResetPasswordBinding.inflate(inflater,container,false);
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitle("");
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });
       binding.btnResend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Navigation.findNavController(view).navigate(
                       R.id.action_resetPassword_to_changePassword
               );
           }
       });
       return binding.getRoot();
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
}