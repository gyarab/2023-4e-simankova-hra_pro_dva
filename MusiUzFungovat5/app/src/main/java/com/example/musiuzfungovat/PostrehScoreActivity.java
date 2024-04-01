package com.example.musiuzfungovat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PostrehScoreActivity extends AppCompatActivity {

    private TextView tvScore = null;
    private Button hratZnova = null;
    private Button zpetZPostrehu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postreh_score);

        tvScore = findViewById(R.id.tv_score);
        hratZnova = findViewById(R.id.hrat_znovu);
        zpetZPostrehu = findViewById(R.id.zpet_z_postrehu);
        Intent intent = getIntent();
        String scoreLeft = intent.getStringExtra("scoreLeft");
        String scoreRight = intent.getStringExtra("scoreRight");

        tvScore.setText("Skóre levý: " + scoreLeft + " Skóre pravý: " + scoreRight);
        hratZnova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), PostrehActivity.class);
                v.getContext().startActivity(i);
            }
        });
        zpetZPostrehu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SecondPageActivity.class);
                v.getContext().startActivity(i);
            }
        });

    }
}
