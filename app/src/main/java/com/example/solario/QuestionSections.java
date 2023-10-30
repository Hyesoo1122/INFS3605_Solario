package com.example.solario;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class QuestionSections extends AppCompatActivity {
    ImageButton buttonForNoIdea;
    ImageButton buttonForInstallation;
    ImageButton buttonForMaintenance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_sections);

        buttonForNoIdea = findViewById(R.id.buttonForNoIdea);
        buttonForInstallation = findViewById(R.id.buttonForInstallation);
        buttonForMaintenance = findViewById(R.id.buttonForMaintenance);

        buttonForNoIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (QuestionSections.this, LearningQuestionOne.class);
                startActivity(intent);
            }
        });

        buttonForInstallation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (QuestionSections.this, InstallationOne.class);
                startActivity(intent);
            }
        });

        buttonForMaintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (QuestionSections.this, MaintenanceOne.class);
                startActivity(intent);
            }
        });
    }
}

