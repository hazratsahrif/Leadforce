package com.example.leadforce.ui.auth;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.leadforce.R;
import com.example.leadforce.databinding.FragmentChangePasswordBinding;

public class ChangePassword extends Fragment {

    FragmentChangePasswordBinding binding;
    boolean isPassword =true;
    boolean isHidePassword =false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentChangePasswordBinding.inflate(inflater,container,false);
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitle("");
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });
        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_changePassword_to_signUpFragment2
                );
            }
        });


        binding.btnHide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isHidePassword==false){

                    isHidePassword=true;
                    binding.btnHide2.setImageResource(R.drawable.hide_eye);
                    binding.etPassword2.setTransformationMethod(new PasswordTransformationMethod());

                }
                else {
                    binding.btnHide2.setImageResource(R.drawable.open_eye);
                    binding.etPassword2.setTransformationMethod(null);
                    isHidePassword=false;
                }

            }
        });
        binding.btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPassword==true){

                    isPassword=false;
                    binding.btnHide.setImageResource(R.drawable.hide_eye);
                    binding.etPassword.setTransformationMethod(new PasswordTransformationMethod());

                }
                else {
                    binding.btnHide.setImageResource(R.drawable.open_eye);
                    binding.etPassword.setTransformationMethod(null);
                    isPassword=true;
                }

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