package com.example.raahatapp;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;

import android.widget.Toast;


import android.os.Bundle;

import java.util.Calendar;

public class ProfileScreen extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        Spinner spinnerGender=findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.genderdropdown, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerGender.setAdapter(adapter);

        ImageButton btnBackToDashboard = (ImageButton) findViewById(R.id.imageButton);
        btnBackToDashboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileScreen.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

}

