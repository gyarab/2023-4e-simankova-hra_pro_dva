package com.example.musiuzfungovat;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class MatematikaActivity extends AppCompatActivity {
    private Button rightOneBtn, rightTwoBtn,rightThreeBtn, rightFourBtn, naStartBtn;
    private TextView textTimer, textBottomMessage, textScoreMatematika, textQuestions;
     private ProgressBar ProgressBarMatika;
    //int level = 0; //    //String realOperation = "";   //    //Hra h = new Hra();//    //int great=0;//    //int rightAnswer = 0;
    Hra h = new Hra();
    int secondsRemaining = 30;
    CountDownTimer timer = new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            textTimer.setText(Integer.toString(secondsRemaining)+ "sec");
            ProgressBarMatika.setProgress(30 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            rightOneBtn.setEnabled(false);
            rightTwoBtn.setEnabled(false);
            rightThreeBtn.setEnabled(false);
            rightFourBtn.setEnabled(false);
            textBottomMessage.setText("Time is up!"+h.getNumberRight()+"/"+(h.getTotalQuestions()-1));
            final Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    naStartBtn.setVisibility(View.VISIBLE);
                }
            },4000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika);

        naStartBtn = findViewById(R.id.naStart);
        rightOneBtn = findViewById(R.id.right_one);
        rightTwoBtn = findViewById(R.id.right_two);
        rightThreeBtn = findViewById(R.id.right_three);
        rightFourBtn = findViewById(R.id.right_four);

        textScoreMatematika = findViewById(R.id.tv_score_matika);
        textTimer = findViewById(R.id.tv_timer);
        textBottomMessage = findViewById(R.id.tv_bottommessage);
        textQuestions = findViewById(R.id.tv_questions);
        ProgressBarMatika = findViewById(R.id.progressBarMatika);

        textTimer.setText("0 sec");
        textQuestions.setText("");
        textBottomMessage.setText("Press go");
        textScoreMatematika.setText("0pts");

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start_button = (Button) v;

                start_button.setVisibility(View.INVISIBLE);
                secondsRemaining = 30;
                h=new Hra();
                nextTurn();
                timer.start();

            }
        };
        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v;
                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
                h.checkingAnswers(answerSelected);
                textScoreMatematika.setText(Integer.toString(h.getSkore()));
                nextTurn();
            }
        };
        naStartBtn.setOnClickListener(startButtonClickListener);

        rightOneBtn.setOnClickListener(answerButtonClickListener);
        rightTwoBtn.setOnClickListener(answerButtonClickListener);
        rightThreeBtn.setOnClickListener(answerButtonClickListener);
        rightFourBtn.setOnClickListener(answerButtonClickListener);
    }
    private void nextTurn(){
        h.vytvorNovouOtazku();
        int [] odpovediHrace = h.getOtazka().getAnswerArray();

        rightOneBtn.setText(Integer.toString(odpovediHrace[0]));//kdybych nekonvertovala odpovediHrace do Stringu vznikla by chyba
        rightTwoBtn.setText(Integer.toString(odpovediHrace[1]));
        rightThreeBtn.setText(Integer.toString(odpovediHrace[2]));
        rightFourBtn.setText(Integer.toString(odpovediHrace[3]));

        rightOneBtn.setEnabled(true);
        rightTwoBtn.setEnabled(true);
        rightThreeBtn.setEnabled(true);
        rightFourBtn.setEnabled(true);
        textQuestions.setText(h.getOtazka().getQuestionPhrase());
        textBottomMessage.setText(h.getNumberRight()+"/"+h.getTotalQuestions());

    }
}
        //Objects.requireNonNull(getSupportActionBar()).hide();

        /*textLevel = findViewById(R.id.textQuestionNumber);
        textQuestion = findViewById(R.id.textQuestion);
        textRightAnswered = findViewById(R.id.textRightAnswered);



        textLevel.setText("Q:"+level+" /10");
        textRightAnswered.setText("RA"+ great+ " /10");

        if(level<10) {
           getRandomQuestion(); 
        }
    }

    private void getRandomQuestion() {
        rightOneBtn.setBackgroundResource(R.drawable.buttons_option);
        rightTwoBtn.setBackgroundResource(R.drawable.buttons_option);
        rightThreeBtn.setBackgroundResource(R.drawable.buttons_option);
        rightFourBtn.setBackgroundResource(R.drawable.buttons_option);

        //random cisla zadani
        int firstNumber = new Random().nextInt(10);
        int secondNumber = new Random().nextInt(10);

        //random znaky zadani
        int operation = new Random().nextInt(4)+1;

        //3 moznosti
        int opstionOne = new Random().nextInt(1000);
        int optionTwo = new Random().nextInt(1000);
        int optionThree = new Random().nextInt(1000);

        if(operation == 1){
            realOperation = "+";
            rightAnswer = firstNumber + secondNumber;
            textQuestion.setText(firstNumber+ " " + realOperation+" "+secondNumber+ "= ?");
        }else if (operation == 2){
            realOperation = "*";
            rightAnswer = firstNumber * secondNumber;
            textQuestion.setText(firstNumber+ " " + realOperation+" "+secondNumber+ "= ?");
        }else if (operation == 3){
            realOperation = "-";
            if (firstNumber < secondNumber){
                rightAnswer = firstNumber - secondNumber;
                textQuestion.setText(secondNumber+ " " + realOperation+" "+firstNumber+ "= ?");
            }else{
                rightAnswer = secondNumber - firstNumber;
                textQuestion.setText(firstNumber+" "+realOperation+" "+secondNumber+"= ?");
                }

            }
        //pozice odpovedi
        int position = new Random().nextInt(4)+1;
        if(position == 1){
            rightOneBtn.setText(" " + rightAnswer);
            rightTwoBtn.setText(" " + opstionOne);
            rightThreeBtn.setText(" " + optionTwo);
            rightFourBtn.setText(" " + optionThree);
        } else if (position ==2) {
            rightTwoBtn.setText(" " + rightAnswer);
            rightOneBtn.setText(" " + opstionOne);
            rightThreeBtn.setText(" " + optionTwo);
            rightFourBtn.setText(" " + optionThree);
        } else if (position == 3) {
            rightThreeBtn.setText(" " + rightAnswer);
            rightOneBtn.setText(" " + opstionOne);
            rightTwoBtn.setText(" " + optionTwo);
            rightFourBtn.setText(" " + optionThree);
        }else if (position == 4){
            rightFourBtn.setText(" " + rightAnswer);
            rightOneBtn.setText(" " + opstionOne);
            rightTwoBtn.setText(" " + optionTwo);
            rightThreeBtn.setText(" " + optionThree);
        }
        rightOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rightOneBtn.getText().equals(""+ rightAnswer)){
                    rightOneBtn.setBackgroundResource(R.drawable.right_answer);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("Q : "+ level + " / 10");
                    textRightAnswered.setText("RA : " + great + " /10");
                }else{
                    level = level + 1;
                    textLevel.setText("Q : "+ level + " / 10");
                    rightOneBtn.setBackgroundResource(R.drawable.wrong_answer);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10){
                            getRandomQuestion();
                        }else{
                            Intent intent  = new Intent(MatematikaActivity.this,MatematikaScoreActivity.class);
                            intent.putExtra("RA",great);
                            startActivity(intent);
                            finish();

                        }
                    }
                },1000);
            }

        });
        rightTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rightTwoBtn.getText().equals(""+ rightAnswer)){
                    rightTwoBtn.setBackgroundResource(R.drawable.right_answer);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("Q : "+ level + " / 10");
                    textRightAnswered.setText("RA : " + great + " /10");
                }else{
                    level = level + 1;
                    textLevel.setText("Q : "+ level + " / 10");
                    rightTwoBtn.setBackgroundResource(R.drawable.wrong_answer);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10){
                            getRandomQuestion();
                        }else{
                            Intent intent  = new Intent(MatematikaActivity.this,MatematikaScoreActivity.class);
                            intent.putExtra("RA",great);
                            startActivity(intent);
                            finish();

                        }
                    }
                },1000);
            }

        });
        rightThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rightThreeBtn.getText().equals(""+ rightAnswer)){
                    rightThreeBtn.setBackgroundResource(R.drawable.right_answer);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("Q : "+ level + " / 10");
                    textRightAnswered.setText("RA : " + great + " /10");
                }else{
                    level = level + 1;
                    textLevel.setText("Q : "+ level + " / 10");
                    rightThreeBtn.setBackgroundResource(R.drawable.wrong_answer);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10){
                            getRandomQuestion();
                        }else{
                            Intent intent  = new Intent(MatematikaActivity.this,MatematikaScoreActivity.class);
                            intent.putExtra("RA",great);
                            startActivity(intent);
                            finish();

                        }
                    }
                },1000);
            }

        });
        rightFourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rightFourBtn.getText().equals(""+ rightAnswer)){
                    rightFourBtn.setBackgroundResource(R.drawable.right_answer);
                    great = great + 1;
                    level = level + 1;
                    textLevel.setText("Q : "+ level + " / 10");
                    textRightAnswered.setText("RA : " + great + " /10");
                }else{
                    level = level + 1;
                    textLevel.setText("Q : "+ level + " / 10");
                    rightFourBtn.setBackgroundResource(R.drawable.wrong_answer);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10){
                            getRandomQuestion();
                        }else{
                            Intent intent  = new Intent(MatematikaActivity.this,MatematikaScoreActivity.class);
                            intent.putExtra("RA",great);
                            startActivity(intent);
                            finish();

                        }
                    }
                },1000);
            }

        });
    }



}

        /*rightOneBtn = findViewById(R.id.right_one);
        rightTwoBtn = findViewById(R.id.right_two);
        rightThreeBtn = findViewById(R.id.right_three);
        rightFourBtn = findViewById(R.id.right_four);

        //naStartBtn = findViewById(R.id.naStart);

        zadaniTxt = findViewById(R.id.zadani);
        zadaniTxt.setText("");
        timerTxt = findViewById(R.id.timer);
        timerTxt.setText("0s");
        skoreTxt = findViewById(R.id.skore);
        skoreTxt.setText("0pts");


        /*View.OnClickListener zacniOnClickListener = v -> {
            Button naStartBtn = (Button) v;
            naStartBtn.setVisibility(View.INVISIBLE);
            nextTurn();
        };
        View.OnClickListener rightClickOnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button bClick = (Button) v;
                int answerSelect = Integer.parseInt(bClick.getText().toString());
                //Toast.makeText(MainActivity.this,"Answer selected"+answerSelect,Toast.LENGTH_SHORT);
                h.checkingAnswers(answerSelect);
                skoreTxt.setText(Integer.toString(h.getSkore()));
                nextTurn();

            }
        };


        //naStartBtn.setOnClickListener(rightClickOnListener);
    }
    //bude zaznamenavat odpovedi hrace
    private void nextTurn(){
        h.vytvorNovouOtazku();
        int [] odpovediHrace = h.getOtazka().getAnswerArray();

        rightOneBtn.setText(Integer.toString(odpovediHrace[0]));//kdybych nekonvertovala odpovediHrace do Stringu vznikla by chyba
        rightTwoBtn.setText(Integer.toString(odpovediHrace[1]));
        rightThreeBtn.setText(Integer.toString(odpovediHrace[2]));
        rightFourBtn.setText(Integer.toString(odpovediHrace[3]));

        rightOneBtn.setEnabled(true);
        rightTwoBtn.setEnabled(true);
        rightThreeBtn.setEnabled(true);
        rightFourBtn.setEnabled(true);
        zadaniTxt.setText(h.getOtazka().getQuestionPhrase());

    }
*/

