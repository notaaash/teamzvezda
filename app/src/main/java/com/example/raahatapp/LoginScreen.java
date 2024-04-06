package com.example.raahatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        Button btnRegister = (Button) findViewById(R.id.button2);
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, RegisterPage.class);
                startActivity(intent);
            }
        });

        Button btnLogin = (Button) findViewById(R.id.button3);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, Dashboard.class);
                startActivity(intent);
            }
        });


    }
}