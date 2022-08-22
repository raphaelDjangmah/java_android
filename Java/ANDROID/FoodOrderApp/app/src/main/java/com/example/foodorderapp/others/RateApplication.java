package com.example.foodorderapp.others;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.foodorderapp.R;

public class RateApplication extends AppCompatActivity
{

    RatingBar ratingbar;
    TextView rating_value;
    Button rateButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_rate);


        ratingbar = (RatingBar)findViewById(R.id.ratingBar);
        rating_value = (TextView)findViewById(R.id.rate_value);
        rateButton = (Button)findViewById(R.id.submit_rate);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rating_value.setText("You have Rated : " + rating);
            }
        });

    }
}
