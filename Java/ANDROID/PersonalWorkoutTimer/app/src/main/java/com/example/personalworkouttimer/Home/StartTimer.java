package com.example.personalworkouttimer.Home;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.personalworkouttimer.ProjectResources.MyCountdown;
import com.example.personalworkouttimer.ProjectResources.RestartTimer;
import com.example.personalworkouttimer.R;

public class StartTimer extends AppCompatActivity {

    TextView tvMinutes, tvHours, tvSeconds;
    private MyCountdown myCountdown;
    private int minutes, seconds, hours;
    private CountDownTimer timer;
    ImageView playPauseButton;
    private boolean isRunning;
    private RestartTimer restartTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("WorkOut Start");
        setContentView(R.layout.show_timer);

        tvMinutes = findViewById(R.id.minutes);
        tvHours   = findViewById(R.id.hours);
        tvSeconds = findViewById(R.id.seconds);
        playPauseButton = findViewById(R.id.timerPausePlay_image);

        // we are getting the intents from  the other class
        Intent data = getIntent();
        hours = data.getIntExtra(HomePage.HOURS,0);
        minutes = data.getIntExtra(HomePage.MINUTES, 0);
        seconds = data.getIntExtra(HomePage.SECONDS, 0);

        myCountdown = new MyCountdown(hours, minutes, seconds);
        restartTimer = new RestartTimer(hours, minutes, seconds);
        startCountdown();
    }

    private void playPauseState(){

        if(isRunning){
            startCountdown();
        }else{
            pauseTimer();
        }

    }

    public void startCountdown(){

        playPauseButton.setImageResource(R.drawable.pause_24dp);

        timer = new CountDownTimer(myCountdown.getTimeLeft(), myCountdown.ONESECONDINMILLIS) {
            @Override
            public void onTick(long left) {
                myCountdown.setTimeLeft(left);
                myCountdown.updateVariables();
                updateTimer();
            }

            @Override
            public void onFinish() {
                Toast.makeText(StartTimer.this,"Time Is Up", Toast.LENGTH_LONG).show();

            }
        }.start();

        isRunning = false;
    }

    // We pause the timer here

    public void pauseTimer(){
        playPauseButton.setImageResource(R.drawable.ic_play_arrow_black_24dp);
        timer.cancel();
        isRunning = true;
    }

    public void updateTimer(){

        String hoursNow = String.valueOf(myCountdown.getHours());
        String minutesNow = String.valueOf(myCountdown.getMinutes());
        String secondsNow = String.valueOf(myCountdown.getSeconds());

        if(myCountdown.getMinutes()< 10) minutesNow = "0".concat(minutesNow);
        if(myCountdown.getSeconds()<10) secondsNow = "0".concat(secondsNow);

        tvHours.setText(hoursNow);
        tvMinutes.setText(minutesNow);
        tvSeconds.setText(secondsNow);

    }


    // depending on the button pressed, we listen and act accordingly
    public void imageButtonPress(View v){

        switch (v.getId()){

            case R.id.timerPausePlay_image:
                playPauseState();
                break;
            case R.id.stop_timer_image:
                timer.cancel();
                finish();
                break;
            case R.id.restart_timer_image:
                resetTimer();
                break;
            case R.id.addMinuteButton:
                EditText addOn = (EditText)findViewById(R.id.addMinuteInput);
                if(addOn.getText().toString().isEmpty()) addOn.setText("0");
                addMinutes(Integer.parseInt(addOn.getText().toString()));
                break;
        }

    }

    // restart the timer

    private void resetTimer(){
        timer.cancel();
        myCountdown = new MyCountdown(restartTimer.getInitHours(), restartTimer.getInitMinutes(), restartTimer.getInitSeconds());
        startCountdown();
    }

    // we are adding some time to our currently running time

    private void addMinutes(int addOn){
        timer.cancel();
        myCountdown = new MyCountdown(myCountdown.getHours(), myCountdown.getMinutes()+ addOn, myCountdown.getSeconds());
        startCountdown();
    }
}
