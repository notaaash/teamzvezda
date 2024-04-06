package com.example.raahatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class LegalAid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_aid);

        ImageButton btnProBonoLawyers = (ImageButton) findViewById(R.id.imageButtonProBonoLawyers);
        btnProBonoLawyers.setOnClickListener(v -> {
            Intent intent = new Intent(LegalAid.this, ProBonoLawyers.class);
            startActivity(intent);
        });

        ImageButton btnPaidLawyers = (ImageButton) findViewById(R.id.imageButtonPaidLawyers);
        btnPaidLawyers.setOnClickListener(v -> {
            Intent intent = new Intent(LegalAid.this, PaidLawyers.class);
            startActivity(intent);
        });

        ImageButton btnLegalAidClinics = (ImageButton) findViewById(R.id.imageButtonLegalAidClinics);
        btnLegalAidClinics.setOnClickListener(v -> {
            Intent intent = new Intent(LegalAid.this, LegalAidClinics.class);
            startActivity(intent);
        });

        ImageButton btnKnowYourRightsChatbot = (ImageButton) findViewById(R.id.imageButtonChatBot);
        btnKnowYourRightsChatbot.setOnClickListener(v -> {
            Intent intent = new Intent(LegalAid.this, KnowYourRightsChatbot.class);
            startActivity(intent);
        });


    }
}