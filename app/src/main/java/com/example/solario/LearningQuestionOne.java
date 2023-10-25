package com.example.solario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LearningQuestionOne extends AppCompatActivity {
    Button nextLearningTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_question_one);

        nextLearningTwo = findViewById(R.id.NextLearningTwo);

        nextLearningTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LearningQuestionOne.this, LearningQuestionTwo.class);
                startActivity(intent);
            }
        });



    }
}
