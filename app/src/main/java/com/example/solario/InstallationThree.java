package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstallationThree extends AppCompatActivity {
    Button nextButtonThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.installation_three);

        nextButtonThree = findViewById(R.id.nextButtonThree);

        nextButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (InstallationThree.this, InstallationFour.class);
                startActivity(intent);
            }
        });
    }
}
