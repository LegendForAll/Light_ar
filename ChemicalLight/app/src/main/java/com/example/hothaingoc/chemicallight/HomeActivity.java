package com.example.hothaingoc.chemicallight;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    CardView cEle;
    CardView cEque;
    CardView cIdea;
    CardView cGame;
    CardView cNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }

    private void initView() {
        cEle = (CardView) findViewById(R.id.carEle);
        cEque = (CardView) findViewById(R.id.carEque);
        cIdea = (CardView) findViewById(R.id.carIdea);
        cGame = (CardView) findViewById(R.id.carGame);
        cNote = (CardView) findViewById(R.id.carInfor);

        //add click listener
        cEle.setOnClickListener(this);
        cEque.setOnClickListener(this);
        cIdea.setOnClickListener(this);
        cGame.setOnClickListener(this);
        cNote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()){
            case R.id.carEle:{
                intent = new Intent(HomeActivity.this,ChemicalElement.class);
                startActivity(intent);
                break;
            }
            case R.id.carEque:{
                intent = new Intent(HomeActivity.this,ChemicalEquation.class);
                startActivity(intent);
                break;
            }
            case R.id.carGame:{
                intent = new Intent(HomeActivity.this,ChemicalGame.class);
                startActivity(intent);
                break;
            }
            case R.id.carInfor:{
                intent = new Intent(HomeActivity.this,ChemicalNote.class);
                startActivity(intent);
                break;
            }
            default: break;
        }

    }
}
