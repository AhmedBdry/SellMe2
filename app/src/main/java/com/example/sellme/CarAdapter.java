package com.example.sellme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends ArrayAdapter<Cars> {



    public CarAdapter(Context context, List<Cars> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_car,parent,false);
        ImageView imageView = convertView.findViewById(R.id.imgids);
        TextView textView = convertView.findViewById(R.id.txtids);
        Cars cars = getItem(position);
        imageView.setImageResource(cars.getImg());
        textView.setText(cars.getItemNames());
        return convertView;
    }
}
