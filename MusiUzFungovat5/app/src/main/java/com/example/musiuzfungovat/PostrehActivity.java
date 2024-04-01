package com.example.musiuzfungovat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PostrehActivity extends AppCompatActivity {

    private static final String PINK = "pink";
    private static final String PINK_VALUE = "#F4538A";
    private static final String GREEN = "green";
    private static final String GREEN_VALUE = "#A5DD9B";
    private static final String ORANGE = "orange";
    private static final String ORANGE_VALUE = "#FFB38E";
    private static final String BLUE = "blue";
    private static final String BLUE_VALUE = "#6AD4DD";

    private TextView colorQuestion = null;
    private Button pinkButtonLeft,greenButtonLeft,orangeButtonLeft,blueButtonLeft,pinkButtonRight,greenButtonRight,orangeButtonRight,blueButtonRight = null;
    private ProgressBar progressBar = null;
    private Integer scoreLeft=0;
    private Integer scoreRight=0;
    private byte hra = 0;

    private final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInsatnceState){
        super.onCreate(savedInsatnceState);
        setContentView(R.layout.activity_postreh);

        colorQuestion = findViewById(R.id.color_question);
        progressBar = findViewById(R.id.progress_bar_postreh);

        pinkButtonLeft = findViewById(R.id.pink_btn_left);
        greenButtonLeft = findViewById(R.id.green_btn_left);
        orangeButtonLeft = findViewById(R.id.orange_btn_left);
        blueButtonLeft = findViewById(R.id.blue_btn_left);

        pinkButtonRight = findViewById(R.id.pink_btn_left);
        greenButtonRight = findViewById(R.id.green_btn_left);
        orangeButtonRight = findViewById(R.id.orange_btn_left);
        blueButtonRight = findViewById(R.id.blue_btn_left);

        progressBar.setProgress(0);

        setColorQuestion();
    }

    //barvy buttonů
    private void setColorQuestion(){
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put(PINK,PINK_VALUE);
        colorMap.put(GREEN,GREEN_VALUE);
        colorMap.put(ORANGE,ORANGE_VALUE);
        colorMap.put(BLUE,BLUE_VALUE);

        setTimer();
        String question = getRandomColor();
        String questionCol = getRandomColor();

        if(colorMap.containsKey(question)&& colorMap.containsKey(questionCol)){
            colorQuestion.setText(question);
            String questionTextCol = colorMap.get(questionCol);
            colorQuestion.setTextColor(Color.parseColor(questionTextCol));

        }
    }

    //vyber random barvy(buttonu), misto voidu String aby fungoval return
    private String getRandomColor(){
        List<String> colors = Arrays.asList(PINK,GREEN,ORANGE,BLUE);
        Random randomcol = new Random();
        int randomIndex = randomcol.nextInt(4);
        return colors.get(randomIndex);
    }

    public void submitAnswerLeft(View view){
        Button bt = (Button)view;
        boolean resl = colorQuestion.getText().equals(bt.getText());
        if(resl){
            scoreLeft++;
            setColorQuestion();
            hra++;
        }
        else {
            //exit();

        }
        if (hra == 5) exit();
    }
    public void submitAnswerRight(View view){
        Button bt = (Button)view;
        boolean resl = colorQuestion.getText().equals(bt.getText());
        if(resl){
            scoreRight++;
            setColorQuestion();
            hra++;
        }
        else {
            //exit();

        }
        if (hra == 5) exit();
    }
    private void exit(){
        handler.removeCallbacksAndMessages(null);
        Intent intent = new Intent(this, PostrehScoreActivity.class);
        intent.putExtra("scoreLeft",String.valueOf(scoreLeft));
        intent.putExtra("scoreRight",String.valueOf(scoreRight));
        this.startActivity(intent);
    }

    private void setTimer(){
        final int delay = 1000;
        final int[] counter = {1};
        progressBar.setProgress(0);
        handler.removeCallbacksAndMessages(null);

        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        int progress = counter[0] *10;
                        progressBar.setProgress(progress);

                        if(progress==100){
                            exit();
                        }
                        counter[0]++;
                        handler.postDelayed(this,delay);
                    }
                },delay
        );
    }

}
