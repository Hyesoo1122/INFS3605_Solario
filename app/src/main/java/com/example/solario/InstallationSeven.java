package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstallationSeven extends AppCompatActivity {
    Button nextButtonSeven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.installation_seven);

        nextButtonSeven = findViewById(R.id.button3);
        nextButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (InstallationSeven.this, InstallationEight.class);
                startActivity(intent);
            }
        });
    }
}
