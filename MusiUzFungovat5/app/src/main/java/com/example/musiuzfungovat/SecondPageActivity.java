package com.example.musiuzfungovat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        FloatingActionButton postrehButton = (FloatingActionButton) findViewById(R.id.postreh);
        FloatingActionButton matematikaButton = (FloatingActionButton) findViewById(R.id.matika);
        Button secondButton = (Button)findViewById(R.id.button_second);

        postrehButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SecondPageActivity.this, PostrehActivity.class));
            }
        });
        matematikaButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SecondPageActivity.this, MatematikaActivity.class));
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondPageActivity.this,FirstPageActivity.class));
            }
        });

    }

}
