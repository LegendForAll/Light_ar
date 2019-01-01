package com.example.hothaingoc.chemicallight;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton fabM, fabL, fabR, fabT, fabB;
    Animation move_L, move_R, move_T, move_B;
    Animation back_L, back_R, back_T, back_B;
    boolean isMove =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        actionBTN();
    }

    private void actionBTN() {

        fabM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isMove){
                    moveAnimation();
                    isMove = true;
                }
                else {
                    backAnimation();
                    isMove = false;
                }
            }
        });

        fabL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Left", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,ChemicalElement.class);
                startActivity(intent);
            }
        });

        fabR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Right", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, ChemicalEquation.class);
                startActivity(intent);
            }
        });

        fabT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Top", Toast.LENGTH_SHORT).show();
            }
        });

        fabB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Bottom", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initView() {

        fabM = (FloatingActionButton) findViewById(R.id.fabMaster);
        fabL = (FloatingActionButton) findViewById(R.id.fab_left);
        fabR = (FloatingActionButton) findViewById(R.id.fab_right);
        fabT = (FloatingActionButton) findViewById(R.id.fab_top);
        fabB = (FloatingActionButton) findViewById(R.id.fab_bottom);

        //Animation move tools
        move_L = AnimationUtils.loadAnimation(this,R.anim.move_left);
        move_R = AnimationUtils.loadAnimation(this,R.anim.move_right);
        move_T = AnimationUtils.loadAnimation(this,R.anim.move_top);
        move_B = AnimationUtils.loadAnimation(this,R.anim.move_bottom);

        //Animation back tools
        back_L = AnimationUtils.loadAnimation(this,R.anim.back_left);
        back_R = AnimationUtils.loadAnimation(this,R.anim.back_right);
        back_T = AnimationUtils.loadAnimation(this,R.anim.back_top);
        back_B = AnimationUtils.loadAnimation(this,R.anim.back_bottom);
    }

    private void moveAnimation(){
        //left
        FrameLayout.LayoutParams paramsL = (FrameLayout.LayoutParams) fabL.getLayoutParams();
        paramsL.rightMargin = (int) (fabL.getWidth() * 1.5);
        fabL.setLayoutParams(paramsL);
        fabL.startAnimation(move_L);

        //right
        FrameLayout.LayoutParams paramsR = (FrameLayout.LayoutParams) fabR.getLayoutParams();
        paramsR.leftMargin = (int) (fabR.getWidth() * 1.5);
        fabR.setLayoutParams(paramsR);
        fabR.startAnimation(move_R);

        //top
        FrameLayout.LayoutParams paramsT = (FrameLayout.LayoutParams) fabT.getLayoutParams();
        paramsT.bottomMargin = (int) (fabT.getHeight() * 1.5);
        fabT.setLayoutParams(paramsT);
        fabT.startAnimation(move_T);

        //bottom
        FrameLayout.LayoutParams paramsB = (FrameLayout.LayoutParams) fabB.getLayoutParams();
        paramsB.topMargin = (int) (fabB.getHeight() * 1.5);
        fabB.setLayoutParams(paramsB);
        fabB.startAnimation(move_B);
    }

    private void backAnimation() {

        //left
        FrameLayout.LayoutParams paramsL = (FrameLayout.LayoutParams) fabL.getLayoutParams();
        paramsL.rightMargin -= (int) (fabL.getWidth() * 1.5);
        fabL.setLayoutParams(paramsL);
        fabL.startAnimation(back_L);

        //right
        FrameLayout.LayoutParams paramsR = (FrameLayout.LayoutParams) fabR.getLayoutParams();
        paramsR.leftMargin -= (int) (fabR.getWidth() * 1.5);
        fabR.setLayoutParams(paramsR);
        fabR.startAnimation(back_R);

        //top
        FrameLayout.LayoutParams paramsT = (FrameLayout.LayoutParams) fabT.getLayoutParams();
        paramsT.bottomMargin -= (int) (fabT.getHeight() * 1.5);
        fabT.setLayoutParams(paramsT);
        fabT.startAnimation(back_T);

        //bottom
        FrameLayout.LayoutParams paramsB = (FrameLayout.LayoutParams) fabB.getLayoutParams();
        paramsB.topMargin -= (int) (fabB.getHeight() * 1.5);
        fabB.setLayoutParams(paramsB);
        fabB.startAnimation(back_B);
    }
}
