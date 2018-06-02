package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuestionFiveActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);

        Intent previousIntent = getIntent();
        score = previousIntent.getIntExtra("score", 0);

        Log.v("current score", "score: " + score);

        // attach event listener to submit Button
        Button nextQuestionButton = (Button) findViewById(R.id.submit_button);
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreTrueOrFalseQuestion();

                Intent questionIntent = new Intent(QuestionFiveActivity.this, ResultsActivity.class);
                questionIntent.putExtra("score", score);
                startActivity(questionIntent);
            }
        });
    }
    public void scoreTrueOrFalseQuestion() {
        RadioButton q5_answer = (RadioButton) findViewById(R.id.radio_q5_option2);
        if (q5_answer.isChecked()) {
            score += 1;
        }
    }
}
