package com.example.foodorderapp.others;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.foodorderapp.FoodOrder.SpecialOrder;
import com.example.foodorderapp.R;

public class MenuClicked
{

    // DEPENDING ON WHAT YOU PRESS ON THE MENU, WE GIVE YOU A RESPONSE

    public boolean menuClickChecker(int pressed, final Context context){

        switch (pressed){

            case R.id.about:
                Toast.makeText(context,"We are from Here to make the best local dishes on the market soo far", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contact_us:
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Locate Us").
                        setMessage("Your Location is Off\nTurn it On and try again").
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"Location is Turning On ............",Toast.LENGTH_SHORT).show();
                            }
                        }).
                        setNegativeButton("CANCEL", null).
                        setCancelable(false);

                AlertDialog alert = builder.create();
                alert.show();
                return true;

                case R.id.rate_app:
                    Intent intent = new Intent(context, RateApplication.class);
                    context.startActivity(intent);
                    return true;

            case R.id.make_special_order:
                context.startActivity(new Intent(context.getApplicationContext(), SpecialOrder.class));
                return true;

            default:
                return true;
        }
    }

}
