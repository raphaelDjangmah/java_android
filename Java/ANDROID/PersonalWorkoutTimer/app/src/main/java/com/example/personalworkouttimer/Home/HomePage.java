package com.example.personalworkouttimer.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.personalworkouttimer.R;

public class HomePage extends AppCompatActivity {

    private EditText inputHours, inputMinutes, inputSeconds;
    public static final String MINUTES = "minutes";
    public static final String HOURS = "hours";
    public static final String SECONDS = "seconds";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Button start = (Button)findViewById(R.id.start_timer);
        inputHours = (EditText)findViewById(R.id.inputHours);
        inputMinutes = (EditText)findViewById(R.id.inputMinutes);
        inputSeconds = (EditText)findViewById(R.id.inputSeconds);


    // listener to the start button
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect();
            }
        });
    }


    private void redirect(){

        Intent redirect = new Intent(this, StartTimer.class);
        checkNulity(inputHours);
        checkNulity(inputMinutes);
        checkNulity(inputSeconds);
        redirect.putExtra(HOURS,Integer.parseInt(inputHours.getText().toString()));
        redirect.putExtra(MINUTES, Integer.parseInt(inputMinutes.getText().toString()));
        redirect.putExtra(SECONDS, Integer.parseInt(inputSeconds.getText().toString()));

        startActivity(redirect);
    }


    // we return 0 to an inputView with a null object to prevent app crashing
    private void checkNulity(EditText input){
        if(input.getText().toString().isEmpty()){
            input.setText("0");
        }
    }
}
