package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstallationFive extends AppCompatActivity {
    Button nextButtonFive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.installation_five);

        nextButtonFive = findViewById(R.id.nextButtonFive);
        nextButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (InstallationFive.this, InstallationSix.class);
                startActivity(intent);
            }
        });
    }
}
