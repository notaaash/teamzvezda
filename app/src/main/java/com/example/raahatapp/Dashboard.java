package com.example.raahatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageButton btnCaseFile = (ImageButton) findViewById(R.id.imageButton3);
        btnCaseFile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, CaseFiles.class);
                startActivity(intent);
            }
        });

        ImageButton btnProgress = (ImageButton) findViewById(R.id.imageButton4);
        btnProgress.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, CaseProgress.class);
                startActivity(intent);
            }
        });

        ImageButton btnLegalAid = (ImageButton) findViewById(R.id.imageButton5);
        btnLegalAid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, LegalAid.class);
                startActivity(intent);
            }
        });

        ImageButton btnRehab = (ImageButton) findViewById(R.id.imageButton6);
        btnRehab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, RehabScreen.class);
                startActivity(intent);
            }
        });

        ImageButton btnHome = (ImageButton) findViewById(R.id.imageButtonHome);
        btnHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            }
        });

        ImageButton btnCourtSection= (ImageButton) findViewById(R.id.imageButtonCourt);
        btnCourtSection.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, CourtInformation.class);
                startActivity(intent);
            }
        });

        ImageButton btnSettings = (ImageButton) findViewById(R.id.imageButtonSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, CaseProgress.class);
                startActivity(intent);
            }
        });

        ImageButton btnProfile = (ImageButton) findViewById(R.id.imageButtonProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ProfileScreen.class);
                startActivity(intent);
            }
        });

    }
}