package com.example.foodorderapp.FoodOrder;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderapp.R;
import com.example.foodorderapp.others.MenuClicked;

public class Order_mainDropdown extends AppCompatActivity
{

    ExpandableListView dropdown;
    private String food_chosed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodorder_main);

        dropdown = findViewById(R.id.dropdown);

         ExpandableListViewAdapter adapter = new ExpandableListViewAdapter(this);
         dropdown.setAdapter(adapter);
         food_chosed = adapter.pressed;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // instead of hardcoding listener, we put all inside the menuclicked.class
        return new MenuClicked().menuClickChecker(item.getItemId(),this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_more,menu);

        return true;
    }
}
