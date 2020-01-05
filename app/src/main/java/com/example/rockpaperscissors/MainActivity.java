package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

import java.security.PublicKey;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRock, btnPaper, btnScissor, btnReset;
    TextView txtViewScore, txtViewEnemy, txtViewTimer;

    public static int myScore = 0;
    public static int myTime = 60;


    public static String randEnemy(){


        // String arrayEnemy[]={"Rock","Paper","Scissor"};
        String[] arrayEnemy = new String[3];
        arrayEnemy[0] = "Rock";
        arrayEnemy[1] = "Paper";
        arrayEnemy[2] = "Scissor";

        Random r = new Random();
        int randIndex = r.nextInt(arrayEnemy.length);

        return arrayEnemy[randIndex];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewEnemy = findViewById(R.id.txtViewEnemy);
        txtViewEnemy.setText(randEnemy());
        txtViewScore = findViewById(R.id.txtViewScore);
        txtViewTimer = findViewById(R.id.txtViewTimer);
        btnRock = findViewById(R.id.btnRock);
        btnPaper = findViewById(R.id.btnPaper);
        btnScissor = findViewById(R.id.btnScissor);
        btnReset = findViewById(R.id.btnReset);

        btnReset.setEnabled(false);
        final CountDownTimer cdt = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtViewTimer.setText("Time: "+String.valueOf(myTime)+"");
                myTime--;
            }
            @Override
            public void onFinish() {
                txtViewTimer.setText("Check out your score!");
                btnRock.setEnabled(false);
                btnPaper.setEnabled(false);
                btnScissor.setEnabled(false);
                btnReset.setEnabled(true);
            }
        }.start();



        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTime = 60;
                txtViewScore.setText("Score: 0");
                myScore = 0;
                cdt.start();
                btnReset.setEnabled(false);
                btnRock.setEnabled(true);
                btnPaper.setEnabled(true);
                btnScissor.setEnabled(true);
            }
        });


        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtViewEnemy.getText() == "Rock"){
                    myScore -= 1;
                    // String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
                else if(txtViewEnemy.getText() == "Paper"){

                    myScore -= 5;
                    // String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
                else if(txtViewEnemy.getText() == "Scissor"){
                    myScore += 3;
                    //String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtViewEnemy.getText() == "Rock"){
                    myScore += 3;
                    // String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
                else if(txtViewEnemy.getText() == "Paper"){

                    myScore -= 1;
                    // String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
                else if(txtViewEnemy.getText() == "Scissor"){
                    myScore -= 5;
                    //String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
            }
        });

        btnScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtViewEnemy.getText() == "Rock"){
                    myScore -= 5;
                    // String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
                else if(txtViewEnemy.getText() == "Paper"){

                    myScore += 3;
                    // String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
                else if(txtViewEnemy.getText() == "Scissor"){
                    myScore -= 1;
                    //String myScoreStr = Integer.toString(myScore);
                    txtViewScore.setText("Score: "+myScore+"");
                    txtViewEnemy.setText(randEnemy());
                }
            }
        });

    }
}
