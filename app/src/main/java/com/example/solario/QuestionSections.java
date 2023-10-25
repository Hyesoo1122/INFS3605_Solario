package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class QuestionSections extends AppCompatActivity {
    Button buttonForNoIdea;
    Button buttonForInstallation;
    Button buttonForMaintenance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_sections);

        buttonForNoIdea = findViewById(R.id.buttonForNoIdea);

        buttonForNoIdea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (QuestionSections.this, LearningQuestionOne.class);
                startActivity(intent);
            }
        });

    }
}

