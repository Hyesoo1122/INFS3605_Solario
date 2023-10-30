package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.slider.Slider;

public class InstallationFour extends AppCompatActivity {

    Button nextButtonFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.installation_four);

        nextButtonFour = findViewById(R.id.nextButtonFour);

        nextButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (InstallationFour.this, InstallationFive.class);
                startActivity(intent);
            }
        });

    }
}
