package com.mha.learningConcept.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.material.textview.MaterialTextView;
import com.mha.learningConcept.R;
import com.mha.learningConcept.models.Information;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Information> informationList;

    public ListAdapter(Context context, List<Information> informationList) {
        this.context = context;
        this.informationList = informationList;
    }

    @Override
    public int getCount() {
        return informationList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.layout_items, viewGroup, false);
        MaterialTextView tvName = view.findViewById(R.id.tv_name);
        MaterialTextView tvMobileNo = view.findViewById(R.id.tv_mobile_number);

        tvMobileNo.setText(informationList.get(position).getMobileNo());
        tvName.setText(informationList.get(position).getFirstName()+" "+informationList.get(position).getLastName());

        return view;
    }
}
