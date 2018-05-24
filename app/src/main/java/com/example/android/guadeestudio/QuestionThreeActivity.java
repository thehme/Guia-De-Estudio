package com.example.android.guadeestudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class QuestionThreeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_three);

        // attach event listener to next Button
        Button nextQuestionButton = (Button) findViewById(R.id.to_q4_button);
        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent questionIntent = new Intent(QuestionThreeActivity.this, QuestionFourActivity.class);
                startActivity(questionIntent);
            }
        });
    }
}
