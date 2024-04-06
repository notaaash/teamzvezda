package com.example.raahatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class RehabScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_screen);



        Button btnDetoxification = (Button) findViewById(R.id.buttonDetoxification);
        btnDetoxification.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://www.youtube.com/watch?v=z6X5oEIg6Ak";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button btnTherapyAndCounselling = (Button) findViewById(R.id.buttonTherapyNCounselling);
        btnTherapyAndCounselling.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://www.youtube.com/watch?v=z6aG0OBEq2w";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button btnMedicalHealthcare = (Button) findViewById(R.id.buttonMedicalHealthcare);
        btnMedicalHealthcare.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://www.youtube.com/watch?v=eAK14VoY7C0";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button btnEducationalPrograms = (Button) findViewById(R.id.buttonEducationalPrograms);
        btnEducationalPrograms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://www.skillindiadigital.gov.in/home";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button btnSupportGroups = (Button) findViewById(R.id.buttonSupportGroups);
        btnSupportGroups.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://www.youtube.com/watch?v=wOGqlVqyvCM";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button btnHolisticTherapies = (Button) findViewById(R.id.buttonHolisticTherapies);
        btnHolisticTherapies.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://atmantan.com/wellness-packages/holistic-health/?gad_source=2";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button btnAftercarePlanning = (Button) findViewById(R.id.buttonAftercarePlanning);
        btnAftercarePlanning.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://www.youtube.com/watch?v=assKnrbTvgk";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button btnSpecialisedPrograms = (Button) findViewById(R.id.buttonSpecialisedPrograms);
        btnSpecialisedPrograms.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://www.youtube.com/watch?v=Xa3RXgtVkXk";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });





    }
}