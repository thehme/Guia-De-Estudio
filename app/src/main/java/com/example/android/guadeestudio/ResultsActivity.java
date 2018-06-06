package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {
    int duration = Toast.LENGTH_SHORT;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_activity);

        Intent previousIntent = getIntent();
        score = previousIntent.getIntExtra("score", 0);

        Log.v("current score", "score: " + score);

        TextView scoreValueTextView = (TextView) findViewById(R.id.score_value);
        Double scorePercentage = (Float.valueOf(score) * 0.2) * 100;
        String formattedScore = String.format(Double.toString(scorePercentage), "%.2f");
        scoreValueTextView.setText(formattedScore + '%');

        Toast.makeText(getApplicationContext(), "You scored " + score + "/5 correct answers!", duration).show();

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
                Intent answersIntent = new Intent(ResultsActivity.this, AnswersActivity.class);
                startActivity(answersIntent);
            }
        });
    }
}
