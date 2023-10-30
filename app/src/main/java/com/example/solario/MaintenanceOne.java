package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MaintenanceOne extends AppCompatActivity {

    Button maintenanceButtonOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maintenance_one);

        maintenanceButtonOne = findViewById(R.id.button5);
        maintenanceButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MaintenanceOne.this, MaintenanceTwo.class);
                startActivity(intent);
            }
        });
    }
}
