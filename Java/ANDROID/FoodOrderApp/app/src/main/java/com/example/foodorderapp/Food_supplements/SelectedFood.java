package com.example.foodorderapp.Food_supplements;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderapp.R;
import com.example.foodorderapp.others.RateApplication;

public class SelectedFood extends AppCompatActivity
{

    TextView price;
    ImageView image;
    Button make_order, rate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodorder_grid_item_onclick);

        price = (TextView)findViewById(R.id.onclick_price);
        image  = (ImageView)findViewById(R.id.onclick_image);
        make_order = (Button)findViewById(R.id.onclick_order);
        rate = (Button)findViewById(R.id.onclick_rate);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Onlick().onclick_something(R.id.onclick_rate);
            }
        });
        make_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Onlick().onclick_something(R.id.onclick_order);
            }
        });


        Intent intent = getIntent();
        price.setText("Price : GHS " + String.valueOf(intent.getDoubleExtra("name",0.0)));
        image.setImageResource(intent.getIntExtra("image",0));

    }


    private class Onlick{

        public void onclick_something(int id){

            switch (id){
                case R.id.onclick_rate:
                    startActivity(new Intent(SelectedFood.this, RateApplication.class));
                    break;

                case R.id.onclick_order:
                    AlertDialog.Builder builder = new AlertDialog.Builder(SelectedFood.this);

                    builder.setMessage("Enter Payment Method").
                            setPositiveButton("Choose", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(SelectedFood.this,"We are redirecting to Payment site",Toast.LENGTH_SHORT).show();
                                }
                            }).
                            setNegativeButton("Cancel",null).
                            setCancelable(true);
                    AlertDialog alert = builder.create();
                    alert.show();

                    break;

            }

        }

    }

}
