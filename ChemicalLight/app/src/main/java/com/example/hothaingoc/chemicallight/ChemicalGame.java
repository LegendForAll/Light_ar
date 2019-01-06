package com.example.hothaingoc.chemicallight;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ChemicalGame extends AppCompatActivity {

    TextView textView_element;
    TextView textView_score;
    Button buttonA, buttonB, buttonStart;
    int isAns;
    int status; //-1: start; 0: run; 1: stop
    int currentScore;


    final String DATABASE_NAME = "arenadata.sqlite";
    SQLiteDatabase sqLiteDatabase;
    ArrayList<data_Element> arrayList;
    adapter_Element dataA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical_game);

        initView();
        actionAns();
    }

    private void stateStatus(int currentStatus){
        switch (currentStatus){
            case -1: {
                status = 0;
                buttonStart.setText("Stop");
                buttonA.setVisibility(View.VISIBLE);
                buttonB.setVisibility(View.VISIBLE);
                requestion();
                break;
            }
            //run
            case 0: {
                status = 1;
                buttonStart.setText("Continue");
                buttonA.setVisibility(View.INVISIBLE);
                buttonB.setVisibility(View.INVISIBLE);
                break;
            }
            //stop
            case 1: {
                status = 0;
                buttonStart.setText("Stop");
                buttonA.setVisibility(View.VISIBLE);
                buttonB.setVisibility(View.VISIBLE);
                break;
            }
            default: break;
        }
    }

    private void actionAns() {

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stateStatus(status);
            }
        });

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAns == 0){
                    buttonA.setBackground(new ColorDrawable(Color.GREEN));
                }
                else {
                    buttonA.setBackground(new ColorDrawable(Color.RED));
                }
                //requestion();
                countTimer(1500);
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAns == 1){
                    buttonB.setBackground(new ColorDrawable(Color.GREEN));
                }
                else {
                    buttonB.setBackground(new ColorDrawable(Color.RED));
                }
                countTimer(1500);
            }
        });
    }

    private void requestion(){

        //random
        int min = 1;
        int max = 118;
        Random r = new Random();
        int i1 = r.nextInt(max - min + 1) + min;
        int ar = r.nextInt(2);

        //reset color
        buttonA.setBackground(new ColorDrawable(Color.TRANSPARENT));
        buttonB.setBackground(new ColorDrawable(Color.TRANSPARENT));


        //data question
        sqLiteDatabase = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Element WHERE Atomic_Number = ? ",new String[]{String.valueOf(i1)});
        cursor.moveToFirst();

        //init questions
        String quesName = cursor.getString(3);
        Float ansTrue = cursor.getFloat(1);
        Float ansFalse = ansTrue + Float.valueOf(i1);
        textView_element.setText(quesName);


        Toast.makeText(this, String.valueOf(ar), Toast.LENGTH_SHORT).show();
        isAns = ar;
        switch (isAns){

            case 0: {
                buttonA.setText(String.valueOf(ansTrue));
                buttonB.setText(String.valueOf(ansFalse));
                break;
            }
            case 1: {
                buttonA.setText(String.valueOf(ansFalse));
                buttonB.setText(String.valueOf(ansTrue));
                break;
            }
        }

    }

    private void countTimer(int timeSize){
        CountDownTimer countDownTimer = new CountDownTimer(timeSize,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                requestion();
            }
        };
        countDownTimer.start();
    }

    private void initView() {

        isAns = -1;
        currentScore = 0;
        status = -1;

        textView_element = (TextView) findViewById(R.id.txt_NameElement);
        textView_score = (TextView) findViewById(R.id.txt_score);
        buttonA = (Button) findViewById(R.id.btn_anA);
        buttonB = (Button) findViewById(R.id.btn_anB);
        buttonA.setVisibility(View.INVISIBLE);
        buttonB.setVisibility(View.INVISIBLE);
        buttonStart = (Button) findViewById(R.id.btn_start);
    }
}
