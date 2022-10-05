package com.example.leadforce.ui.auth;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.leadforce.R;
import com.example.leadforce.databinding.FragmentForgotPasswordBinding;

public class ForgotPasswordFragment extends Fragment {
    FragmentForgotPasswordBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentForgotPasswordBinding.inflate(inflater,container,false);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbar);
        binding.toolbar.setTitle("");
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });


        View view = binding.getRoot();

   binding.etEmail.addTextChangedListener(new TextWatcher() {

       public void afterTextChanged(Editable s) {
       }

       public void beforeTextChanged(CharSequence s, int start,
                                     int count, int after) {

       }

       public void onTextChanged(CharSequence s, int start,
                                 int before, int count) {


//           binding.etEmail.setError("Email does not exist",Drawable.createFromPath(""));

       }
   });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            Navigation.findNavController(view).navigate(R.id.action_forgotPasswordFragment3_to_resetPassword);

                }

        });

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbar);    }

}