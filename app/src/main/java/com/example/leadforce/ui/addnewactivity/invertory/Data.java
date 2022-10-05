package com.example.leadforce.ui.addnewactivity.invertory;

import android.content.Context;

import com.example.leadforce.R;

import java.util.ArrayList;
import java.util.List;

public class Data {
    Context context;
    public  static List<ItemModel> getItem(){
        List<ItemModel> itemList = new ArrayList<>();

        ItemModel call = new ItemModel();
        call.setName("Call");
        call.setIcon(R.drawable.ic_call);

        itemList.add(call);

        ItemModel email = new ItemModel();
        email.setName("Mail");
        email.setIcon(R.drawable.mail);
        itemList.add(email);

        return  itemList;

    }
}
