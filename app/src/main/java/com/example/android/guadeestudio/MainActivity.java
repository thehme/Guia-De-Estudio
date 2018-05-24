package com.example.android.guadeestudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // attach event listener to start Button
        Button startQuizButton = (Button) findViewById(R.id.start_button);
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent questionOneIntent = new Intent(MainActivity.this, QuestionOneActivity.class);
                startActivity(questionOneIntent);
            }
        });
    }
}
