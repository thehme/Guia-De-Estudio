package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
                Intent questionIntent = new Intent(QuestionTwoActivity.this, QuestionThreeActivity.class);
                startActivity(questionIntent);
            }
        });
    }
}
