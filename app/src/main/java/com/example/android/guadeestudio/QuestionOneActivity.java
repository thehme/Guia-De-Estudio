package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class QuestionOneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_one);

        // attach event listener to next Button
        Button nextQuestionButton = (Button) findViewById(R.id.to_q2_button);
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int currentScore = scoreQuestion();

                Intent questionIntent = new Intent(QuestionOneActivity.this, QuestionTwoActivity.class);
                questionIntent.putExtra("score", currentScore);
                startActivity(questionIntent);
            }
        });
    }

    public int scoreQuestion() {
        EditText q1Answer = (EditText) findViewById(R.id.question_one_answer);
        String content = q1Answer.getText().toString().toLowerCase();
        String[] possibleAnswers = new String[] {
                "quetzalcóatl",
                "quetzalcoatl",
                "quetzalcoat",
                "quetsalcoatl",
                "quetsalcoat"
        };
        if (Arrays.asList(possibleAnswers).contains(content)) {
            return 1;
        } else {
            return 0;
        }
    }
}
