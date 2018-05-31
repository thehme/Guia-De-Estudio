package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionTwoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);

        Intent previousIntent = getIntent();
        final int score = previousIntent.getIntExtra("score", 0);

        Log.v("current score", "score: " + score);

        // attach event listener to next Button
        Button nextQuestionButton = (Button) findViewById(R.id.to_q3_button);
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = scoreQuestion();
                Log.v("score", "score before 2nd question: " + score);
                int currentScore = score + scoreQuestion();
                Log.v("score", "score after 2nd question: " + currentScore);
                Intent questionIntent = new Intent(QuestionTwoActivity.this, QuestionThreeActivity.class);
                questionIntent.putExtra("score", currentScore);
                startActivity(questionIntent);
            }
        });
    }

    public int scoreQuestion() {
        RadioGroup q2_answer = (RadioGroup) findViewById(R.id.q2_radio_group);
        if (q2_answer.getCheckedRadioButtonId() == -1) {
            return 0;
        }
        RadioButton selectedRadioButton = (RadioButton) findViewById(q2_answer.getCheckedRadioButtonId());
        String selectedRadioButtonText = selectedRadioButton.getText().toString();
        Log.v("correctAnswer", "correctAnswer: " + selectedRadioButtonText);
        return selectedRadioButtonText.toLowerCase() == "maya" ? 1 : 0;
    }
}
