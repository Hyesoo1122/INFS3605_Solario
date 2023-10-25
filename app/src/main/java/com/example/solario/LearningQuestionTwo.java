package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LearningQuestionTwo extends AppCompatActivity {
    Button nextLearningThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_question_two);

        nextLearningThree = findViewById(R.id.nextThree);

        nextLearningThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LearningQuestionTwo.this, LearningQuestionThree.class);
                startActivity(intent);
            }
        });

    }
}