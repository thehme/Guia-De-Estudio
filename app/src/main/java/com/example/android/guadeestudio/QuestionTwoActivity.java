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
    int score = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);

        Intent previousIntent = getIntent();
        score = previousIntent.getIntExtra("score", 0);

        Log.v("current score", "score: " + score);

        // attach event listener to next Button
        Button nextQuestionButton = (Button) findViewById(R.id.to_q3_button);
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("score", "score before 2nd question: " + score);
                scoreQuestion();
                Log.v("score", "score after 2nd question: " + score);
                Intent questionIntent = new Intent(QuestionTwoActivity.this, QuestionThreeActivity.class);
                questionIntent.putExtra("score", score);
                startActivity(questionIntent);
            }
        });
    }

    public void scoreQuestion() {
        RadioGroup q2_answer = (RadioGroup) findViewById(R.id.q2_radio_group);
        Log.v("q2_answer", "q2_answer id: " + q2_answer.getCheckedRadioButtonId());
        if (q2_answer.getCheckedRadioButtonId() != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(q2_answer.getCheckedRadioButtonId());
            String selectedRadioButtonText = selectedRadioButton.getText().toString().toLowerCase();
            Log.v("correctAnswer", "correctAnswer: " + selectedRadioButtonText);
            if (selectedRadioButtonText.equals("maya")) {
                Log.v("answer entered", "answer entered: " + selectedRadioButtonText);
                score = score + 1;
            }
        }
    }
}
