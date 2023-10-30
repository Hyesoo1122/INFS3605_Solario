package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstallationSix extends AppCompatActivity {
    Button nextButtonSix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.installation_six);

        nextButtonSix = findViewById(R.id.button2);
        nextButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (InstallationSix.this, InstallationSeven.class);
                startActivity(intent);
            }
        });
    }
}


