package com.example.leadforce.ui.addnewactivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.leadforce.MainActivity;
import com.example.leadforce.R;

import com.example.leadforce.databinding.FragmentAddActivityBinding;
import com.example.leadforce.model.ActivityModel;
import com.example.leadforce.model.SharedModel;
import com.example.leadforce.ui.addnewactivity.invertory.Data;
import com.example.leadforce.ui.addnewactivity.invertory.ItemModel;
import com.example.leadforce.viewmodel.SharedViewModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class AddActivityFragment extends Fragment {
    FragmentAddActivityBinding binding;
    SharedViewModel viewModel;

    private Spinner spinner;
    private SpinnerAdapter adapter;
    DatePickerDialog datePickerDialog;
    ActivityModel model;
    String date = "";
    String time = "";
    String[] list = new String[]{
            "Priority 1",
            "Priority 2",
            "Priority 3",
            "Priority 4",

    };

    String[] list2 = new String[]{
            "Raj Kumar",
            "Ramesh",
            "Arjun",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddActivityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        spinner = binding.spinner;
        adapter = new SpinnerAdapter(getContext(), Data.getItem());
        spinner.setAdapter(adapter);
        model = new ActivityModel();


        setSpinnerAdapter(list, binding.spinnerPriority);
        setSpinnerAdapter(list2, binding.spinnerJobAssign);


        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        model.setServiceIcon(Data.getItem().get(position).getIcon());
                        model.setServiceName(Data.getItem().get(position).getName());
                        break;
                    case 1:
                        model.setServiceIcon(Data.getItem().get(position).getIcon());
                        model.setServiceName(Data.getItem().get(position).getName());
                        break;
                    case 2:
                        model.setServiceIcon(Data.getItem().get(position).getIcon());
                        model.setServiceName(Data.getItem().get(position).getName());
                        break;

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.btnDate.getText().toString().isEmpty() && binding.btnTime.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Please select date and time", Toast.LENGTH_SHORT).show();
                }
                else {
                    viewModel.setActivityModelMutableLiveData(model);
                    Navigation.findNavController(view).navigateUp();
                }


//                Navigation.findNavController(view).navigate(R.id.action_addActivityFragment_to_navigation_plan);
//                AddActivityFragmentDirections.ActionAddActivityFragmentToNavigationPlan action = AddActivityFragmentDirections.actionAddActivityFragmentToNavigationPlan(model);
//                  Navigation.findNavController(view).navigate(action);
//                  Navigation.findNavController(view).navigate(R.id.action_navigation_plan_to_addActivityFragment);

//                Toast.makeText(getContext(), model.getDate(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), model.getTime(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), model.getPersonName(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), model.getManagerName(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), model.getDealName(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), model.getServiceName(), Toast.LENGTH_SHORT).show();
            }
        });


        binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                if (isCheck) {

//                    holder.cardLayoutBinding.checkbox.setTextColor(context.getResources().getColor(R.color.black_color));

                    compoundButton.setButtonTintList(ColorStateList.valueOf(getContext().getResources().getColor(R.color.green_color)));
                } else {

                    compoundButton.setButtonTintList(ColorStateList.valueOf(getContext().getResources().getColor(R.color.blueColor)));

                }
            }
        });

        binding.etTag.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null &&
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                ) {
                    if (event == null || !event.isShiftPressed()) {
                        // the user is done typing.
                        Toast.makeText(getContext(), "user done" + binding.etTag.getText(), Toast.LENGTH_SHORT).show();
                        setChip(binding.etTag.getText().toString());
                        binding.etTag.setText("");
                        return true; // consume.
                    }
                }
                return false; // pass on to other listeners.I
            }
        });
        binding.btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = getDate();

            }
        });


        binding.btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = getTime();
//                model.setTime(time);
            }
        });

        binding.etPerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // the user is done typing.
                model.setPersonName(binding.etPerson.getText().toString());
                Toast.makeText(getContext(), "user done" + model.getPersonName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

   binding.etDeal.addTextChangedListener(new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

       }

       @Override
       public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
           Toast.makeText(getContext(), "user done" + binding.etDeal.getText(), Toast.LENGTH_SHORT).show();
           model.setDealName(binding.etDeal.getText().toString());
       }

       @Override
       public void afterTextChanged(Editable editable) {

       }
   });

        binding.etManager.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getContext(), "user done" + binding.etManager.getText(), Toast.LENGTH_SHORT).show();
                model.setManagerName(binding.etManager.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return root;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // The ViewModel is scoped to the parent of `this` Fragment
        viewModel = new ViewModelProvider(requireActivity())
                .get(SharedViewModel.class);

    }

    private String getDate() {
        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        binding.btnDate.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                        date = dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year;
                        model.setDate(date);
                        Toast.makeText(getContext(), model.getDate(), Toast.LENGTH_SHORT).show();

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

        return date;
    }

    private String getTime() {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        String AM_PM;
                        if (hourOfDay < 12) {
                            AM_PM = "AM";
                        } else {
                            AM_PM = "PM";
                        }
                        // on below line we are setting selected time
                        // in our text view.
                        binding.btnTime.setText(hourOfDay + ":" + minute + " " + AM_PM);
                        time = hourOfDay + ":" + minute + AM_PM;
                        model.setTime(time);
                    }
                }, hour, minute, false);

        timePickerDialog.show();


        return time;
    }

    private void setSpinnerAdapter(String[] list, Spinner spinner) {
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                list);

        spinner.setAdapter(adapter2);
    }

    public void setChip(String e) {
        final Chip chip = (Chip) this.getLayoutInflater().inflate(
                R.layout.tag_layout, null, false);
        chip.setText(e);

        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.chipGroup.removeView(chip);
                Toast.makeText(getContext(), chip.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.chipGroup.addView(chip);

    }


}