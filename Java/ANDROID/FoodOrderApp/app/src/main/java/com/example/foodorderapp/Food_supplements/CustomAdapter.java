package com.example.foodorderapp.Food_supplements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodorderapp.R;

public class CustomAdapter extends BaseAdapter
{


    //price of food
     double[] price;
     int[] image;
     Context context;



    public CustomAdapter(double[] price, int[] image, Context context) {
        this.context = context;
        this.price = price;
        this.image = image;

    }

    @Override
    public int getCount() {
        return price.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService((context.LAYOUT_INFLATER_SERVICE));
        View view = inflater.inflate(R.layout.foodorder_grid_items,null);
        TextView textView = view.findViewById(R.id.price);
        ImageView imageView = view.findViewById(R.id.imageview);
        textView.setText("Price : GHS " + String.valueOf(price[position]));
        imageView.setImageResource(image[position]);

        return view;
    }
}
