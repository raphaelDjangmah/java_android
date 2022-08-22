package com.example.foodorderapp.FoodOrder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderapp.R;

public class OrderIntro extends AppCompatActivity {

    EditText user_name, pass_word;
    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodorder_intro);

        //getting edit view details
        user_name = (EditText)findViewById(R.id.login_username);
        pass_word = (EditText)findViewById(R.id.login_password);
        login   = (Button)findViewById(R.id.login);
        signup   = (Button)findViewById(R.id.signup);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String user = user_name.getText().toString();
                final String pass = pass_word.getText().toString();
                Toast.makeText(OrderIntro.this, "Welcome "+user , Toast.LENGTH_LONG).show();

                startActivity(new Intent(OrderIntro.this,Order_mainDropdown.class));

            }
        });

      signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(OrderIntro.this, Order_signup.class);
              startActivity(intent);
          }
      });


    }
}
