package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstallationTwo extends AppCompatActivity {
    Button nextButtonTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.installation_two);

        nextButtonTwo = findViewById(R.id.nextButtonTwo);

        nextButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (InstallationTwo.this, InstallationThree.class);
                startActivity(intent);
            }
        });
    }
}
