package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_activity);

        Intent previousIntent = getIntent();
        score = previousIntent.getIntExtra("score", 0);

        Log.v("current score", "score: " + score);

        TextView scoreValueTextView = (TextView) findViewById(R.id.score_value);
        float scorePercentage = (score / 5) * 100;
        scoreValueTextView.setText(Float.toString(scorePercentage) + '%');

        // attach event listener to start Button
        Button actionButton = (Button) findViewById(R.id.restart_button);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actionIntent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(actionIntent);
            }
        });

        // attach event listener to answers button
        Button answersButton = (Button) findViewById(R.id.answers_button);
        answersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent answersIntent = new Intent(AnswersActivity.this, MainActivity.class);
                startActivity(answersIntent);
            }
        });
    }
}
