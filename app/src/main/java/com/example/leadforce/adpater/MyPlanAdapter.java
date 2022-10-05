package com.example.leadforce.adpater;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leadforce.R;
import com.example.leadforce.databinding.CardLayoutBinding;
import com.example.leadforce.interfaces.CalendarClickInterface;
import com.example.leadforce.interfaces.CheckBoxListnerInterface;
import com.example.leadforce.interfaces.FragmentCallBack;
import com.example.leadforce.model.ActivityModel;
import com.example.leadforce.model.HomeModel;
import com.example.leadforce.ui.plan.PlanFragment;

import java.util.ArrayList;

public class MyPlanAdapter extends RecyclerView.Adapter<MyPlanAdapter.MyViewHolder> implements CalendarClickInterface {
     ArrayList<ActivityModel> arrayList;
     Context context;
     PlanFragment planFragment= new PlanFragment();
     CheckBoxListnerInterface checkBoxListnerInterface;
    int[][] states = new int[][] {
            new int[] { android.R.attr.state_enabled}, // enabled
            new int[] {-android.R.attr.state_enabled}, // disabled
            new int[] {-android.R.attr.state_checked}, // unchecked
            new int[] { android.R.attr.state_pressed}  // pressed
    };

    int[] colors = new int[] {
            Color.BLACK,
            Color.RED,
            Color.GREEN,
            Color.BLUE
    };
    ColorStateList myList = new ColorStateList(states, colors);


    public MyPlanAdapter(ArrayList<ActivityModel> arrayList, Context context, CheckBoxListnerInterface checkBoxListnerInterface) {
        this.arrayList = arrayList;
        this.context = context;
        this.checkBoxListnerInterface = checkBoxListnerInterface;

    }

    CardLayoutBinding binding;
    @NonNull
    @Override
    public MyPlanAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
//        ((PlanFragment) context.).setClickInterface(this);
        planFragment.setClickInterface(this);

        return new MyViewHolder(binding,checkBoxListnerInterface);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ActivityModel homeModel = arrayList.get(position);
        holder.cardLayoutBinding.checkbox.setText(homeModel.getServiceName());
        holder.cardLayoutBinding.time.setText(homeModel.getTime());
        holder.cardLayoutBinding.tvPerson.setText(homeModel.getPersonName());
        holder.cardLayoutBinding.tvManager.setText(homeModel.getManagerName());
        holder.cardLayoutBinding.tvDealer.setText(homeModel.getDealName());
        holder.cardLayoutBinding.checkbox.setCompoundDrawablesWithIntrinsicBounds(0,0, homeModel.getServiceIcon(),0);


        holder.cardLayoutBinding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
//                        ((BottomNav) context)./(this);
                if (isCheck){

//                    holder.cardLayoutBinding.checkbox.setTextColor(context.getResources().getColor(R.color.black_color));
                    holder.cardLayoutBinding.cardView.setBackground(context.getDrawable(R.drawable.card_background));
                    compoundButton.setButtonTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green_color)));
                }
                else {
                    holder.cardLayoutBinding.cardView.setBackground(null);
                    compoundButton.setButtonTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.blueColor)));

                }

                if(checkBoxListnerInterface!=null){
                    checkBoxListnerInterface.onCheckBoxClick(isCheck);

                }


            }
        });


        if(homeModel.isFlag()){

            holder.cardLayoutBinding.ivIcon.setVisibility(View.VISIBLE);
        }
        else{

            holder.cardLayoutBinding.ivIcon.setVisibility(View.GONE);
        }
    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onCalendarClick(boolean flag) {
        Toast.makeText(context, "lu", Toast.LENGTH_SHORT).show();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardLayoutBinding cardLayoutBinding;
        CheckBoxListnerInterface checkBoxListnerInterface;
        public MyViewHolder(@NonNull CardLayoutBinding binding, CheckBoxListnerInterface checkBoxListnerInterface) {
            super(binding.getRoot());
            cardLayoutBinding= binding;
            this.checkBoxListnerInterface=checkBoxListnerInterface;

        }
    }
}
