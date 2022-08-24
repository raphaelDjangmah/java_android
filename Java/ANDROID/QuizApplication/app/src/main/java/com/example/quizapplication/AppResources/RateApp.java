package com.example.quizapplication.AppResources;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.R;

public class RateApp extends AppCompatActivity {

    RatingBar ratingBar;
    TextView rate;
    EditText inputReview;
    private boolean rateEscape;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_application);

        ratingBar = findViewById(R.id.rateApp);
        rate = findViewById(R.id.rateText);
        inputReview = findViewById(R.id.reviewInput);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rate.setText("You rated " + (int) rating + " Out Of " + ratingBar.getNumStars());
            }
        });
    }

    public void rateApp(View v) {

        if (inputReview.getText().toString().isEmpty()) {
            inputReview.setText("");
            Toast.makeText(this, "No Review Please Give Us a Review", Toast.LENGTH_SHORT).show();
            rateEscape = true;
        } else {
            Toast.makeText(this, "Thank You For Your Feedback", Toast.LENGTH_LONG).show();
            rateEscape = false;
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (rateEscape) {
            Toast.makeText(this, "No Review Please Give Us a Review", Toast.LENGTH_SHORT).show();
        } else
            super.onBackPressed();
    }
}
