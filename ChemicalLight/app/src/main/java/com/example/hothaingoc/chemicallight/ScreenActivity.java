package com.example.hothaingoc.chemicallight;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ScreenActivity extends AppCompatActivity {

    ViewPager viewPager;
    SlideAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        initScreen();
    }

    private void initScreen() {

        //slide intro
        viewPager = (ViewPager) findViewById(R.id.vp_intro);
        myAdapter = new SlideAdapter(this);
        viewPager.setAdapter(myAdapter);

        //auto change activity
        CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                //Change screen
                //Toast.makeText(ScreenActivity.this, "Time out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ScreenActivity.this,HomeActivity.class);
                startActivity(intent);

            }
        };
        countDownTimer.start();
    }
}
