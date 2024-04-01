package com.example.musiuzfungovat;

import android.content.Intent;
import android.os.Bundle;
import android.view.PointerIcon;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class FirstPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        Button firstButton = (Button) findViewById(R.id.button_first);
        ImageButton navod = (ImageButton) findViewById(R.id.imageButton);

        firstButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(FirstPageActivity.this, SecondPageActivity.class));
            }
        });
        navod.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(FirstPageActivity.this, PopUp.class));
            }
        });

    }
}


