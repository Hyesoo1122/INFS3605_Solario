package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class InstallationOne extends AppCompatActivity {

    Button installButtonOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.installation_one);

        installButtonOne = findViewById(R.id.installationButtonOne);

        installButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (InstallationOne.this, InstallationTwo.class);
                startActivity(intent);
            }
        });

    }
}
