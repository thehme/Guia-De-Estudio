package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class QuestionFourActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);

        Intent previousIntent = getIntent();
        score = previousIntent.getIntExtra("score", 0);

        Log.v("current score", "score: " + score);

        // attach event listener to next Button
        Button nextQuestionButton = (Button) findViewById(R.id.to_q5_button);
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreCheckboxQuestion();

                Intent questionIntent = new Intent(QuestionFourActivity.this, QuestionFiveActivity.class);
                questionIntent.putExtra("score", score);
                startActivity(questionIntent);
            }
        });
    }
    public void scoreCheckboxQuestion() {
        CheckBox q4_answer1 = (CheckBox) findViewById(R.id.checkbox_q4_option1);
        CheckBox q4_answer2 = (CheckBox) findViewById(R.id.checkbox_q4_option2);
        CheckBox q4_answer3 = (CheckBox) findViewById(R.id.checkbox_q4_option3);
        CheckBox q4_answer4 = (CheckBox) findViewById(R.id.checkbox_q4_option4);
        if (!q4_answer1.isChecked() && q4_answer2.isChecked()
                && !q4_answer3.isChecked() && q4_answer4.isChecked()) {
            score += 1;
        }
    }
}
