package com.example.leadforce.ui.addnewactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leadforce.R;
import com.example.leadforce.ui.addnewactivity.invertory.ItemModel;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    private Context context;
    private List<ItemModel> list;

    public SpinnerAdapter(Context context, List<ItemModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list !=null ? list.size():0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(
                R.layout.spinner_item,viewGroup,false
        );

        TextView textView = rootView.findViewById(R.id.weekofday);
        ImageView icon = rootView.findViewById(R.id.icon);

        textView.setText(list.get(i).getName());
        icon.setImageResource(list.get(i).getIcon());

        return rootView;
    }
}
