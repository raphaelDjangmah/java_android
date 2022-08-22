package com.example.foodorderapp.FoodOrder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

import com.example.foodorderapp.Food_supplements.Food_choser;
import com.example.foodorderapp.R;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter
{

    Context context;
    TextView childText;
    String pressed;
    String parents[] = {"Local Foods","Local Drinks", "Local snacks"};
    String children[][] = {
            {"Fufu","Banku","Yam","Pizza","Beans","Rice","Plantain","Cocoyam","Waakey","Tuozafi","Rice Balls","Omo-Two"},
            {"Pito","Palm wine","ahokele","rice wine", "foreign wine", "akpet","others"},
            {"Criss Chips", "chicken and chips","Ada Biscuit","Rizaorr","HiRupe", "others"}
    };

    public ExpandableListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return parents.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return children[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parents[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return children[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        TextView textView = new TextView(context);
        textView.setPadding(120,50,0,50);
        textView.setTextColor(Color.rgb(36,44,134));
        textView.setTextSize(25);
        Typeface font  = ResourcesCompat.getFont(context, R.font.mercy);
        textView.setTypeface(font);
        textView.setText(parents[groupPosition]);


        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final TextView childText = new TextView(context);
        childText.setTextColor(Color.BLACK);
        childText.setPadding(120,0,0,20);
        childText.setTextSize(25);
        Typeface font  = ResourcesCompat.getFont(context, R.font.enriqueta_bold);
        childText.setTypeface(font);
        childText.setText(children[groupPosition][childPosition]);

        childText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressed = childText.getText().toString();
                Toast.makeText(context, pressed, Toast.LENGTH_LONG).show();
                Food_choser choser = new Food_choser(context);
                context.startActivity(choser.FoodChosed(pressed));
            }
        });

        return childText;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
