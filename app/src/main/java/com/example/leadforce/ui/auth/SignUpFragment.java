package com.example.leadforce.ui.auth;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import com.example.leadforce.MainActivity;
import com.example.leadforce.R;
import com.example.leadforce.databinding.SignupFragmentBinding;


public class SignUpFragment extends Fragment {

  SignupFragmentBinding binding;
  boolean isPassword=true;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SignupFragmentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();



       binding.tvPassword.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

             Navigation.findNavController(view).navigate(R.id.action_signUpFragment2_to_forgotPasswordFragment3);
           }
       });

        binding.btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), MainActivity.class));
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
        return view;
    }

}