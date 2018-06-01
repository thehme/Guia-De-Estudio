package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class QuestionThreeActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_three);

        Intent previousIntent = getIntent();
        score = previousIntent.getIntExtra("score", 0);

        Log.v("current score", "score: " + score);

        // attach event listener to next Button
        Button nextQuestionButton = (Button) findViewById(R.id.to_q4_button);
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int currentScore = scoreQuestion();
                score = score + currentScore;

                Intent questionIntent = new Intent(QuestionThreeActivity.this, QuestionFourActivity.class);
                questionIntent.putExtra("score", score);
                startActivity(questionIntent);
            }
        });
    }

    public int scoreQuestion() {
        EditText q1Answer = (EditText) findViewById(R.id.question_three_answer);
        String content = q1Answer.getText().toString().toLowerCase();
        String[] possibleAnswers = new String[] {
                "teotihuacan",
                "teotiuacan",
                "teotiuacán"
        };
        if (Arrays.asList(possibleAnswers).contains(content)) {
            return 1;
        } else {
            return 0;
        }
    }
}
