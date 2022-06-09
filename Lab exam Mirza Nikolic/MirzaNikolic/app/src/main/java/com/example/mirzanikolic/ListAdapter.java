package com.example.mirzanikolic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private final Context context;
    private final List<Mobile> mobileList;


    public ListAdapter(Context context, List<Mobile> todoList) {
        this.context = context;
        this.mobileList = todoList;
    }


    @Override
    public int getCount() {
        return mobileList.size();
    }

    @Override
    public Object getItem(int i) {
        return mobileList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mobileList.get(i).getId();
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_view, viewGroup, false);

        Mobile mobile = mobileList.get(i);

        TextView itemModel = view.findViewById(R.id.item_model);
        TextView itemColor = view.findViewById(R.id.item_color);
        TextView itemPrice = view.findViewById(R.id.item_price);
        TextView itemMemory = view.findViewById(R.id.item_memory);
        itemModel.setText(mobile.getModel());
        itemColor.setText(mobile.getColor());
        itemPrice.setText(mobile.getPrice());
        itemMemory.setText(mobile.getMemory());

        return view;
    }
}
