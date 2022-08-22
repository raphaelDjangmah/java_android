package com.example.foodorderapp.Food_supplements;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderapp.R;

public class Food_chosed_gallery extends AppCompatActivity {

    GridView gridview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodorder_grid);

        gridview = (GridView)findViewById(R.id.gridview);
        TextView textView = (TextView)findViewById(R.id.grid_food_catergory);
        textView.setText(Food_choser.food_chosen + " Category");

        CustomAdapter adapter = new CustomAdapter(Food_choser.getPrices(),Food_choser.getImages(),this);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Food_chosed_gallery.this, SelectedFood.class);
                intent.putExtra("name", Food_choser.getPrices()[position]);
                intent.putExtra("image", Food_choser.getImages()[position]);

                startActivity(intent);

            }
        });

    }
}
